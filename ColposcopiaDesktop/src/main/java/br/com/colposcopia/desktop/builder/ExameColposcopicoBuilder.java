package br.com.colposcopia.desktop.builder;

import br.com.colposcopia.desktop.bean.ExameColposcopico;

public class ExameColposcopicoBuilder {

	private String descricaoMacro, avaliacao, achadosColpoNormais, achadosColpoANormais, outroAnormais, conclusao;

	public ExameColposcopicoBuilder addDescricaoMacro(String descricaoMacro) {
		this.descricaoMacro = descricaoMacro;
		return this;
	}

	public ExameColposcopicoBuilder addAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
		return this;
	}

	public ExameColposcopicoBuilder addAchadosColpoNormais(String achadosColpoNormais) {
		this.achadosColpoNormais = achadosColpoNormais;
		return this;
	}

	public ExameColposcopicoBuilder addAchadosColpoANormais(String achadosColpoANormais) {
		this.achadosColpoANormais = achadosColpoANormais;
		return this;
	}

	public ExameColposcopicoBuilder addOutroAnormais(String outroAnormais) {
		this.outroAnormais = outroAnormais;
		return this;
	}

	public ExameColposcopicoBuilder addConclusao(String conclusao) {
		this.conclusao = conclusao;
		return this;
	}

	public ExameColposcopico build() {
		ExameColposcopico exameColposcopico = new ExameColposcopico();
		exameColposcopico.setAchadosColpoANormais(achadosColpoANormais);
		exameColposcopico.setAchadosColpoNormais(achadosColpoNormais);
		exameColposcopico.setAvaliacao(avaliacao);
		exameColposcopico.setConclusao(conclusao);
		exameColposcopico.setOutroAnormais(outroAnormais);
		exameColposcopico.setDescricaoMacro(descricaoMacro);
		
		return exameColposcopico;
	}
	
}
