package com.example.nodecounter;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class PreOrderController {
    private Scene firstScene;
    private static Boolean isTimer = false;
    private int nodeNum = 1;
    private SoundsClass sounds = new SoundsClass();
    HashMap<Integer, Boolean> answerKey = new HashMap<>();
    public static Timer timer;
    @FXML Button backButton;
    @FXML Button startButton;
    @FXML AnchorPane mainWindow;
    @FXML AnchorPane YouWinPane;

    @FXML
    AnchorPane startBtnPane;
    @FXML
    Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF;
    @FXML
    Button buttonG, buttonH, buttonI, buttonJ, buttonK;
    @FXML
    Label timerLabel;

    @FXML
    ImageView sakuraA, sakuraB, sakuraC, sakuraD, sakuraE, sakuraF,
                sakuraG, sakuraH, sakuraI, sakuraJ, sakuraK;

    public PreOrderController(){
        answerKey.put(1, false);
        answerKey.put(2, false);
        answerKey.put(3, false);
        answerKey.put(4, false);
        answerKey.put(5, false);
        answerKey.put(6, false);
        answerKey.put(7, false);
        answerKey.put(8, false);
        answerKey.put(9, false);
        answerKey.put(10, false);
        answerKey.put(11, false);
    }

    public static Boolean madeTimerYet(){
        return isTimer;
    }
    public void makeTimer() {
        isTimer = true;
        timer = new Timer();
        timer.schedule(new changeClock(),1000L,1000L);
    }

    private class changeClock extends TimerTask {
        int time = 0;
        @Override
        public void run() {
            Platform.runLater(() -> {
                time++;
                if (time < 10) {
                    timerLabel.setText("0:0" + time + "");
                }else if (time == 10 || time <= 59){
                    timerLabel.setText("0:" + time + "");
                }
                if (time == 10){
                    timer.cancel();
                    timerLabel.setText("0:00");
                    timer.purge();
                    Alert timeOut = new Alert(Alert.AlertType.INFORMATION);
                    timeOut.setTitle("Time's Up!");
                    timeOut.setHeaderText("You've run out of time!");
                    timeOut.showAndWait();
                    restart();
                }
            });
        }
    }

    private boolean checkAnswers(){
        for (int i = 0; i < answerKey.size(); i++){
            if (Boolean.FALSE.equals(answerKey.get(i))){
                return false;
            }
        }
        return true;
    }


    private String setFontSize() {
        if (nodeNum >= 10){
            return "-fx-font:31 'bauhaus 93'";
        }
        else {
            return "-fx-font:36 'bauhaus 93'";
        }
    }

    public void setFirstScene(Scene scene) {

        firstScene = scene;
    }

    public void openStartMenu(ActionEvent actionEvent) {
        restart();
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(firstScene);
    }
    // --- end test ---

    @FXML
    protected void onStartButtonClick(){
        sounds.playConfirm();
        startBtnPane.setVisible(false);
        mainWindow.getChildren().remove(startBtnPane);
        makeTimer();
    }

    private void nodeHandler(Button button, int answerKeyNum, int correctAnswer){
        answerKey.replace(answerKeyNum, false);

        if (button.getText().equals("")) {
            sounds.playBloop();
            button.setText(String.valueOf(nodeNum));
            nodeNum++;

            if (button.getText().equals(Integer.toString(correctAnswer))) {
                answerKey.replace(answerKeyNum, true);
                button.setStyle("-fx-background-radius: 50; -fx-background-color: linear-gradient(to bottom right, #ffe0ec, #ff99c1); -fx-border-color: #fff1f7; -fx-border-radius: 50;" + setFontSize());

                if(checkAnswers() && button.getText().equals("11")){
                    setSakuraVisible();
                    YouWinPane.setVisible(true);
                    timer.cancel();
                    timer.purge();
                    timerLabel.setText("YAY!");
                    sounds.playTada();
                }
            }
            else{
                button.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }

        }else{
            sounds.playBlip();
            button.setText("");
            button.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    private void setSakuraVisible(){
        sakuraA.setVisible(true);
        sakuraB.setVisible(true);
        sakuraC.setVisible(true);
        sakuraD.setVisible(true);
        sakuraE.setVisible(true);
        sakuraF.setVisible(true);
        sakuraG.setVisible(true);
        sakuraH.setVisible(true);
        sakuraI.setVisible(true);
        sakuraJ.setVisible(true);
        sakuraK.setVisible(true);
    }
    private void setSakuraInvisible(){
        sakuraA.setVisible(false);
        sakuraB.setVisible(false);
        sakuraC.setVisible(false);
        sakuraD.setVisible(false);
        sakuraE.setVisible(false);
        sakuraF.setVisible(false);
        sakuraG.setVisible(false);
        sakuraH.setVisible(false);
        sakuraI.setVisible(false);
        sakuraJ.setVisible(false);
        sakuraK.setVisible(false);
    }

    @FXML
    protected void onButtonAClick(){
        nodeHandler(buttonA, 1, 1);
    }
    @FXML
    protected void onButtonBClick() {
        nodeHandler(buttonB, 2, 2);
    }
    @FXML
    protected void onButtonCClick() {
        nodeHandler(buttonC, 3, 7);
    }

    @FXML
    protected void onButtonDClick() {
        nodeHandler(buttonD, 4, 3);
    }

    @FXML
    protected void onButtonEClick() {
        nodeHandler(buttonE, 5, 6);
    }

    @FXML
    protected void onButtonFClick() {
        nodeHandler(buttonF, 6, 8);
    }

    @FXML
    protected void onButtonGClick() {
        nodeHandler(buttonG, 7, 9);
    }

    @FXML
    protected void onButtonHClick() {
        nodeHandler(buttonH, 8, 4);
    }

    @FXML
    protected void onButtonIClick() {
        nodeHandler(buttonI, 9, 5);
    }

    @FXML
    protected void onButtonJClick() {
        nodeHandler(buttonJ, 10, 10);
    }

    @FXML
    protected void onButtonKClick() throws InterruptedException {
        nodeHandler(buttonK, 11, 11);
    }

    @FXML
    protected void onPlayAgainButtonClick(){
        restart();
    }

    protected void resetNodes(Button button, int answerKeyNum){
        button.setText("");
        answerKey.replace(answerKeyNum,false);
        button.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
    }

    public void restart(){
        // reset timer stuff
        killTimer();
        isTimer = false;
        timerLabel.setText("0:00");

        // reset nodes
        resetNodes(buttonA,1);
        resetNodes(buttonB, 2);
        resetNodes(buttonC, 3);
        resetNodes(buttonD, 4);
        resetNodes(buttonE, 5);
        resetNodes(buttonF, 6);
        resetNodes(buttonG, 7);
        resetNodes(buttonH, 8);
        resetNodes(buttonI, 9);
        resetNodes(buttonJ, 10);
        resetNodes(buttonK, 11);

        // Hide the blossoms
        setSakuraInvisible();


        // reset the windows
        YouWinPane.setVisible(false);
        mainWindow.getChildren().add(startBtnPane);
        startBtnPane.setVisible(true);

        // reset the node counter
        nodeNum = 1;
    }

    public static void killTimer(){
        timer.cancel();
        timer.purge();
    }
}
