package aplikacja.server;

import aplikacja.server.dao.ServerDao;

public class ServerService {

    private final ServerDao serverDao;

    public ServerService(ServerDao serverDao){
        this.serverDao = serverDao;
    }

    public void connect(){
        serverDao.connect();
    }

    public void sendMessage(byte[] playerMessage){
        serverDao.sendKeyMoveEvent(playerMessage);
    }



}
