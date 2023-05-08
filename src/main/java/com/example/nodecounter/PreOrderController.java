package com.example.nodecounter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    @FXML Button PlayAgainButton;
    @FXML Button BackToMenuButton;

    @FXML
    AnchorPane startBtnPane;
    @FXML
    Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF;
    @FXML
    Button buttonG, buttonH, buttonI, buttonJ, buttonK;
    @FXML
    Label timerLabel;

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

    private void changeClock(int i){

    }
    @FXML
    protected void onButtonAClick() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        answerKey.replace(1, false);

        if (buttonA.getText().equals("")) {
            sounds.playBloop();
            buttonA.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonA.getText().equals("1")) {
                answerKey.replace(1, true);
//                sounds.playGoodSound();
                buttonA.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonA.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
                }
        }else{
            sounds.playBlip();
            buttonA.setText("");
            buttonA.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
            // error checking, but maybe not the best method
//        if (i == 1 && button1.getText().equals("")) {
//            button1.setText(String.valueOf(i));
//            i++;
//        }else if (i == 1 && button1.getText().equals("1")){
//            button1.setText("");
//            i--;
//        }
    }
    @FXML
    protected void onButtonBClick() {

        if (buttonB.getText().equals("")) {
            answerKey.replace(2, false);

            buttonB.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonB.getText().equals("2")) {
                sounds.playBloop();
                answerKey.replace(2, true);
                buttonB.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonB.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonB.setText("");
            buttonB.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }
    @FXML
    protected void onButtonCClick() {
        answerKey.replace(3, false);

        if (buttonC.getText().equals("")) {
            sounds.playBloop();
            buttonC.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonC.getText().equals("7")) {
                answerKey.replace(3, true);
                buttonC.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonC.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonC.setText("");
            buttonC.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onButtonDClick() {
        answerKey.replace(4, false);

        if (buttonD.getText().equals("")) {
            sounds.playBloop();
            buttonD.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonD.getText().equals("3")) {
                answerKey.replace(4, true);
                buttonD.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonD.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonD.setText("");
            buttonD.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onButtonEClick() {
        answerKey.replace(5, false);

        if (buttonE.getText().equals("")) {
            sounds.playBloop();
            buttonE.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonE.getText().equals("6")) {
                answerKey.replace(5, true);
                buttonE.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonE.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonE.setText("");
            buttonE.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onButtonFClick() {
        answerKey.replace(6, false);

        if (buttonF.getText().equals("")) {
            sounds.playBloop();
            buttonF.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonF.getText().equals("8")) {
                answerKey.replace(6, true);
                buttonF.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonF.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonF.setText("");
            buttonF.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onButtonGClick() {
        answerKey.replace(7, false);

        if (buttonG.getText().equals("")) {
            sounds.playBloop();
            buttonG.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonG.getText().equals("9")) {
                answerKey.replace(7, true);
                buttonG.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonG.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonG.setText("");
            buttonG.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onButtonHClick() {
        answerKey.replace(8, false);

        if (buttonH.getText().equals("")) {
            sounds.playBloop();
            buttonH.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonH.getText().equals("4")) {
                answerKey.replace(8, true);
                buttonH.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonH.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonH.setText("");
            buttonH.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onButtonIClick() {
        answerKey.replace(9, false);

        if (buttonI.getText().equals("")) {
            sounds.playBloop();
            buttonI.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonI.getText().equals("5")) {
                answerKey.replace(9, true);
                buttonI.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonI.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonI.setText("");
            buttonI.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onButtonJClick() {
        answerKey.replace(10, false);

        if (buttonJ.getText().equals("")) {
            sounds.playBloop();
            buttonJ.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonJ.getText().equals("10")) {
                answerKey.replace(10, true);
                buttonJ.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
            }
            else{
                buttonJ.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonJ.setText("");
            buttonJ.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onButtonKClick() throws InterruptedException {
        answerKey.replace(11, false);

        if (buttonK.getText().equals("")) {
            sounds.playBloop();
            buttonK.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (buttonK.getText().equals("11")) {
                answerKey.replace(11, true);
                buttonK.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: lime; -fx-border-radius: 50;" + setFontSize());
                if(checkAnswers()){
//                    mainWindow.getChildren().add(YouWinPane);
                    YouWinPane.setVisible(true);
                    timer.cancel();
                    timer.purge();
                    timerLabel.setText("YAY!");
                    sounds.playTada();

                }
            }
            else{
                buttonK.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            buttonK.setText("");
            buttonK.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;");
            nodeNum--;
        }
    }

    @FXML
    protected void onPlayAgainButtonClick(){
        restart();
    }

    public void restart(){
        // reset timer stuff
        killTimer();
        isTimer = false;
        timerLabel.setText("0:00");

        // reset nodes
        buttonA.setText("");
        answerKey.replace(1,false);
        buttonA.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonB.setText("");
        answerKey.replace(2,false);
        buttonB.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonC.setText("");
        answerKey.replace(3,false);
        buttonC.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonD.setText("");
        answerKey.replace(4,false);
        buttonD.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonE.setText("");
        answerKey.replace(5,false);
        buttonE.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonF.setText("");
        answerKey.replace(6,false);
        buttonF.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonG.setText("");
        answerKey.replace(7,false);
        buttonG.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonH.setText("");
        answerKey.replace(8,false);
        buttonH.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonI.setText("");
        answerKey.replace(9,false);
        buttonI.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonJ.setText("");
        answerKey.replace(10,false);
        buttonJ.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

        buttonK.setText("");
        answerKey.replace(11,false);
        buttonK.setStyle("-fx-background-radius: 50; -fx-background-color: #38c73a; -fx-border-color: #1d632a; -fx-border-radius: 50;" + setFontSize());

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
