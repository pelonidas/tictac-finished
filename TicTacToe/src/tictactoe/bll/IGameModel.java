/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author Stegger
 */
public interface IGameModel
{

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public void getNextPlayer( Button button);

    public int getNextPlayer();

    /**
     * Attempts to let the current player play at the given coordinates. If the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */
    public boolean play(int col, int row);

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */
    public boolean isGameOver();
    public void isGameOver(ArrayList<Button> arrayList, Button btn1, Button btn2, Button btn3, Button btn4, Button btn5, Button btn6, Button btn7, Button btn8, Button btn9, javafx.scene.control.Label label);
    /**
     * Gets the id of the winner, -1 if its a draw or if the game is still running.
     *
     * @return int id of winner, or -1 if draw or if gameOver() == false.
     */
    public int getWinner();

    /**
     * Resets the game to a new game state.
     */
    public void newGame();

    public void displayWinner(int winner, Label label);
}
