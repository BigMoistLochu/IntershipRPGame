package aplikacja.gameBoard.ui;


import aplikacja.model.Player;

import java.awt.*;
import java.util.Arrays;


public class PaintDialogComponent {

    private final Player player;
    private long startTime;
    private final int TILE_SIZE = 48;

    public PaintDialogComponent(Player player){
        this.player = player;
    }

    public void paintDialogText(Graphics graphics) {
        switch (player.getDialogStatus()) {
            case 1:
                paintText(graphics, "Witamy na Rekrutacji!", TILE_SIZE, 48 * 13);
                paintText(graphics, "Zasady gry sa proste, na ekranie pojawi sie pytanie, a ty tylko stan na odpowiedniej odpowiedzi", TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, ">>>PRESS ENTER TO START<<<", 7 * TILE_SIZE, 16 * TILE_SIZE);
                break;
            case 2:
                if(startTime==0) startTime = System.currentTimeMillis();
                paintText(graphics, "" + drawTimeAndCountScore(), 20 * TILE_SIZE, 17 * TILE_SIZE);
                paintText(graphics, "Score: " + player.getScore(), 18 * TILE_SIZE, 13 * TILE_SIZE);
                //Question
                paintText(graphics, "Pytanie: Jaka jest roznica miedzy metodami equals() a == w Javie?", 1 * TILE_SIZE, 13 * TILE_SIZE);
                paintText(graphics, "a) Nie ma różnicy.", 1 * TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, "b) equals() porównuje referencje, a == porównuje wartości obiektów.", 1 * TILE_SIZE, 15 * TILE_SIZE);
                paintText(graphics, "c) == porównuje referencje, a equals() porównuje wartości obiektów.", 1 * TILE_SIZE, 16 * TILE_SIZE);
                paintText(graphics, "d) equals() i == są używane wyłącznie do porównywania typów prymitywnych.", 1 * TILE_SIZE, 17 * TILE_SIZE);
                break;
            case 3:
                if(startTime==0) startTime = System.currentTimeMillis();
                paintText(graphics, "" + drawTimeAndCountScore(), 20 * TILE_SIZE, 17 * TILE_SIZE);
                paintText(graphics, "Score: " + player.getScore(), 18 * TILE_SIZE, 13 * TILE_SIZE);
                //Question
                paintText(graphics, "Pytanie: Jaka jest roznica miedzy metodami equals() a == w Javie?", 1 * TILE_SIZE, 13 * TILE_SIZE);
                paintText(graphics, "a) Nie ma różnicy.", 1 * TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, "b) equals() porównuje referencje, a == porównuje wartości obiektów.", 1 * TILE_SIZE, 15 * TILE_SIZE);
                paintText(graphics, "c) == porównuje referencje, a equals() porównuje wartości obiektów.", 1 * TILE_SIZE, 16 * TILE_SIZE);
                paintText(graphics, "d) equals() i == są używane wyłącznie do porównywania typów prymitywnych.", 1 * TILE_SIZE, 17 * TILE_SIZE);
                break;
            case 4:
                if(startTime==0) startTime = System.currentTimeMillis();
                paintText(graphics, "Case 4", 48 * 1, 48 * 13);
                paintText(graphics, "O to pytanie! " + drawTimeAndCountScore(), 48 * 7, 48 * 16);
                break;
        }
    }

    private int drawTimeAndCountScore() {
        int remainingSeconds = calculateRemainingTime();
        if (remainingSeconds == 0) {
            startTime = 0;
            updatePlayerScoreAndStatus();
        }

        return remainingSeconds;
    }

    private int calculateRemainingTime() {
        long currentTime = System.currentTimeMillis();
        int elapsedSeconds = (int) ((currentTime - startTime) / 1000);
        int countdownTime = 10; // Czas na odpowiedz w sekundach
        int remainingSeconds = countdownTime - elapsedSeconds;

        return Math.max(remainingSeconds, 0);
    }

    private void updatePlayerScoreAndStatus() {
        if (checkPositionAndGetScore(player.getDialogStatus(), player.getXYPositionInBytes())) {
            player.setScore(player.getScore() + 100);
        }
        player.setDialogStatus(player.getDialogStatus() + 1);
    }

    private boolean checkPositionAndGetScore(int dialogStatus,byte[] xyPosition){
        //Pozycje odpowiedzi A: 4,8 | B: 8,8 | C: 12,8 | D: 16,8
        if(dialogStatus==2 && xyPosition[0] == 8 && xyPosition[1] == 8) return true;
        if(dialogStatus==3 && xyPosition[0] == 5 && xyPosition[1] == 6) return true;
        return false;
    }


    private void paintText(Graphics graphics, String text, int x, int y) {
        Graphics2D g = (Graphics2D) graphics;

        // Ustawienia czcionki i koloru tekstu
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString(text, x, y);
    }


    public void paintDialogFrame(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

        // wymiary i pozycja okna dialogowego
        int dialogX = 0;
        int dialogY = 12 * 48;
        int dialogWidth = 21 * 48;
        int dialogHeight = 6 * 48;
        int arcWidth = 35;
        int arcHeight = 35;
        int borderThickness = 5;
        int borderOffset = 5;
        int reducedWidth = dialogWidth - 2 * borderOffset;
        int reducedHeight = dialogHeight - 2 * borderOffset;
        int borderArcWidth = 25;
        int borderArcHeight = 25;

        // tlo okna dialogowego
        Color backgroundColor = new Color(0, 0, 0, 200);
        g.setColor(backgroundColor);
        g.fillRoundRect(dialogX, dialogY, dialogWidth, dialogHeight, arcWidth, arcHeight);

        // obramowanie okna dialogowego
        Color borderColor = new Color(255, 255, 255);
        g.setColor(borderColor);
        g.setStroke(new BasicStroke(borderThickness));
        g.drawRoundRect(dialogX + borderOffset, dialogY + borderOffset, reducedWidth, reducedHeight, borderArcWidth, borderArcHeight);
    }
}
