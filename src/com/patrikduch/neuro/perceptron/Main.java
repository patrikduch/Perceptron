package com.patrikduch.neuro.perceptron;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());

        primaryStage.setTitle("Perceptron by Patrik Duch");
        primaryStage.setScene(new Scene(root, 900, 575));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
