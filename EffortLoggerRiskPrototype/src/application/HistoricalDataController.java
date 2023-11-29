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
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField; // Added import for TextField
import javafx.scene.control.TextArea;


public class HistoricalDataController implements Initializable{

@FXML
TextField projName;
@FXML
TextArea textarea;


private Stage stage;
private Scene scene;
private Parent root;
private String currentFileName;

public void saveName(ActionEvent event) throws IOException {
	String name = projName.getText();
	if(!name.isEmpty()) {
		if (!isFileExists(name)) {
            currentFileName = saveNameToFile(name);
        } else {
            System.out.println("Cannot save. File with the same name already exists.");
        }
	} else {
		System.out.println("Please enter name before saving.");
	}
}

private boolean isFileExists(String name) {
    File file = new File(name + ".txt");
    return file.exists();
}

private String saveNameToFile(String name) {
    // Define the file name based on the entered name
    String fileName = name + ".txt";

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
        // Write the name to the file
        writer.write(name);
        System.out.println("Name saved to file: " + fileName);
        return fileName;
        // You can show a success message or handle it as needed.
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception, show an error message, or log it.
        return null;
    }
}

public void printText(ActionEvent event) throws IOException {
	textarea.clear();
    String text;
    File file = new File("data.txt");
    Scanner scanner = null;
    
    try {
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {  // Use hasNextLine to read entire lines
            text = scanner.nextLine();
            textarea.appendText(text);
            textarea.appendText(System.lineSeparator());  // Add newline to textarea
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } finally {
        if (scanner != null) {
            scanner.close();
        }
    }
	
}

public void saveText(ActionEvent event) throws IOException {
    if (textarea != null) {
        String newtext = textarea.getText();

        // Replace newline characters with the platform-specific line separator
        newtext = newtext.replace("\r\n", System.lineSeparator()).replace("\n", System.lineSeparator());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFileName, true))) {
            writer.write(newtext);
            writer.newLine();
            System.out.println("Text saved to file: " + currentFileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Textarea is null. Cannot save text.");
    }
}

private void updateCurrentFileName(String newName) {
    currentFileName = newName + ".txt";
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// Add a listener to projName to update currentFileName when text changes
    projName.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            updateCurrentFileName(newValue);
        }
    });
}


public void switchToEffortLoggerConsole(ActionEvent event) throws IOException {
	root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml")); //loads EffortLogger Console UI
	stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //cast source to Node and cast Node to stage
	scene = new Scene(root); //set scene as Defect Console UI
	stage.setScene(scene); //set new window to Defect Console UI
	stage.show(); //show Defect Console UI
} 

}
