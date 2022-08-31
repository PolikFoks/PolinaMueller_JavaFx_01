package com.example.polinamueller_javafx;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class HelloController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label FullNameLabel;

    @FXML
    private TextField FullName;

    @FXML
    private DatePicker GbDate;

    @FXML
    private Label GbDateLabel;

    @FXML
    private Pane PaneDataEntry, PaneResult;

    @FXML
    private Label TextLabel;

    @FXML
    private Button BtnResult, BtnDataEntry;

    @FXML
    private void handleButtonAction(ActionEvent event){
        /*
        Kontrolle der Einschaltauswahl
        Checking the on/off selection
        */
        if (event.getSource() == BtnResult){

            /*
            Vollständige Namensdaten auslesen
            Read full name data
            */
            String username = FullName.getText();
            FullNameLabel.setText(username);

            /*
            date formatting
            Datumsformatierung
            */
            DateTimeFormatter myFormatDate = DateTimeFormatter.ofPattern("dd-MM-yy");
            LocalDate myDate = GbDate.getValue();
            String myDateGb = GbDate.getEditor().getText();
            if (myDate != null){
                GbDateLabel.setText(" am " + myFormatDate.format(myDate));
            } else if (myDateGb.isEmpty()){
                  System.out.println("The date of birth field is blank");
            }else {
                GbDateLabel.setText(" am " + myDateGb);
                System.out.println(myDateGb);
            }


            PaneResult.toFront();

            if (Objects.equals(username, "")){
                TextLabel.setText(" ");
                GbDateLabel.setText("");
            }else {
                TextLabel.setText(" alles Gute zum Geburtstag ");
            }

        } else if (event.getSource() == BtnDataEntry){
            GbDateLabel.setText("");
            GbDate.setValue(null);
            FullName.clear();
            PaneDataEntry.toFront();
        }
    }

    @FXML
    void initialize() {

    }
}