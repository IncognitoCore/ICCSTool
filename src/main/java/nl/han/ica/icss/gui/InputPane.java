package nl.han.ica.icss.gui;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

@SuppressWarnings("restriction")
public class InputPane extends BorderPane {
	private TextArea content;
	private Label title;
	
	public InputPane() {
		super();
		
		title = new Label("Input (ICSS):");
		content = new TextArea();
		title.setPadding(new Insets(5, 5, 5, 5));
		
		this.setTop(title);
		this.setCenter(content);
		try {
			this.setText(new Scanner(new File("/Users/Kevin/Git/ICSS/testinput/level3.icss")).useDelimiter("\\Z").next());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void setText(String text) {
		this.content.setText(text);
	}
	public void setTextFromFile(File file) {
		try {
			this.setText(new String(Files.readAllBytes(file.toPath()), Charset.defaultCharset()));
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	public String getText() {
		return content.getText();
	}
}
