package com.internshala.JavaFXApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
	@FXML
	public Label WelcomeLabel;
	@FXML
	public ChoiceBox <String> ChoiceBox;
	@FXML
	public TextField userinputfield;
	@FXML
	public Button convertbutton;
	private static final String C_To_F = "Celcius to Fahrenhite";
	private static final String F_To_C ="Fahrenhite to Celcius";
	private boolean isC_To_F = true;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ChoiceBox.getItems().add(C_To_F);
		ChoiceBox.getItems().add(F_To_C);
		ChoiceBox.setValue(F_To_C);
		ChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue.equals(C_To_F)) {   //if user has selected C_To_F
				isC_To_F = true;
			}
			else {
				isC_To_F = false;
			}
		});
		convertbutton.setOnAction(event -> {
			convert();
		});

	}

	private void convert() {
		String input = userinputfield.getText();
		float enteredinput = 0.0f;
		try {
			enteredinput = Float.parseFloat(input);
		}
		catch (Exception e){
			warnuser();
			return;
			//no code is executed

		}
		float newtemp = 0.0f;
		if (isC_To_F){
			newtemp = (enteredinput *9/5) +32;
		}
		else{
			newtemp = (enteredinput - 32) *9/5;
		}
		display(newtemp);
	}

	private void warnuser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setContentText("Please enter valid temperature");
		alert.show();

	}

	private void display(float newtemp) {
		String unit = isC_To_F? " F" : " C";

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The New Temperature = " +newtemp + unit);
		alert.show();
	}
}
