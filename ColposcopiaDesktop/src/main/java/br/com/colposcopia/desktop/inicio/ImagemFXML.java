package br.com.colposcopia.desktop.inicio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImagemFXML {

	@FXML
	private VBox painel1;
	private List<File> files;
	private Stage stage;

	@FXML
	private void carregaImagem() {
		this.painel1.getChildren().clear();
		this.files = new ArrayList<>();
		
		FileChooser fileChooser = new FileChooser();
		Optional<List<File>> optional = Optional.ofNullable(fileChooser.showOpenMultipleDialog(null));

		if (optional.isPresent()) {

			for (int i = 0; i < optional.get().size() || i < 2; i++) {
				HBox hBox = new HBox(5);
				hBox.setPrefSize(588, 85);
				hBox.getStylesheets().add(Inicio.class.getResource("app.css").getFile());
				hBox.getStyleClass().add("root-layout");
				hBox.setAlignment(Pos.CENTER_LEFT);

				ImageView imageView = new ImageView();
				imageView.setImage(new Image("file:" + optional.get().get(i).getAbsolutePath()));
				imageView.setFitWidth(149);
				imageView.setFitHeight(88);

				Label label1 = new Label(optional.get().get(i).getAbsolutePath());
				label1.setWrapText(true);

				hBox.getChildren().add(imageView);
				hBox.getChildren().add(label1);

				painel1.getChildren().add(hBox);
			}

			this.files = optional.get();
		}
	}

	@FXML
	private void abrirPronto() {
		stage.close();
	}
	
	public List<File> getFiles() {
		return files;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
