package com.example.cmdlinedemo;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloController {

    public Button Btn1;
    public Text txt1;
    private String[] cmdArray;
    private Runtime runtime;
    private Process process;

    public void dosCommand(ActionEvent actionEvent) throws IOException {


        cmdArray = new String[2];
        cmdArray[0] = "notepad.exe";
        cmdArray[1] = "hello.txt";
        System.out.println(cmdArray[0]);
        runtime = Runtime.getRuntime();

        process = runtime.exec(cmdArray);
        txt1.setText("Notepad open and a new file Hello.txt is created ");

    }
}