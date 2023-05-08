package com.example.nodecounter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstController extends Main {
    public Button preOrderButton;
    public Button inOrderButton;
    public Button postOrderButton;
    public Button exitButton;
    public VBox mainWindow;
    @FXML
    private Label welcomeText;

    // testing switching scenes
    private Scene preOrderScene;
    private Scene inOrderScene;
    SoundsClass sounds = new SoundsClass();

    public void setPreOrderScene(Scene scene) {

        preOrderScene = scene;
    }

    public void setInOrderScene(Scene scene) {
        inOrderScene = scene;
    }

    public void openPreOrderScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(preOrderScene);
    }
    public void openInOrderScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(inOrderScene);
    }
    // -----end test ---

    @FXML
    protected void onPostOrderButtonClick() {

        welcomeText.setText("You clicked the Post-order button!");
    }
    @FXML
    protected void onExitButtonClick() {

        System.exit(0);
    }

    @FXML
    protected void onPreOrderHover(){
        preOrderButton.setStyle("-fx-background-color:linear-gradient(paleturquoise,white,paleturquoise); -fx-border-color:cyan");
        sounds.playClick();

    }
    @FXML
    protected void offPreOrderHover(){
        preOrderButton.setStyle("-fx-background-color:white; -fx-border-color:cyan");
    }
    @FXML
    protected void onInOrderHover(){
        inOrderButton.setStyle("-fx-background-color:linear-gradient(paleturquoise,white,paleturquoise); -fx-border-color:cyan");
        sounds.playClick();

    }
    @FXML
    protected void offInOrderHover(){
        inOrderButton.setStyle("-fx-background-color:white; -fx-border-color:cyan");
    }
    @FXML
    protected void onPostOrderHover(){
        postOrderButton.setStyle("-fx-background-color:linear-gradient(paleturquoise,white,paleturquoise); -fx-border-color:cyan");
        sounds.playClick();

    }
    @FXML
    protected void offPostOrderHover(){
        postOrderButton.setStyle("-fx-background-color:white; -fx-border-color:cyan");
    }
    @FXML
    protected void onExitHover(){
        exitButton.setStyle("-fx-background-color:linear-gradient(paleturquoise,white,paleturquoise); -fx-border-color:cyan");
        sounds.playClick();

    }
    @FXML
    protected void offExitHover(){
       exitButton.setStyle("-fx-background-color:white; -fx-border-color:cyan");
    }
}