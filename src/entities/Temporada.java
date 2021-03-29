package entities;

import java.util.ArrayList;
import java.util.List;

public class Temporada {

	private Integer idTemporada;
	private Integer numEpisodios;
	
	private List<Episodio> episodios = new ArrayList<>();
	
	public Temporada(Integer idTemporada, Integer numEpisodios) {
		this.idTemporada = idTemporada;
		this.numEpisodios = numEpisodios;
	}

	public Integer getIdTemporada() {
		return idTemporada;
	}

	public Integer getNumEpisodios() {
		return numEpisodios;
	}

	public List<Episodio> getEpsodios() {
		return episodios;
	}
	
	public void inserirEpisodios(Episodio episodio) {
		episodios.add(episodio);
		numEpisodios++;
	}
	
	public void excluirEpisodio(Episodio episodio) {
		episodios.remove(episodio);
		numEpisodios--;
	}
}
