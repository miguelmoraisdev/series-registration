package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Genero;
import exceptions.DomainException;
import services.ServicosDeCadastro;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ServicosDeCadastro servico = new ServicosDeCadastro();
		boolean finalizar = false;
		
		do {
			try {
				
				menuOpcoes();
				int opcao = sc.nextInt();
			
				switch (opcao) {
				case 1:
					System.out.print("Digite o id do gênero: ");
					int idGenero = sc.nextInt();
					sc.nextLine();
					System.out.println("Digite a descrição do gênero: ");
					String descricao = sc.nextLine();
					servico.cadastrarGeneros(idGenero, descricao);
					finalizar = false;
					break;
				case 2:
					System.out.print("Digite o id da série: ");
					int idSerie = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o título da série: ");
					String titulo = sc.nextLine();
					System.out.print("Digite a classe etária da série: ");
					int classificacaoEtaria = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o ano da série: ");
					int ano = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o id do gênero da série: ");
					int generoEscolhido = sc.nextInt();
					servico.cadastrarSerie(idSerie, titulo, classificacaoEtaria, ano, generoEscolhido);
					finalizar = false;
					break;
				case 3:
					System.out.print("Digite o id da série: ");
					int serieEscolhida = sc.nextInt();
					System.out.print("Digite o id da temporada: ");
					int temporadaEscolhida = sc.nextInt();
					servico.registrarTemporada(temporadaEscolhida, serieEscolhida);
					finalizar = false;
					break;
				case 4:
					System.out.print("Digite o id do episódio: ");
					int espisodioEscolhido = sc.nextInt();
					System.out.print("Digite o id da temporada: ");
					int idTemporadaEscolhida = sc.nextInt();
					servico.registrarEpisodio(espisodioEscolhido, idTemporadaEscolhida);
					finalizar = false;
					break;
				case 5:
					System.out.print("Digite o id do episódio: ");
					int idEpisodioEscolhido = sc.nextInt();
					System.out.print("Digite a duração da transmissão do episódio: ");
					int tempoDuracao = sc.nextInt();
					servico.registrarAcesso(idEpisodioEscolhido, tempoDuracao );
					finalizar = false;
					break;
				case 6:
					finalizar = true;
					break;
				default:
					System.out.println("Valor indefinido!");
				}
			}
			catch (DomainException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		} while (finalizar == false);
			
		System.out.print("Programa encerrado!");
	}

	public static void menuOpcoes() {
		System.out.println("MENU");
		System.out.println("1- Cadastrar Gênero");
		System.out.println("2- Cadastrar Série");
		System.out.println("3- Registrar Temporada");
		System.out.println("4- Registrar Episódio");
		System.out.println("5- Registrar Acesso");
		System.out.println("6- Sair do Sistema");
		
	}
}
