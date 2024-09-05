package aplikacja.server.dao;

public interface ServerDao {



    void connect();
    void sendKeyMoveEvent(byte[] playerMessage);
}
