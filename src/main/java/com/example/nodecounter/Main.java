package com.example.nodecounter;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        System.setProperty("prism.lcdtext", "false");

        // Loader and pane for start menu
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
        Parent menuPane = menuLoader.load();
        Scene menuScene = new Scene(menuPane);
//        String menuCss = this.getClass().getResource("../ButtonStyles.css").toExternalForm();
//        firstScene.getStylesheets().add(menuCss);

        // Loader and pane for preOrder traversal
        FXMLLoader preOrderLoader = new FXMLLoader(getClass().getResource("preOrder.fxml"));
        Parent PreOrderPane = preOrderLoader.load();
        Scene preOrderScene = new Scene(PreOrderPane);

        // Loader and pane for inOrder traversal
        FXMLLoader inOrderLoader = new FXMLLoader(getClass().getResource("inOrder.fxml"));
        Parent inOrderPane = inOrderLoader.load();
        Scene inOrderScene = new Scene(inOrderPane);

        // Injecting second scene into controller for first scene
        FirstController firstController = menuLoader.getController();
        firstController.setPreOrderScene(preOrderScene);
        firstController.setInOrderScene(inOrderScene);

        // Injecting first scene into controller of second scene
        PreOrderController preOrderController = preOrderLoader.getController();
        preOrderController.setFirstScene(menuScene);

        InOrderController inOrderController = inOrderLoader.getController();
        inOrderController.setFirstScene(menuScene);

        primaryStage.setTitle("Node Counter 3000");
        primaryStage.setScene(menuScene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            public void handle(WindowEvent e) {
                if (PreOrderController.madeTimerYet()) {
                    PreOrderController.killTimer();
                }
                if(InOrderController.madeTimerYet()){
                    InOrderController.killTimer();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}