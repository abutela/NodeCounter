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

        // Loader and pane for preOrder traversal
        FXMLLoader preOrderLoader = new FXMLLoader(getClass().getResource("preOrder.fxml"));
        Parent PreOrderPane = preOrderLoader.load();
        Scene preOrderScene = new Scene(PreOrderPane);

        // Loader and pane for inOrder traversal
        FXMLLoader inOrderLoader = new FXMLLoader(getClass().getResource("inOrder.fxml"));
        Parent inOrderPane = inOrderLoader.load();
        Scene inOrderScene = new Scene(inOrderPane);

        FXMLLoader postOrderLoader = new FXMLLoader(getClass().getResource("postOrder.fxml"));
        Parent postOrderPane = postOrderLoader.load();
        Scene postOrderScene = new Scene(postOrderPane);

        // Injecting second scene into controller for first scene
        FirstController firstController = menuLoader.getController();
        firstController.setPreOrderScene(preOrderScene);
        firstController.setInOrderScene(inOrderScene);
        firstController.setPostOrderScene(postOrderScene);

        // Injecting first scene into controller of second scene
        PreOrderController preOrderController = (PreOrderController) preOrderLoader.getController();
        preOrderController.setFirstScene(menuScene);

        InOrderController inOrderController = (InOrderController) inOrderLoader.getController();
        inOrderController.setFirstScene(menuScene);

        PostOrderController postOrderController = (PostOrderController) postOrderLoader.getController();
        postOrderController.setFirstScene(menuScene);

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
                if(PostOrderController.madeTimerYet()){
                    PostOrderController.killTimer();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}