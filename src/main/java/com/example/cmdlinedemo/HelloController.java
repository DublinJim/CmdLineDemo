package com.example.cmdlinedemo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private static Stage popStage;
    private static Stage popStageFail;
    public Text txt1;
    private File testDir;
    private Stage mainAppStage;
    private Runtime runtime;


    private static void loadPop() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pop.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        popStage = new Stage();
        popStage.initStyle(StageStyle.UNDECORATED);
        popStage.setTitle("popup");
        popStage.setScene(scene);
        popStage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mainAppStage = HelloApplication.myStage;
popStage= new Stage();
        System.out.println("Initialised");
        runtime = Runtime.getRuntime();
        testDir = new File("Desktop");
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
        popStageFail.setScene(scene);
        popStageFail.show();

    }

    public void cancelPop() {
        popStage.hide();

    }

    public void cancelFailpop() {
        popStageFail.hide();
        cancelPop();
    }

    public void makeDir() {

        testDir = new File("Desktop");

        testDir.mkdir();
        popStage.hide();

    }

    public void deleteDir() {

        testDir.delete();
        popStage.hide();
    }

    public void loadPopout() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reuse.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
      //  Stage stage = new Stage();
        popStage.setScene(scene);
        popStage.initStyle(StageStyle.UNDECORATED);
        popStage.show();


    }
}
