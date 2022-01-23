package br.com.colposcopia.desktop.bean;

public class Imagem {
	private ExameColposcopico exame;
	private Integer id;
	private String localImagem;
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setExame(ExameColposcopico exame) {
		this.exame = exame;
	}
	
	public ExameColposcopico getExame() {
		return exame;
	}
	
	public String getLocalImagem() {
		return localImagem;
	}
	
	public void setLocalImagem(String localImagem) {
		this.localImagem = localImagem;
	}
		
	
}
