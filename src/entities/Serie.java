package entities;

import java.util.ArrayList;
import java.util.List;

public class Serie {

	private Integer idSerie;
	private String titulo;
	private Integer classificacaoEtaria;
	private Integer ano;
	
	private Genero genero;
	
	private List<Temporada> temporadas = new ArrayList<>();

	public Serie(Integer idSerie, String titulo, Integer classificacaoEtaria, Integer ano, Genero genero) {
		this.idSerie = idSerie;
		this.titulo = titulo;
		this.classificacaoEtaria = classificacaoEtaria;
		this.ano = ano;
		this.genero = genero;
	}

	public Integer getIdSerie() {
		return idSerie;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public Integer getClassificacaoEtaria() {
		return classificacaoEtaria;
	}

	public Integer getAno() {
		return ano;
	}

	public Genero getGenero() {
		return genero;
	}

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void inserirTemporada (Temporada temporada) {
		temporadas.add(temporada);
	}
	
}
