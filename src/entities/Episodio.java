package entities;

public class Episodio {

	private Integer idEpisodio;
	private String titulo;
	private Integer duracao;
	private Integer numAcesso;
	
	public Episodio(Integer idEpisodio, String titulo, Integer duracao) {
		this.idEpisodio = idEpisodio;
		this.titulo = titulo;
		this.duracao = duracao;
		this.numAcesso = 0;
	}
	
	public Integer getIdEpisodio() {
		return idEpisodio;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Integer getDuracao() {
		return duracao;
	}
	
	public Integer getNumAcesso() {
		return numAcesso;
	}
	
	
	public void registrarAcesso(int tempo) {
		if (tempo > duracao *0.80) {
			numAcesso++;
			System.out.println("Acesso registrado!");
		}
	}
	
}
