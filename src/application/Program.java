package application;

 	
import java.util.InputMismatchException;
import java.util.Scanner;

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
					System.out.print("Digite o id do g�nero: ");
					int idGenero = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite a descri��o do g�nero: ");
					String descricao = sc.nextLine();
					servico.cadastrarGeneros(idGenero, descricao);
					finalizar = false;
					break;
				case 2:
					System.out.print("Digite o id da s�rie: ");
					int idSerie = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o t�tulo da s�rie: ");
					String titulo = sc.nextLine();
					System.out.print("Digite a classe et�ria da s�rie: ");
					int classificacaoEtaria = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o ano da s�rie: ");
					int ano = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o id do g�nero da s�rie: ");
					int generoEscolhido = sc.nextInt();
					servico.cadastrarSerie(idSerie, titulo, classificacaoEtaria, ano, generoEscolhido);
					finalizar = false;
					break;
				case 3:
					System.out.print("Digite o id da s�rie: ");
					int serieEscolhida = sc.nextInt();
					System.out.print("Digite o id da temporada: ");
					int temporadaEscolhida = sc.nextInt();
					servico.registrarTemporada(temporadaEscolhida, serieEscolhida);
					finalizar = false;
					break;
				case 4:
					System.out.print("Digite o id do epis�dio: ");
					int espisodioEscolhido = sc.nextInt();
					System.out.print("Digite o id da temporada: ");
					int idTemporadaEscolhida = sc.nextInt();
					System.out.print("Digite o id da s�rie: ");
					int serieDoEpsodio = sc.nextInt();
					sc.nextLine();
					servico.registrarEpisodio(espisodioEscolhido, idTemporadaEscolhida, serieDoEpsodio);
					finalizar = false;
					break;
				case 5:
					System.out.print("Digite o id da temporada: ");
					int idDaTemporadaEscolhida = sc.nextInt();
					System.out.print("Digite o id da s�rie: ");
					int idSerieEscolhida = sc.nextInt();
					sc.nextLine();
					System.out.print("Digite o id do epis�dio: ");
					int idEpisodioEscolhido = sc.nextInt();
					System.out.print("Digite a dura��o da transmiss�o do epis�dio: ");
					int tempoDuracao = sc.nextInt();
					servico.registrarAcesso(idDaTemporadaEscolhida, idSerieEscolhida, idEpisodioEscolhido, tempoDuracao);
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
		catch (InputMismatchException e) {
			System.out.println("Entre com informa��es v�lidas!");
			sc.nextLine();
		}
			
		} while (finalizar == false);
			
		System.out.print("Programa encerrado!");
		sc.close();
	}

	public static void menuOpcoes() {
		System.out.println("MENU");
		System.out.println("1- Cadastrar G�nero");
		System.out.println("2- Cadastrar S�rie");
		System.out.println("3- Registrar Temporada");
		System.out.println("4- Registrar Epis�dio");
		System.out.println("5- Registrar Acesso");
		System.out.println("6- Sair do Sistema");
		
	}
}
