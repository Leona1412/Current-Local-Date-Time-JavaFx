package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GermanClock extends Application {
    @Override
    public void start(Stage stage) throws IOException {
  Label label = new Label();
        VBox vBox= new VBox();
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}