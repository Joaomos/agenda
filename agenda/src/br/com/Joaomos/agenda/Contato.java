package br.com.Joaomos.agenda;

import java.util.Objects;

public class Contato {
	private String nome;
	private Long telefone;
	private String email;
	
	
	
	public Contato(String nome, Long telefone, String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Nome = " + nome + "\n"
				+ "Telefone = " + telefone  + "\n"
				+ "Email = " + email + "\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Contato contato = (Contato) obj;
		return nome.equals(contato.nome) && telefone.equals(contato.telefone);
	}
	
	@Override
	public int hashCode() {
	        return Objects.hash(telefone);
	}
}
