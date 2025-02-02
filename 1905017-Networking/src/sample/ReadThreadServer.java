package sample;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;
    public HashMap<String, String> userMap;
    public HashMap<String, Player> MarketPlayers;
    List<Club>ClubListInServer;

    public ReadThreadServer(HashMap<String, String> map, NetworkUtil networkUtil, List<Club>ClubListInServer,HashMap<String, Player> MarketPlayers) {
        this.ClubListInServer=ClubListInServer;
        this.userMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        this.MarketPlayers=MarketPlayers;
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                System.out.println("I am here");
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        String password = userMap.get(loginDTO.getUserName());
                        loginDTO.setStatus(loginDTO.getPassword().equals(password));
                        for(int i=0;i<ClubListInServer.size();i++){
                            if(ClubListInServer.get(i).getName().equalsIgnoreCase(loginDTO.getUserName())){
                                loginDTO.setClub(ClubListInServer.get(i));
                                break;
                            }
                        }
                        networkUtil.write(loginDTO);
                    }
                    if(o instanceof Player){
                        System.out.println("it is working i guess");
                        Player p=(Player) o;
                        MarketPlayers.put(p.getName(),p);
                        System.out.println("it is working i guess");
                    }
                    if(o instanceof String){
                        //networkUtil.write(MarketPlayers);
                        System.out.println("Connection is solid");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



