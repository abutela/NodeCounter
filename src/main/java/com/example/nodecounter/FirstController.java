package com.example.nodecounter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FirstController extends Main {
    @FXML
    public Button preOrderButton, inOrderButton, postOrderButton, exitButton, soundButton;

    @FXML
    public VBox mainWindow;

    @FXML
    private ImageView soundImg, muteImg;
    private Scene preOrderScene, inOrderScene, postOrderScene;
    SoundsClass sounds = SoundsClass.getInstance();

    public void setPreOrderScene(Scene scene) {

        preOrderScene = scene;
    }

    public void setInOrderScene(Scene scene) {

        inOrderScene = scene;
    }
    public void setPostOrderScene(Scene scene){
        postOrderScene = scene;
    }

    public void openPreOrderScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(preOrderScene);
    }
    public void openInOrderScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(inOrderScene);
    }

    public void openPostOrderScene(ActionEvent actionEvent){
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(postOrderScene);
    }
    // -----end test ---

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

    @FXML
    protected void onSoundButtonClick() {
        if (soundImg.isVisible()){
            soundImg.setVisible(false);
            muteImg.setVisible(true);
            sounds.setMute();
        }
        else{
            soundImg.setVisible(true);
            muteImg.setVisible(false);
            sounds.unMute();
        }
    }

    public Boolean isMuted(){
        return muteImg.isVisible();
    }
}