package aplikacja.gameBoard.utils;

import aplikacja.cache.PlayerCache;
import aplikacja.model.Player;
import aplikacja.gameBoard.ui.PaintDialogComponent;
import aplikacja.gameBoard.ui.PaintMapComponent;

import java.awt.*;

public class UserInterfaceService {

    private final PaintMapComponent paintMapComponent;
    private final PaintDialogComponent paintDialogComponent;
    private final Player player;

    public UserInterfaceService(Player player){
        this.player = player;
        this.paintMapComponent = new PaintMapComponent();
        this.paintDialogComponent = new PaintDialogComponent(player);
    }

    public void paintComponents(Graphics graphics){
        paintMap(graphics);
        paintPlayers(graphics);
        paintDialogFrame(graphics);
        paintTextForPlayer(graphics);
    }

    private void paintMap(Graphics graphics) {
        paintMapComponent.paintMap(graphics);
    }

    private void paintPlayers(Graphics graphics) {
        PlayerCache.playerList.forEach((key, player) -> {
            graphics.drawImage(player.getSprite(), player.getX(), player.getY(), 48, 48, null);
        });
    }

    private void paintDialogFrame(Graphics graphics){
        paintDialogComponent.paintDialogFrame(graphics);
    }

    private void paintTextForPlayer(Graphics graphics){
        paintDialogComponent.paintDialogText(graphics);
    }




}
