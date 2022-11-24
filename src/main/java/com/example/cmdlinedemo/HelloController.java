package com.example.cmdlinedemo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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

    public static Button btnCancel;
    private static Stage popStage;
    public Button Btn1;
    public Text txt1;
    public Button btnRestart;
    private String[] cmdArray;
    private Runtime runtime;
    private Process process;
    private Popup popup;
    private Label popupLbl;
    private Label popupLbl2;
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
private static void loadCheck()
{

}
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

    public void popUpWindowVbox(ActionEvent actionEvent) {
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

    public void loadFxmlPopup(ActionEvent actionEvent) throws IOException {
        loadPop();

    }

    public void restartAll(ActionEvent actionEvent) {
        Platform.exit();

    }

    public void cancelAll(ActionEvent actionEvent) {
        popStage.hide();

    }

}