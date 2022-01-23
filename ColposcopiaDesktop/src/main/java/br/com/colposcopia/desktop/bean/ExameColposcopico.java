package br.com.colposcopia.desktop.bean;

public class ExameColposcopico {
	private String dataExame, dataHora, descricaoMacro, avaliacao, achadosColpoNormais, achadosColpoANormais, outroAnormais, conclusao,nomePaciente,dataNascimento;
	
	public String getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getDataExame() {
		return dataExame;
	}
	
	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}
	
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getDescricaoMacro() {
		return descricaoMacro;
	}

	public void setDescricaoMacro(String descricaoMacro) {
		this.descricaoMacro = descricaoMacro;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getAchadosColpoNormais() {
		return achadosColpoNormais;
	}

	public void setAchadosColpoNormais(String achadosColpoNormais) {
		this.achadosColpoNormais = achadosColpoNormais;
	}

	public String getAchadosColpoANormais() {
		return achadosColpoANormais;
	}

	public void setAchadosColpoANormais(String achadosColpoANormais) {
		this.achadosColpoANormais = achadosColpoANormais;
	}

	public String getOutroAnormais() {
		return outroAnormais;
	}

	public void setOutroAnormais(String outroAnormais) {
		this.outroAnormais = outroAnormais;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	
	
}
