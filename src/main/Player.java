package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Player extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	int windowWidth = 1920 / 3;
	int windowHeight = 1080 / 3;
	
	Scene videoScene;
	Stage window;

	@SuppressWarnings("all")
	public void start(Stage window) throws Exception {

		this.window = window;
		
		// Create containers ================================================

		VBox root = new VBox();
		VBox text = new VBox();
		WebView webview = new WebView();
		
		//Create scenes ====================================================
		
		Scene startScene = new Scene(root, windowWidth / 2, windowHeight / 1.5);
		videoScene = new Scene(webview, windowWidth, windowHeight);

		// Create content for scenes =======================================
		
		Label idLabel = new Label("Enter video ID");
		Label idExample = new Label("Example: http://www.youtube.com/watch?v='THIS PART'");
		TextField idText = new TextField();
		Button idSubmit = new Button();
		
		// Styling ==========================================================
		
		root.setAlignment(Pos.TOP_CENTER);
		
		idLabel.setAlignment(Pos.CENTER);
		idLabel.setStyle("-fx-font-size: 2.5em;");
		idLabel.setMinSize(windowWidth / 2, 40);
		idLabel.setMaxSize(windowWidth / 2, 40);
		idLabel.setTranslateY(25);
		
		idExample.setAlignment(Pos.CENTER);
		idExample.setMinSize(windowWidth / 2, 20);
		idExample.setMaxSize(windowWidth / 2, 20);
		idExample.setTranslateY(30);
		
		idText.setMinSize(250, 30);
		idText.setMaxSize(250, 30);
		idText.setTranslateY(45);
		
		idSubmit.setStyle("-fx-font-size: 1.5em;");
		idSubmit.setTranslateY(60);
		
		// Button action ====================================================
		
		// exmaple video: I-46P6hZnuk
		idSubmit.setText("Submit");
		idSubmit.setOnMouseClicked(e -> {
			webview.getEngine().load("http://www.youtube.com/watch_popup?v=" + idText.getText());
			webview.setPrefSize(windowWidth, windowHeight);
			showVideo();
		});
		
		// Add all objects to root =========================================
		
		root.getChildren().add(idLabel);
		root.getChildren().add(idExample);
		root.getChildren().add(idText);
		root.getChildren().add(idSubmit);

		// Window parameters ===============================================
		
		window.getIcons().add(new Image("/icons/icon.png"));
		window.setTitle("Eman's Video Player");
		window.setScene(startScene);
		window.setAlwaysOnTop(true);
		window.show();
	}

	// Changes scene to videoScene ========================================
	
	public void showVideo() {
		window.setScene(videoScene);
	}
}
