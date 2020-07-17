package com.internshala.JavaFXApp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		launch(args);

	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("TEMPERATURE_CONVERTER_APPLICATION");
		primaryStage.show();



	}
	private MenuBar createMenu() {
		// File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New Game"));
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> Platform.exit());
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		// Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutapp = new MenuItem("About");
		aboutapp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutapp);
		//Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}
	public static void aboutApp(){
		Alert alertdialog = new Alert(Alert.AlertType.INFORMATION);
		alertdialog.setTitle("My First Desktop Application");
		alertdialog.setHeaderText("Learning JavaFx");
		alertdialog.setContentText("I am a beginner.");
		ButtonType yesButton = new ButtonType("Yes");

		ButtonType noButton = new ButtonType("No");
		alertdialog.getButtonTypes().setAll(yesButton,noButton);
		Optional<ButtonType> clickButton = alertdialog.showAndWait();

		if (clickButton.isPresent() && clickButton.get() == yesButton){
			System.out.println("Yes Button Clicked");
		}
		if (clickButton.isPresent() && clickButton.get() == noButton){
			System.out.println("No Button Clicked");
		}



	}
}
