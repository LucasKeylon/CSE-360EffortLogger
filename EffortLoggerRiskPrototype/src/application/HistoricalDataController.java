package application;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.lang.String;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javafx.scene.control.TextArea;


public class HistoricalDataController implements Initializable{

@FXML
TextArea textarea;


private Stage stage;
private Scene scene;
private Parent root;


public void printText(ActionEvent event) throws IOException {
	textarea.clear();
	String text;
	File file = new File("data.txt");
	Scanner scanner = null;
	try {
		scanner = new Scanner(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	while (scanner.hasNext()) {
	      text = scanner.next();
	      textarea.appendText(text);
	      textarea.appendText(" ");
	    }
	    scanner.close();
	
}

public void saveText(ActionEvent event) throws IOException {
	 String newtext;
	 PrintWriter writer = new PrintWriter("data.txt", "UTF-8");
	 newtext = textarea.getText();
	 writer.println(newtext);
	 writer.close();
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
}


public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml")); //loads EffortLogger Console UI
	stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //cast source to Node and cast Node to stage
	scene = new Scene(root); //set scene as Defect Console UI
	stage.setScene(scene); //set new window to Defect Console UI
	stage.show(); //show Defect Console UI
} 

}