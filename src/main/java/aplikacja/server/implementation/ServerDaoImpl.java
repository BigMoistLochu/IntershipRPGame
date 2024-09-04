package aplikacja.server.implementation;

import aplikacja.server.dao.ServerDao;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Klasa odpowiedzialna za laczenie sie z server-em gry ktory jest oddzielna aplikacja(skonteneryzowany server)
 */
public class ServerDaoImpl implements ServerDao {





    @Override
    public void connect() {
      /// Nawiązanie połączenia z serwerem na localhost:8080
        try {
            Socket socket = new Socket("localhost", 8080);

            //chcesz wyslac klase Socket do innego watku i tam to obslugiwac, mozesz to zrobic w tej klasie np

            OutputStream outputToClient = socket.getOutputStream();
            String message = "Witam";
            outputToClient.write(message.getBytes());

            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("Host could not be found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }

    }


}
