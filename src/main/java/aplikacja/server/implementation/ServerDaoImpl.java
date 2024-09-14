package aplikacja.server.implementation;

import aplikacja.entity.Player;
import aplikacja.cache.PlayerCache;
import aplikacja.server.dao.ServerDao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa odpowiedzialna za laczenie sie z server-em gry ktory jest oddzielna aplikacja(skonteneryzowany server)
 */
public class ServerDaoImpl implements ServerDao {

    private InputStream inputStream;
    private OutputStream outputStream;

    @Override
    public void connect() {

        try {
            Socket socket = new Socket("localhost", 8080);
            this.outputStream = socket.getOutputStream();
            this.inputStream = socket.getInputStream();

            new Thread(()->{

                int _byte;
                List<Integer> byteList = new ArrayList<>();
                try {
                    while ((_byte = inputStream.read()) != -1){

                        if(_byte != 255){
                            byteList.add(_byte);
                            continue;
                        }

                        Player player = new Player(byteList.get(0),byteList.get(1),byteList.get(2),byteList.get(3));
                        System.out.println("Od servera przyszla taka zmiana: "+ player);
                        PlayerCache.updateCache(player);
                        byteList.clear();
                    }
                }catch (IOException e){
                    System.out.println("blad przy pobieraniu wiadomosci");
                }

            }).start();

        } catch (UnknownHostException e) {
            System.out.println("Host could not be found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Blad przy polaczeniu sie z serverem, gra nie bedzie multiplayer");
        }

    }


    public void sendKeyMoveEvent(byte[] playerMessage){

        try {
            if(outputStream!=null){
                outputStream.write(playerMessage);
                outputStream.write(255);
                outputStream.flush();
            }
            //loggin, outputstream is null
        }catch (IOException e){
            System.out.println("Blad przy wyslaniu wiadomosci");
        }

    }




}
