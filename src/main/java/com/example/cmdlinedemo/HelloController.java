package com.example.cmdlinedemo;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    private static Stage popStage;
    private static Stage popStageFail;

    public Text txt1;

    private Runtime runtime;
    private Popup popup;
    private Label popupLbl;
    private Stage stage;

    private static void loadPop() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pop.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        popStage = new Stage();
        popStage.initStyle(StageStyle.UNDECORATED);
        popStage.setTitle("popup");
        popStage.setScene(scene);
        popStage.show();

    }



    public void dosCommand() throws IOException {


        String[] cmdArray = new String[2];
        cmdArray[0] = "notepad.exe";
        cmdArray[1] = "NewText.txt";
        System.out.println("[Dos commands run]");
        Arrays.stream(cmdArray).forEach(System.out::println);
        Process pr = runtime.exec(cmdArray);
        txt1.setVisible(true);
        txt1.setText("Notepad opens and a new file " + cmdArray[1] + " is created ");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stage = HelloApplication.myStage;
        popupLbl = new Label("Warning");
        popup = new Popup();
        runtime = Runtime.getRuntime();
    }

    public void popUpWindow() {

        popupLbl.setText("Warning.  selecting Close will end the application");
        popupLbl.setPadding(new Insets(10.0));
        Button noBtn = new Button("Close");
        Button yesBtn = new Button("Option 2");
        noBtn.setPadding(new Insets(10));
        yesBtn.setPadding(new Insets(10));
        popupLbl.setMinWidth(50);
        popupLbl.setMinHeight(50);
        popupLbl.setStyle("-fx-background-color: gray;");
        HBox optContainer = new HBox(noBtn, yesBtn, popupLbl);
        optContainer.setPrefSize(880, 220);
        optContainer.setPadding(new Insets(10));
        optContainer.setSpacing(10.0);
        popup.getContent().add(optContainer);
        stage = HelloApplication.myStage;
        popup.show(stage);
        noBtn.setOnAction(actionEvent1 -> {
            popup.hide();
            System.out.println("in func");
            Platform.exit();
        });
    }

    public void popUpWindowVbox() {
//here we go

        popupLbl.setText("2nd label");

        Button secondPopUpButton = new Button("new button");
        secondPopUpButton.setPadding(new Insets(10));
        VBox optContainer = new VBox(secondPopUpButton, popupLbl);
        popup.getContent().add(optContainer);
        stage = HelloApplication.myStage;
        popup.show(stage);
        System.out.println("done");
    }

    public void loadFxmlPopup() throws IOException {
        loadPop();

    }

    public void restartAll() {
        Platform.exit();

    }



    public void loadCheckPop() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("failsafePop.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        popStageFail = new Stage();
        popStageFail.initStyle(StageStyle.UNDECORATED);
        popStageFail.setTitle("popup");
        popStageFail.setScene(scene);
        popStageFail.show();

    }

    public void cancelPop() {
        popStage.hide();

    }

    public void cancelFailpop() {
        popStageFail.hide();
        popStage.hide();
    }
}
