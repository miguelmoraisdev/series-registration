package entities;

public class Genero {

	private Integer idGenero;
	private String descricao;
	
	public Genero(Integer idGenero, String descricao) {
		this.idGenero = idGenero;
		this.descricao = descricao;
	}
	
	public Integer getIdGenero() {
		return idGenero;
	}
	
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
			
	
}
