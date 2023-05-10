package com.example.nodecounter;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;


public class PostOrderController {
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

    public PostOrderController(){
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
                    disableNodes();
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

    public void openFirstScene(ActionEvent actionEvent) {
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
        enableNodes();
    }

    private void nodeHandler(Button button, int answerKeyNum, int correctAnswer){
        answerKey.replace(answerKeyNum, false);

        if (button.getText().equals("")) {
            sounds.playBloop();
            button.setText(String.valueOf(nodeNum));
            nodeNum++;
            if (button.getText().equals(Integer.toString(correctAnswer))) {
                answerKey.replace(answerKeyNum, true);
                button.setStyle("-fx-background-radius: 50; -fx-background-color: goldenrod; -fx-border-width: 3; -fx-border-color: orange; -fx-border-radius: 50; -fx-border-insets: -2;-fx-effect: dropshadow(three-pass-box,#fdff9b,15,0,0,0.7);"+ setFontSize());
                button.setTextFill(WHITE);
                if(button.getText().equals("11") && checkAnswers()){
                    YouWinPane.setVisible(true);
                    timer.cancel();
                    timer.purge();
                    timerLabel.setText("YAY!");
                    disableNodes();
                    sounds.playTada();
                }
            }
            else{
                button.setTextFill(RED);
                button.setStyle("-fx-background-radius: 50; -fx-background-color: #666666; -fx-border-width: 3; -fx-border-color: linear-gradient(to bottom right, lightyellow, black); -fx-border-radius: 50; -fx-border-insets: -2;" + setFontSize());
            }
        }else{
            sounds.playBlip();
            button.setText("");
            button.setStyle("-fx-background-radius: 50; -fx-background-color: #666666; -fx-border-width: 3; -fx-border-color: linear-gradient(to bottom right, lightyellow, black); -fx-border-radius: 50; -fx-border-insets: -2;");
            nodeNum--;
        }
    }
    @FXML
    protected void onButtonAClick(){
        nodeHandler(buttonA, 1, 11);
    }
    @FXML
    protected void onButtonBClick() {

        nodeHandler(buttonB, 2, 5);
    }
    @FXML
    protected void onButtonCClick() {
        nodeHandler(buttonC, 3, 10);
    }

    @FXML
    protected void onButtonDClick() {
        nodeHandler(buttonD, 4, 3);
    }

    @FXML
    protected void onButtonEClick() {
        nodeHandler(buttonE, 5, 4);
    }

    @FXML
    protected void onButtonFClick() {
        nodeHandler(buttonF, 6, 6);
    }

    @FXML
    protected void onButtonGClick() {
        nodeHandler(buttonG, 7, 9);
    }

    @FXML
    protected void onButtonHClick() {
        nodeHandler(buttonH, 8, 1);
    }

    @FXML
    protected void onButtonIClick() {
        nodeHandler(buttonI, 9, 2);
    }

    @FXML
    protected void onButtonJClick() {
        nodeHandler(buttonJ, 10, 7);
    }

    @FXML
    protected void onButtonKClick() throws InterruptedException {
        nodeHandler(buttonK, 11, 8);
    }

    @FXML
    protected void onPlayAgainButtonClick(){

        restart();
    }

    private void resetNodes(Button NodeName, int AnswerKeyNum){
        NodeName.setText("");
        answerKey.replace(AnswerKeyNum, false);
        NodeName.setStyle("-fx-background-radius: 50; -fx-background-color: #666666; -fx-border-width: 3; -fx-border-color: yellow; -fx-border-radius: 50; -fx-border-insets: -2;");
    }

    private void disableNodes(){
        buttonA.setDisable(true);
        buttonB.setDisable(true);
        buttonC.setDisable(true);
        buttonD.setDisable(true);
        buttonE.setDisable(true);
        buttonF.setDisable(true);
        buttonG.setDisable(true);
        buttonH.setDisable(true);
        buttonI.setDisable(true);
        buttonJ.setDisable(true);
        buttonK.setDisable(true);
    }

    private void enableNodes(){
        buttonA.setDisable(false);
        buttonB.setDisable(false);
        buttonC.setDisable(false);
        buttonD.setDisable(false);
        buttonE.setDisable(false);
        buttonF.setDisable(false);
        buttonG.setDisable(false);
        buttonH.setDisable(false);
        buttonI.setDisable(false);
        buttonJ.setDisable(false);
        buttonK.setDisable(false);
    }

    public void restart(){
        // reset timer stuff
        killTimer();
        isTimer = false;
        timerLabel.setText("0:00");

        // reset nodes
        resetNodes(buttonA, 1);
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
