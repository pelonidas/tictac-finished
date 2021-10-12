/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;


import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

/**
 * @author Stegger
 */
public class GameBoard implements IGameModel {

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    private int player = 0;
    private final int winner = 0;

    public void getNextPlayer(Button button) {
        //TODO Implement this method
        if (player % 2 == 0) {
            button.setText("X");
            player = 1;
        } else {
            button.setText("O");
            player = 0;
        }
    }


    public int getNextPlayer() {
        return 0;
    }


    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row) {
        //TODO Implement this method

        return true;
    }

    public boolean isGameOver() {
        //TODO Implement this method
        return false;
    }

    public void isGameOver(ArrayList<Button> arrayList, Button btn1, Button btn2, Button btn3, Button btn4, Button btn5, Button btn6, Button btn7, Button btn8, Button btn9, javafx.scene.control.Label label) {

        for (int i = 0; i < 8; i++) {
            String line = switch (i) {
                case 0 -> btn1.getText() + btn2.getText() + btn3.getText();
                case 1 -> btn4.getText() + btn5.getText() + btn6.getText();
                case 2 -> btn7.getText() + btn8.getText() + btn9.getText();
                case 3 -> btn1.getText() + btn5.getText() + btn9.getText();
                case 4 -> btn3.getText() + btn5.getText() + btn7.getText();
                case 5 -> btn1.getText() + btn4.getText() + btn7.getText();
                case 6 -> btn2.getText() + btn5.getText() + btn8.getText();
                case 7 -> btn3.getText() + btn6.getText() + btn9.getText();
                default -> null;
            };

            if (line.equals("XXX")) {
                displayWinner(winner, label);
                arrayList.forEach(button -> {
                    button.setDisable(true);
                });
            } else if (line.equals("OOO")) {
                displayWinner(winner + 1, label);
                arrayList.forEach(button -> {
                    button.setDisable(true);
                });
            }
        }
    }

    /**
     * Gets the id of the winner, -1 if its a draw. 
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner() {
        //TODO Implement this method
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame() {
        //TODO Implement this method
    }

    public void displayWinner(int winner, Label label) {
        String message = "";
        switch (winner) {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        label.setText(message);
    }

}
