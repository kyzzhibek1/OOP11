package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller;
import sample.DivisionByZeroException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();


        Controller controller = loader.getController();

        primaryStage.setTitle("Calculator App");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        try {
            controller.calculationSetup("/");
        } catch (DivisionByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
