//Lucas Keylon//

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
import java.nio.file.Paths;

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

import javafx.stage.DirectoryChooser;
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
        String name = textfield1.getText().trim(); // Trim leading and trailing spaces

        //C:\\Users\\hero1\\TEST-Workspace\\test2\\
        String folderPath = "C:\\Users\\hero1\\TEST-Workspace\\CSE 360 Assignment 5\\test2\\CSE-360EffortLogger-main"; // CHANGE BASED ON SPECIFIC USERS FOLDER LOCATION
        //WITHOUT CHANGING THE PATH, THE SEARCH FUNCTION IN THIS GUI WILL NOT WORK
        //Navigate to the part of the zip file that you EXTRACTED and find the folder that houses some of the examples projects, i.e. project 1, etc
        // THEN copy your current path/url
        
        //String folderPath = Paths.get("ProjectDescription.java:");
        File selectedDirectory = new File(folderPath);

        if (selectedDirectory.exists() && selectedDirectory.isDirectory()) {
            File[] files = selectedDirectory.listFiles((dir, filename) -> filename.endsWith(".txt"));

            if (files != null) {
                for (File file : files) {
                    String projectName = file.getName().replace(".txt", ""); // Get the file name without the extension
                    if (projectName.equals(name)) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                textarea1.appendText(scanner.nextLine());
                                textarea1.appendText(System.lineSeparator());
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace(); // Handle file not found exception
                        }
                        return;  // Stop searching after finding the matching file
                    }
                }
            }

            // If no matching file is found
            textarea1.appendText("Project not found");
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
