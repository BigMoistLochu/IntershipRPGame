package aplikacja.gameBoard.ui;


import aplikacja.model.Player;

import java.awt.*;


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
                paintText(graphics, ">>>PRESS ENTER TO START<<<", 6 * TILE_SIZE, 16 * TILE_SIZE);
                break;
            case 2:
                if(startTime==0) startTime = System.currentTimeMillis();
                paintText(graphics, "" + drawTimeAndCountScore(), 20 * TILE_SIZE, 17 * TILE_SIZE);
                paintText(graphics, "Score: " + player.getScore(), 18 * TILE_SIZE, 13 * TILE_SIZE);
                //Question
                paintText(graphics, "Jaka jest roznica miedzy metodami equals() a == w Javie?", 1 * TILE_SIZE, 13 * TILE_SIZE);
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
                paintText(graphics, "Ile w javie jest modyfikatorow dostepu?", 1 * TILE_SIZE, 13 * TILE_SIZE);
                paintText(graphics, "a) 1", 1 * TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, "b) 3", 1 * TILE_SIZE, 15 * TILE_SIZE);
                paintText(graphics, "c) 2", 1 * TILE_SIZE, 16 * TILE_SIZE);
                paintText(graphics, "d) 4", 1 * TILE_SIZE, 17 * TILE_SIZE);
                break;
            case 4:
                if(startTime==0) startTime = System.currentTimeMillis();
                paintText(graphics, "" + drawTimeAndCountScore(), 20 * TILE_SIZE, 17 * TILE_SIZE);
                paintText(graphics, "Score: " + player.getScore(), 18 * TILE_SIZE, 13 * TILE_SIZE);
                //Question
                paintText(graphics, "Co to jest garbage collector w Javie?", 1 * TILE_SIZE, 13 * TILE_SIZE);
                paintText(graphics, "a) Narzędzie do zbierania błędów w kodzie.", 1 * TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, "b) Proces usuwania nieużywanych obiektów w celu zwolnienia pamięci.", 1 * TILE_SIZE, 15 * TILE_SIZE);
                paintText(graphics, "c) Zbiór klas systemowych.", 1 * TILE_SIZE, 16 * TILE_SIZE);
                paintText(graphics, "d) Mechanizm automatycznego zamykania połączeń sieciowych.", 1 * TILE_SIZE, 17 * TILE_SIZE);
                break;
            case 5:
                if(startTime==0) startTime = System.currentTimeMillis();
                paintText(graphics, "" + drawTimeAndCountScore(), 20 * TILE_SIZE, 17 * TILE_SIZE);
                paintText(graphics, "Score: " + player.getScore(), 18 * TILE_SIZE, 13 * TILE_SIZE);
                //Question
                paintText(graphics, "Która metoda jest używana do uruchomienia wątku w Javie?", 1 * TILE_SIZE, 13 * TILE_SIZE);
                paintText(graphics, "a) execute()", 1 * TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, "b) run()", 1 * TILE_SIZE, 15 * TILE_SIZE);
                paintText(graphics, "c) start()", 1 * TILE_SIZE, 16 * TILE_SIZE);
                paintText(graphics, "d) init()", 1 * TILE_SIZE, 17 * TILE_SIZE);
                break;
            case 6:
                if(startTime==0) startTime = System.currentTimeMillis();
                paintText(graphics, "" + drawTimeAndCountScore(), 20 * TILE_SIZE, 17 * TILE_SIZE);
                paintText(graphics, "Score: " + player.getScore(), 18 * TILE_SIZE, 13 * TILE_SIZE);
                //Question
                paintText(graphics, "Co oznacza słowo kluczowe final przy metodzie?", 1 * TILE_SIZE, 13 * TILE_SIZE);
                paintText(graphics, "a) Metoda automatycznie jest prywatna", 1 * TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, "b) Metody nie mozna nadpisac", 1 * TILE_SIZE, 15 * TILE_SIZE);
                paintText(graphics, "c) Metoda nie może zwracać wartości.", 1 * TILE_SIZE, 16 * TILE_SIZE);
                paintText(graphics, "d) Metoda zwraca stala wartosc", 1 * TILE_SIZE, 17 * TILE_SIZE);
                break;
            case 7:
                if(startTime==0) startTime = System.currentTimeMillis();
                paintText(graphics, "" + drawTimeAndCountScore(), 20 * TILE_SIZE, 17 * TILE_SIZE);
                paintText(graphics, "Score: " + player.getScore(), 18 * TILE_SIZE, 13 * TILE_SIZE);
                //Question
                paintText(graphics, "Który z poniższych mechanizmów służy do obsługi wyjątków?", 1 * TILE_SIZE, 13 * TILE_SIZE);
                paintText(graphics, "a) try-catch-finally", 1 * TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, "b) if-else", 1 * TILE_SIZE, 15 * TILE_SIZE);
                paintText(graphics, "c) switch-case", 1 * TILE_SIZE, 16 * TILE_SIZE);
                paintText(graphics, "d) throw-return", 1 * TILE_SIZE, 17 * TILE_SIZE);
                break;
            case 8:
                paintText(graphics, "Gratulacje! Twoj wynik to: " + player.getScore(), TILE_SIZE, 48 * 13);
                paintText(graphics, "Jesli sposobala Ci sie gra mozesz przejzec tez inne projekty na githubie", TILE_SIZE, 14 * TILE_SIZE);
                paintText(graphics, "A jesli zainteresowala Cie moja osoba pisz na email: konrad.krok1@gmail.com", TILE_SIZE, 15 * TILE_SIZE);
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
        if(dialogStatus==3 && xyPosition[0] == 16 && xyPosition[1] == 8) return true;
        if(dialogStatus==4 && xyPosition[0] == 8 && xyPosition[1] == 8) return true;
        if(dialogStatus==5 && xyPosition[0] == 12 && xyPosition[1] == 8) return true;
        if(dialogStatus==6 && xyPosition[0] == 8 && xyPosition[1] == 8) return true;
        if(dialogStatus==7 && xyPosition[0] == 4 && xyPosition[1] == 8) return true;

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
