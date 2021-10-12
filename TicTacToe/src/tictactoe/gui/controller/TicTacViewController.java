/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import tictactoe.bll.GameBoard;
import tictactoe.bll.IGameModel;

/**
 *
 * @author Stegger
 */
public class TicTacViewController implements Initializable
{

    @FXML
    private Label lblPlayer;


    @FXML
    private GridPane gridPane;

    @FXML
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    private static final String TXT_PLAYER = "Player: ";
    private IGameModel game;
    ArrayList<Button> listOfButtons;
    int playerTurn = 0;


    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
            int player = game.getNextPlayer();


            if (game.play(c, r))
            {
                if (game.isGameOver())
                {
                    int winner = game.getWinner();

                }
                else
                {
                    Button btn = (Button) event.getSource();
                    String xOrO = player == 0 ? "X" : "O";
                    btn.setText(xOrO);
                    setPlayer();
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard();
        setPlayer();
        listOfButtons = new ArrayList<>(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9));
        listOfButtons.forEach(button -> {
            button.setFocusTraversable(false);
            setupButton(button);
        });
        System.out.println();
    }


    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + playerTurn);
    }

    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
            btn.setDisable(false);
        }
    }
    private void setupButton(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            button.setDisable(true);
            game.getNextPlayer(button);
            game.isGameOver(listOfButtons, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, lblPlayer);
        });
    }

}
