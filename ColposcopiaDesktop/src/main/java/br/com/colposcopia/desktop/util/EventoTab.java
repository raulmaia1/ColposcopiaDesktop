package br.com.colposcopia.desktop.util;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class EventoTab implements EventHandler<KeyEvent> {

	private TextArea novo;

	public EventoTab(TextArea novo) {
		this.novo = novo;
	}

	@Override
	public void handle(KeyEvent event) {
		if (event.getCode().equals(KeyCode.TAB)) {
			novo.requestFocus();
		}
	}

}
