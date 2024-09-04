package aplikacja;


import aplikacja.gameBoard.GameBoard;
import aplikacja.server.ServerService;
import aplikacja.server.implementation.ServerDaoImpl;

import javax.swing.*;

public class GameStart {



    public static void main(String[] args) {
        createGameFrame();


        //ServerSocket IMP
        ServerDaoImpl serverDao = new ServerDaoImpl();
        ServerService service = new ServerService(serverDao);
        service.connect();
    }

    public static void createGameFrame(){
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