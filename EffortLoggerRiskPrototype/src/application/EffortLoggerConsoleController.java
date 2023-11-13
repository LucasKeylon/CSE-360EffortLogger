package application;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;

public class EffortLoggerConsoleController implements Initializable{
	
	@FXML
	private ChoiceBox<String> roleBox; //declares role dropdown box
	
	private String[] roles = {"Developer", "Engineer", "Supervisor"}; //array of selectable roles
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		roleBox.getItems().addAll(roles); //adds all roles to selection of choices
	}
	
	@SuppressWarnings("unused")
	public void getRole(ActionEvent event) {
		String role = roleBox.getValue(); //stores role
	}
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToDefectConsole(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("DefectConsole.fxml")); //loads Defect Console UI
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //cast source to Node and cast Node to stage
		scene = new Scene(root); //set scene as Defect Console UI
		stage.setScene(scene); //set new window to Defect Console UI
		stage.show(); //show Defect Console UI
	}	
	
	public void switchToDefinitions(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Definitions.fxml")); //loads definition UI
		stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //cast source to Node and cast Node to stage
		scene = new Scene(root); //set scene as definition UI
		stage.setScene(scene); //set new window to definition UI
		stage.show(); //show definition UI
	}
	
	public void switchToEffortLogEditorConsole(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("EffortLogEditorConsole.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);;
		stage.show();
	}

	public void switchToLogs(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("logs.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);;
		stage.show();
	}
	
	public void switchToHistoricalData(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("HistoricalData.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);;
		stage.show();
	}
	public void switchToDataLogs(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("dataLogs.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);;
		stage.show();
	}
	public void switchToProjectData(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("ProjectDescription.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);;
		stage.show();
	}
}
