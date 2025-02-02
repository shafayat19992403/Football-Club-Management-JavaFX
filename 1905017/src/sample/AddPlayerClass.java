package sample;

import java.util.Scanner;

public class AddPlayerClass {
    public void addNewPlayer(String info) {
        String[] Information = info.split(",");
        String CN = Information[4];
        System.out.println(CN);
        boolean ClubFound = false;

       for (int i = 0; i < Main.ClubList.size(); i++) {
            if (CN.equalsIgnoreCase(Main.ClubList.get(i).getName()) && Main.ClubList.get(i).getPlayerListInClub().size() <= 7) {
                Player p = null;
                try {
                    p = new Player(Information[0], Information[1], Information[2], Information[3], Information[4], Information[5], Information[6], Information[7]);
                } catch (PositionNotFoundException e) {
                    e.printStackTrace();
                }
                //Main.PlayerList.add(p);
                try {
                    Builder.writeToFile(p);
                    Main.PlayerList = Builder.readFromFile();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Main.ClubList = Builder.BuildClubList();
                    Main.CountryList = Builder.BuildCountryList();
                }
                ClubFound = true;
                break;
            } else if (CN.equalsIgnoreCase(Main.ClubList.get(i).getName()) && Main.ClubList.get(i).getPlayerListInClub().size() > 7) {
                System.out.println("No room left for this club");
                ClubFound = true;
            }
        }
        if (!ClubFound) {
            Player p = null;
            try {
                p = new Player(Information[0], Information[1], Information[2], Information[3], Information[4], Information[5], Information[6], Information[7]);
            } catch (PositionNotFoundException e) {
                e.printStackTrace();
            }
           // Main.PlayerList.add(p);
            try {
                Builder.writeToFile(p);
                Main.PlayerList = Builder.readFromFile();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                Main.ClubList = Builder.BuildClubList();
                Main.CountryList = Builder.BuildCountryList();
            }
            ClubFound = true;
        }
    }
}

