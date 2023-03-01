package com.kunal;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.lang.reflect.Executable;
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
    private boolean is_ctf = true;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choicebox.getItems().add(CtF);
        choicebox.getItems().add(FtC);

        choicebox.setValue(CtF);

        choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equals(CtF)){
                    is_ctf = true;
                } else {
                    is_ctf = false;
                }
            }
        });
        convertbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                convert();
            }

            private void convert() {
                float temp = 0.00f;
                String input = userinputfield.getText();
                try{ 
                    temp = Float.parseFloat(input);
                } catch (Exception e){
                    alertuser();
                    return;
                }
                float new_temp = 0.00f;
                if (is_ctf){
                    new_temp = (temp * 9/5) + 32;
                } else {
                    new_temp = (temp - 32) * 5 / 9;
                }
                DisplayTemp(new_temp);
            }

            private void alertuser() {
                Alert alertuser = new Alert(Alert.AlertType.WARNING);
                alertuser.setTitle("Wrong input");
                alertuser.setHeaderText("Wrong input in temperature ");
                alertuser.setContentText("please Enter a valid input");
                alertuser.show();
            }

            private void DisplayTemp(float newTemp) {
                String unit;
                unit = is_ctf ? "F":"C";
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Conversion");
                alert.setContentText("new temp is " + newTemp + " " +unit);
                alert.show();
            }
        });

    }
}
