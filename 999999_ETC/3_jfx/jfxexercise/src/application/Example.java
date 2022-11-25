package application;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

public class Example extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn1 = new Button("Say, Hello World");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent arg0) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn1);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First JavaFX Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}