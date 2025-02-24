package br.com.Joaomos.agenda;

import java.util.HashSet;

public class Agenda {
	HashSet<Contato> contatos = new HashSet<>();
	
	
	
	public HashSet<Contato> getContatos() {
		return contatos;
	}

	public void adicionarContato(Contato contato) {
		if (contatos.contains(contato)) {
			System.out.println("O contato já está na agenda.");
		} else {
			contatos.add(contato);
			System.out.println("Contato adicionado com sucesso!");
		}
	}
	
	public void removerContato(Contato contato) {
		Long numero = contato.getTelefone();
		
		if(contatos.isEmpty()) {
			System.out.println("A agenda está vazia."); 
			return;
		}
		
		for(Contato c : contatos) {
			if (c.getTelefone().equals(numero)) {
				contatos.remove(c);
				System.out.println("Contato removido com sucesso!");
				return;
			}
		}
		
	    System.out.println("O contato não está na agenda!");
	}
	
	public void listarContatos() {
		System.out.println("=== Contatos ===\n");
		
		if (contatos.isEmpty()) {
			System.out.println("A agenda está vazia");
			return;
		}
		for (Contato c : contatos) {
			System.out.println(c.toString());
		}
	}
	
	public void buscarContato(String nome) {
		for (Contato c : contatos) {
			if (c.getNome() != null && c.getNome().trim().equalsIgnoreCase(nome)) {
				System.out.println(c.toString());
			}
		}
		
	}
}
