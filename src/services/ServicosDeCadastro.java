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
	Scanner sc = new Scanner(System.in);
	
	public ServicosDeCadastro() {
	}
	
	public void cadastrarGeneros (int idGenero, String descricao) {
		for (Genero genero : generos) {
			if (idGenero == genero.getIdGenero()) {
				throw new DomainException("G�nero j� cadastrado!");
			}
		}
		generos.add(new Genero(idGenero, descricao));
	}
	
	public void cadastrarSerie(int idSerie, String titulo, int classificacaoEtaria, int ano, int idGenero) {
		boolean compareGenero = false;
		for (Genero genero: generos) {
			if (idGenero == genero.getIdGenero()) {
				compareGenero = true;
				Serie serie = new Serie(idSerie, titulo, classificacaoEtaria, ano, genero);
				System.out.println("ID Serie: " + serie.getIdSerie());
				series.add(serie);
			}
		}
		if (compareGenero == false) {
			throw new DomainException("Gen�ro ainda n�o cadastrado!");
		}
	}
	
	public void registrarTemporada(int temporadaEscolhida, int idSerie)  {
		boolean compareSerie = false;
	
		for (Serie serie : series) {
			if (idSerie == serie.getIdSerie()) {
				compareSerie = true;
				if (serie.getTemporadas().isEmpty()) {
					serie.inserirTemporada(new Temporada(temporadaEscolhida));	
					System.out.println("Temporada registrada!");
				}
				else {
					for (Temporada temporada: serie.getTemporadas()){
						if (temporada.getIdTemporada().equals(temporadaEscolhida)) {
							throw new DomainException("Temporada j� cadastrada!");
						}
					}
					serie.inserirTemporada(new Temporada(temporadaEscolhida));
					System.out.println("Tempoarada registrada!");
				}
			}
		}
		if (compareSerie == false) {
			throw new DomainException("S�rie ainda n�o cadastrada!");
		} 
	}
	
	public void registrarEpisodio(int idEpisodio, int temporadaEscolhida, int idSerie) {
		boolean compareSerie = false;
		boolean compareTemporada = false;
		
		System.out.print("Digite a dura��o do epis�dio: ");
		int duracao = sc.nextInt();
		sc.nextLine();
		System.out.print("Digite o titulo do epis�dio: ");
		String titulo = sc.nextLine();
		
		for (Serie serie : series) {
			if (idSerie == serie.getIdSerie()) {
				compareSerie = true;
				for (Temporada temporada: serie.getTemporadas()) {
					if (temporada.getIdTemporada().equals(temporadaEscolhida)) {
						if (temporada.getEpsodios().isEmpty()) {
							temporada.inserirEpisodios(new Episodio(idEpisodio, titulo, duracao));
							compareTemporada = true;
							System.out.println("Epis�dio registrado");
						}
						else {
							for (Episodio episodio : temporada.getEpsodios()){
								if (episodio.getIdEpisodio().equals(idEpisodio)) {
									throw new DomainException("Episodio j� cadastrado!");
								}
							}
							temporada.inserirEpisodios(new Episodio(idEpisodio, titulo, duracao));
							compareTemporada = true;
							System.out.println("Epis�dio registrado");
						}
					}
				}
				if (compareTemporada == false) {
					throw new DomainException("Temporada ainda n�o cadastrada!");
				}
			}
		}
		if (compareSerie == false) {
			throw new DomainException("S�rie ainda n�o cadastrada!");
		}
}
	
	public void registrarAcesso(int idDaTemporadaEscolhida, int idSerieEscolhida, int idEpisodio, int tempoDuracao) {
		boolean compareSerie = false;
		boolean compareTemporada = false;
		boolean compareEpisodio = false;
		
		for (Serie serie : series) {
			if (idSerieEscolhida == serie.getIdSerie()) {
				compareSerie = true;
				for (Temporada temporada: serie.getTemporadas()) {
					if (temporada.getIdTemporada().equals(idDaTemporadaEscolhida)) {
						compareTemporada = true;
						for (Episodio episodio : temporada.getEpsodios()) {
							if (episodio.getIdEpisodio().equals(idEpisodio)) {
								compareEpisodio = true;
								if (tempoDuracao > episodio.getDuracao()) {
									throw new DomainException("Dura��o fornecida maior do que a dura��o do epis�dio!");
								}
								else {
									episodio.registrarAcesso(tempoDuracao);
								}
							}
						}
						if (compareEpisodio == false) {
							throw new DomainException("Episodio ainda n�o cadastrado!");
						}
					}
				}
				if (compareTemporada == false) {
					throw new DomainException("Temporada ainda n�o cadastrada!");
				}
			}
		}
		if (compareSerie == false) {
			throw new DomainException("S�rie ainda n�o cadastrada!");
		}
}
}
