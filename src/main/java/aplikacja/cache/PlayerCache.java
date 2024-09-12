package aplikacja.cache;

import aplikacja.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerCache {

    public static final Map<Integer, Player> playerList = new HashMap<>();


    public static void updateCache(Player player){
        playerList.put(player.getId(),player);
        System.out.println("Gracz o id: " + player.getId() + " zostal zaktualizowany");
    }


}
