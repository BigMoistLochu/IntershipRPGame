package aplikacja;


import aplikacja.gameBoard.GameBoard;

import javax.swing.*;

public class Main {

    private static final JFrame window = new JFrame();

    public static void main(String[] args) {
        configMainWindowGame();
    }

    public static void configMainWindowGame(){
        window.setTitle("IntershipRPGame");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameBoard gameBoard = new GameBoard();
        window.add(gameBoard);

        window.pack();
        window.setVisible(true);
    }







}