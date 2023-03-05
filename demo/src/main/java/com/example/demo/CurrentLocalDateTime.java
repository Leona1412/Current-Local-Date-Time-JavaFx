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

public class CurrentLocalDateTime extends Application {
    private final Label labelDateTime;

    public CurrentLocalDateTime() {
        labelDateTime = new Label(printLocalDateTime());
    }

    @Override
    public void start(Stage stage) throws IOException, InterruptedException {

        labelDateTime.setTextAlignment(TextAlignment.CENTER);
        labelDateTime.setFont(new Font(25));

        VBox vBox = new VBox();
        vBox.getChildren().add(labelDateTime);

        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("Date and Time");
        stage.setScene(scene);
        stage.show();
        Thread taskThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(125);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            labelDateTime.setText(printLocalDateTime());
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
        return dateTimeFormatter.format(nowTime);
    }
}