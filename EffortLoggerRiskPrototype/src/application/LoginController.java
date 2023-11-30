package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class LoginController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private TextField userText;
	
	@FXML
	private TextField passText;
	
	@FXML
	void login(ActionEvent event) {
		if (userText.getText().equals("user") && passText.getText().equals("password"))
		{
			try {
				root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml")); //loads EffortLogger Console UI
				stage = (Stage)((Node)event.getSource()).getScene().getWindow(); //cast source to Node and cast Node to stage
				scene = new Scene(root); //set scene as EffortLogger Console UI
				stage.setScene(scene); //set new window to EffortLogger Console UI
				stage.show(); //show EffortLogger Console UI
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}