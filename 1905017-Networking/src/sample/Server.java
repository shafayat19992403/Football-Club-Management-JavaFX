package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;
    public HashMap<String, Player> MarketPlayers;
    public static List<Player> PlayerListinServer;
    public static List<Club> ClubListinServer;

    Server() {
        userMap = new HashMap<>();
        userMap.put("Manchester United", "a");
        userMap.put("Manchester City", "b");
        userMap.put("Chelsea", "c");
        userMap.put("Liverpool", "d");
        userMap.put("Arsenal", "e");
        build();
        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(userMap, networkUtil,ClubListinServer,MarketPlayers);
    }
    public void build(){
        try {
            PlayerListinServer=Builder.readFromFile();
            ClubListinServer=Builder.BuildClubList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
