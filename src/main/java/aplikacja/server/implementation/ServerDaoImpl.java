package aplikacja.server.implementation;

import aplikacja.server.dao.ServerDao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

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
        } catch (UnknownHostException e) {
            System.out.println("Host could not be found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
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
