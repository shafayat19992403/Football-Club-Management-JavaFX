package sample;

import javafx.application.Platform;

import java.io.IOException;
import java.util.HashMap;

public class ReadThread implements Runnable {
    private final Thread thr;
    private final Main main;

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        System.out.println(loginDTO.getUserName());
                        System.out.println(loginDTO.isStatus());
                        main.PlayerList = loginDTO.getClub().getPlayerListInClub();
                        // the following is necessary to update JavaFX UI components from user created threads
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (loginDTO.isStatus()) {
                                    try {
                                        main.showHomePage();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {

                                }

                            }
                        });
                    }
                        if(o instanceof HashMap){
                            HashMap<String,Player> MarketPlayers=(HashMap) o;
                            MarketPlayers.forEach((name,p)->p.show());
                            }
                        }
                    }
                }
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getNetworkUtil().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



