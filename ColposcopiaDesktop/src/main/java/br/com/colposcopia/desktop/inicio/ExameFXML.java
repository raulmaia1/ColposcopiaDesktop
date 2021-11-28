package br.com.colposcopia.desktop.inicio;

import br.com.colposcopia.desktop.bean.ExameColposcopico;
import br.com.colposcopia.desktop.builder.ExameColposcopicoBuilder;
import br.com.colposcopia.desktop.dao.ExameColposcopicoJDBCDAo;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ExameFXML {
	@FXML
	private TextField textNome,textDataNasc;
	
	@FXML
	private TextArea textDescricaoMacro, textAvaliacao,
		textAchadosColpoNormais,textAchadosColpoAnormais,textOutroAnormais,textConclusao;
	
	@FXML
	private void abrirImagem() {

	}
	
	@FXML
	private void geraRelatorio() {
		ExameColposcopico exame = new ExameColposcopicoBuilder()
			.addDescricaoMacro(textDescricaoMacro.getText())
			.addAvaliacao(textAvaliacao.getText())
			.addAchadosColpoNormais(textAchadosColpoNormais.getText())
			.addAchadosColpoANormais(textAchadosColpoAnormais.getText())
			.addOutroAnormais(textOutroAnormais.getText())
			.addConclusao(textConclusao.getText())
			.build();
		
		new ExameColposcopicoJDBCDAo().adiciona(exame);
	}
	
	@FXML
	private void carregaTemplate() {

	}
}
