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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ProjectDescription implements Initializable{
	
	@FXML
	TextArea textarea1;
	@FXML
	TextField textfield1;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void printText(ActionEvent event) throws IOException {
		textarea1.clear();
		String name = textfield1.getText();
        File file = new File("data.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String projectName = scanner.nextLine();
                if (projectName.equals(name) && scanner.hasNextLine()) {
                    textarea1.appendText(scanner.nextLine());
                    textarea1.appendText(System.lineSeparator());
                    return;  // Stop reading after finding the matching line
                }
            }

            // If no matching line is found
            textarea1.appendText("Project not found");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
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