package com.example.cmdlinedemo;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
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
    public String fxml;
    public Text txt1;
    public Text txtReuse;
    public Pane rootPane;
    public Button delDirBtn;
    public Button makeDirBtn;
    private File testDir;
    private Runtime runtime;


    private static void loadPop() throws IOException {
        stageSwitcher("pop.fxml");
    }

    private static void stageSwitcher(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load());
        popStage.setScene(scene);
        popStage.initStyle(StageStyle.UNDECORATED);
        popStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        popStage = new Stage();
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
        fxml = "failsafePop.fxml";
        stageSwitcher(fxml);
    }

    public void cancelPop() {
        popStage.hide();

    }

    public void cancelFailpop() {
        popStage.hide();
        cancelPop();
    }

    public void makeDir() {

        testDir = new File("Desktop");
        testDir.mkdir();
        txtReuse.setText("Directory Created");
        buttonOkMiddle();

    }

    public void deleteDir() {

        testDir.delete();

        txtReuse.setText("Directory Deleted");
        buttonOkMiddle();

    }

    private void buttonOkMiddle() {
        delDirBtn.setLayoutX(110);
        delDirBtn.setText("Ok");
        rootPane.getChildren().remove(makeDirBtn);
        delDirBtn.setOnAction(e -> popStage.hide());
    }

    public void loadPopout() throws IOException {
        stageSwitcher("reuse.fxml");
    }

}
