package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Episodio;
import entities.Genero;
import entities.Serie;
import entities.Temporada;
import exceptions.DomainException;

public class ServicosDeCadastro {
	
	private List<Genero> generos = new ArrayList<>();
	private List<Serie> series = new ArrayList<>();
	private List<Temporada> temporadas = new ArrayList<>();
	private List<Episodio> episodios = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	public ServicosDeCadastro() {
	}
	
	public void cadastrarGeneros (int idGenero, String descricao) {
		for (Genero genero : generos) {
			if (idGenero == genero.getIdGenero()) {
				throw new DomainException("Gênero já cadastrado!");
			}
		}
		generos.add(new Genero(idGenero, descricao));
	}
	
	public void cadastrarSerie(int idSerie, String titulo, int classificacaoEtaria, int ano, int idGenero) {
		for (Genero genero : generos) {
			if (idGenero == genero.getIdGenero()) {
				Serie serie = new Serie(idSerie, titulo, classificacaoEtaria, ano, genero);
				System.out.println("ID Serie: " + serie.getIdSerie());
				series.add(serie);
			}
			else if (idGenero != genero.getIdGenero()) {
				throw new DomainException("Gênero não encontrado!");
			}
		}
	}
	
	public void registrarTemporada(int idTemporada, int idSerie)  {
		for (Serie serie : series) {
			if (idSerie == serie.getIdSerie()) {
				for (Temporada temporada : temporadas) {
					if (idTemporada != temporada.getIdTemporada()) {
						int numEpisodios = 0;
						temporadas.add(new Temporada(idTemporada, numEpisodios));    
						
					}
					else if (idTemporada == temporada.getIdTemporada()) {
						throw new DomainException("Essa temporada já está cadastrada!");
					}
				}
			}
			else if (idSerie != serie.getIdSerie()) {
				throw new DomainException("Essa série não está cadastrada!");
			}
		}
	}
	
	public void registrarEpisodio(int idEpisodio, int idTemporada) {
		for (Temporada temporada : temporadas) {
			if (idTemporada == temporada.getIdTemporada()) {
				for (Episodio episodio : episodios) {
					if (idEpisodio != episodio.getIdEpisodio()) {
						int numAcesso = 0;
						System.out.print("Digite a duração do episódio: ");
						int duracao = sc.nextInt();
						sc.nextLine();
						System.out.print("Digite o titulo do episódio: ");
						String titulo = sc.nextLine();
						episodios.add(new Episodio(idEpisodio, titulo, duracao, numAcesso));
					}
					else {
						throw new DomainException("Esse episódio já está cadastrado!");
					}
				}
			}
			else {
				throw new DomainException("Essa temporada não está cadastrada!");
			}
		}
	}
	
	public void registrarAcesso(int idEpisodio, int tempoDuracao) {
		for (Episodio episodio : episodios) {
			if (idEpisodio == episodio.getIdEpisodio()) {
				if (tempoDuracao > episodio.getDuracao()) {
					throw new DomainException("Tempo informado maior do que a duração do episódio!");
				}
				else {
					episodio.registrarAcesso(tempoDuracao);
				}	
			}
			else {
				throw new DomainException("Esse episódio não está cadastrado!");
			}
		}
	}
}
