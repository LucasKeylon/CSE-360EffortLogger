package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("EffortLoggerConsole.fxml")); //loads EffortLogger Console UI
		primaryStage.setTitle("EffortLogger V2"); //sets title of application window
		primaryStage.setScene(new Scene(root)); //sets the shown window as the EffortLogger Console
		primaryStage.show(); //show window
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}