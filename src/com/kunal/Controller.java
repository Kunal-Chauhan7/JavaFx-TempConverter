package com.kunal;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML
    public Label welcomelabel;
    @FXML
    public ChoiceBox<String> choicebox;
    public final String CtF = "Celsius to Fahrenheit";
    public final String FtC = "Fahrenheit to Celsius";
    @FXML
    public javafx.scene.control.TextField userinputfield;
    @FXML
    public javafx.scene.control.Button convertbutton;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choicebox.getItems().add(CtF);
        choicebox.getItems().add(FtC);

        choicebox.setValue(CtF);

        choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });
        convertbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button clicked");
            }
        });

    }
}
