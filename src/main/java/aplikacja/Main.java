package aplikacja;


import aplikacja.gameBoard.GameBoard;
import aplikacja.gameBoard.KeyMovementListener;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        configMainWindowGame();
    }

    public static void configMainWindowGame(){
        JFrame window = new JFrame();
        window.setTitle("IntershipRPGame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        //Create GameBoard
        GameBoard gameBoard = new GameBoard();
        window.add(gameBoard);

        window.pack();
        window.setVisible(true);
    }







}