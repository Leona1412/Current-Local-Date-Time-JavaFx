package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GermanClock extends Application  {

private   Label labelDate ;
    public GermanClock() {
        labelDate=   new Label(printLocalDateTime());
    }


    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        labelDate.setTextAlignment(TextAlignment.CENTER);
        labelDate.setFont(new Font(25));

        VBox vBox = new VBox();
        vBox.getChildren().add(labelDate);

        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("Date and Time");
        stage.setScene(scene);
        stage.show();
        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                double progress = 0;
                while (true) {

                    try {
                        Thread.sleep(125);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            labelDate.setText(printLocalDateTime());
                        }
                    });
                }
            }
        });

        taskThread.start();
    }


    public static void main(String[] args) {
        launch();
    }



    public String printLocalDateTime() {
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String timeAsString = dateTimeFormatter.format(nowTime);
        return timeAsString;

    }



}