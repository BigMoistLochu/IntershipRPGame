package aplikacja;


import aplikacja.gameBoard.GameBoard;
import aplikacja.server.ServerService;
import aplikacja.server.implementation.ServerDaoImpl;

import javax.swing.*;

public class GameStart {

    public static ServerService service;

    public static void main(String[] args) {
        //ServerSocket IMP
        ServerDaoImpl serverDao = new ServerDaoImpl();
        service = new ServerService(serverDao);
        service.connect();


        //create GameBoard
        createGameBoardAndSettings();
    }

    public static void createGameBoardAndSettings(){
        JFrame window = new JFrame();
        window.setTitle("Recruitment Showdown");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create GameBoard
        GameBoard gameBoard = new GameBoard();
        window.add(gameBoard);

        window.pack();
        window.setVisible(true);
    }







}