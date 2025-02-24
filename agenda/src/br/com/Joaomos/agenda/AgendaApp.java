package br.com.Joaomos.agenda;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgendaApp {
	Agenda agenda;
	Scanner entrada;
	
	
	public AgendaApp() {
		agenda = new Agenda();
		entrada = new Scanner(System.in);
	}

	private void exibirMenu() {
		System.out.println("\n=== Agenda ===");
		System.out.println("1 - Adicionar contato");
		System.out.println("2 - Remover contato");
		System.out.println("3 - Listar contatos");
		System.out.println("4 - Buscar contato");
		System.out.println("0 - Sair");
		System.out.println("Escolha uma opção: ");
	}
	
	private void executar() {
		int opcao;
		do {
			exibirMenu();
			opcao = entrada.nextInt();
			entrada.nextLine();
			processarOperacao(opcao);
		} while (opcao != 0);
		System.out.println("Sistema encerrado.");
		entrada.close();
	}
	
	private void processarOperacao(int opcao) {
		switch (opcao) {
		case 1:
			adicionarContato();
			break;
		case 2:
			removerContato();
			break;
		case 3:
			listarContatos();
			break;
		case 4:
			buscarContato();
			break;
		case 0:
			System.out.println("Saindo do sistema...");
			break;

		default:
			System.out.println("Opção inválida.");
			break;
		}
	}
	
	public static boolean emailValido(String email) {
    
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
	
	private void adicionarContato() {
		String nome, email;
		Long telefone;
		
		System.out.println("Digite o nome do contato: ");
		nome = entrada.nextLine().trim();
		System.out.println("Digite o telefone do contato: ");
		telefone = entrada.nextLong();
		entrada.nextLine();
		System.out.println("Digite o email do contato: ");
		email = entrada.nextLine();
		
		if(!emailValido(email)) {
			System.out.println("E-mail inválido");
			return;
		}
		
		Contato contato = new Contato(nome, telefone, email);
		agenda.adicionarContato(contato);
	}
	
	private void removerContato() {
		Long numero;
		Contato contatoARemover = null;
		
		System.out.println("Digite o numero do contato que deseja remover: ");
		numero = entrada.nextLong();
		
		for (Contato c : agenda.getContatos()) {
			if (c.getTelefone().equals(numero)) {
				contatoARemover = c;
			}
		}
		
		if (contatoARemover == null) {
			System.out.println("O contato não está na agenda.");
		} else {
			agenda.removerContato(contatoARemover);			
		}
		
	}
	
	private void listarContatos() {
		agenda.listarContatos();
	}
	
	private void buscarContato() {
		String nome;
		System.out.println("Digite o nome do contato: ");
		nome = entrada.nextLine().trim().toLowerCase();
		
		System.out.println();
		agenda.buscarContato(nome);
	}
	
	public static void main(String[] args) {
		AgendaApp sistema = new AgendaApp();
		sistema.executar();
	}
}
