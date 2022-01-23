package br.com.colposcopia.desktop.inicio;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.colposcopia.desktop.bean.ExameColposcopico;
import br.com.colposcopia.desktop.builder.ExameColposcopicoBuilder;
import br.com.colposcopia.desktop.dao.ExameColposcopicoJDBCDAo;
import br.com.colposcopia.desktop.util.EventoTab;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExameFXML implements Initializable {
	@FXML
	private TextField textNome, textDataNasc;

//	@FXML
//	private MaskedTextField ;

	@FXML
	private TextArea textDescricaoMacro, textAvaliacao, textAchadosColpoNormais, textAchadosColpoAnormais,
			textOutroAnormais, textConclusao;

	private List<File> files;

	@FXML
	private void abrirImagem() {
		try {
			Stage stage = new Stage();

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("imagem.fxml"));

			Scene scene = new Scene(loader.load());
			ImagemFXML controller = loader.getController();
			stage.setScene(scene);

			controller.setStage(stage);
			stage.showAndWait();

			this.files = controller.getFiles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void geraRelatorio() {
		ExameColposcopico exame = new ExameColposcopicoBuilder().addNomePaciente(textNome.getText())
				.addDataNascimento(textDataNasc.getText()).addDescricaoMacro(textDescricaoMacro.getText())
				.addAvaliacao(textAvaliacao.getText()).addAchadosColpoNormais(textAchadosColpoNormais.getText())
				.addAchadosColpoANormais(textAchadosColpoAnormais.getText())
				.addOutroAnormais(textOutroAnormais.getText()).addConclusao(textConclusao.getText()).build();

		new ExameColposcopicoJDBCDAo().adiciona(exame);

		new ExameColposcopicoReport().imprimir(exame);
	}

	@FXML
	private void carregaTemplate() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// textDataNasc.setMask("##/##/##");
		textDescricaoMacro.setOnKeyPressed(new EventoTab(textAvaliacao));
		textAvaliacao.setOnKeyPressed(new EventoTab(textAchadosColpoNormais));
		textAchadosColpoNormais.setOnKeyPressed(new EventoTab(textAchadosColpoAnormais));
		textAchadosColpoAnormais.setOnKeyPressed(new EventoTab(textOutroAnormais));
		textOutroAnormais.setOnKeyPressed(new EventoTab(textConclusao));

	}

}
