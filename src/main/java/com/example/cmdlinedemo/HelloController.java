package com.example.cmdlinedemo;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public Button Btn1;
    public Text txt1;
    private String[] cmdArray;
    private Runtime runtime;
    private Process process;
    private Popup popup;
    private Label popupLbl;
    private Label popupLbl2;
    private Stage stage;




    public void dosCommand() throws IOException {


        cmdArray = new String[2];
        cmdArray[0] = "notepad.exe";
        cmdArray[1] = "NewText.txt";


        Arrays.stream(cmdArray).forEach(System.out::println);

        process = runtime.exec(cmdArray);
        txt1.setVisible(true);
        txt1.setText("Notepad opens and a new file " + cmdArray[1] + " is created ");


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("first");
        stage = HelloApplication.myStage;
        txt1.setVisible(false);

        popup = new Popup();
        runtime = Runtime.getRuntime();
    }

    public void popUpWindow(ActionEvent actionEvent) {

        popupLbl = new Label("Warning");
        popupLbl.setPadding(new Insets(10.0));
        Button noBtn = new Button("Option 1");
        Button yesBtn = new Button("Option 2");

        noBtn.setPadding(new Insets(10));
        yesBtn.setPadding(new Insets(10));
        popupLbl.setMinWidth(50);
        popupLbl.setMinHeight(50);
        popupLbl.setStyle("-fx-background-color: blue;");

        VBox optContainer = new VBox(noBtn, yesBtn, popupLbl);
        popup.getContent().add(optContainer);
        stage = HelloApplication.myStage;
        popup.show(stage);
    }

    public void popUpWindowVbox(ActionEvent actionEvent) {
//here we go
        Popup popup2 = new Popup();
        popupLbl2 = new Label("Second label");

        Button secondPopUpButton = new Button("new button");
        secondPopUpButton.setPadding(new Insets(10));
        VBox optContainer = new VBox(secondPopUpButton,popupLbl2);
        popup2.getContent().add(optContainer);

        stage = HelloApplication.myStage;
        popup2.show(stage);
        System.out.println("done");
    }
}