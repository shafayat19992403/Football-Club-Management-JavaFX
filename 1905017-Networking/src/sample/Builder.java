package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Builder {
    private static final String INPUT_FILE_NAME = "F:\\Java Udemy Course\\TryOutAProject\\src\\sample\\players.txt";
    private static final String OUTPUT_FILE_NAME="F:\\Java Udemy Course\\TryOutAProject\\src\\sample\\players.txt";

    public static void writeToFile(Player s) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        // var bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (Player p : Main.PlayerList) {
            bw.write(p.getName() + "," + p.getCountryName() + "," + p.getAge() + "," + p.getHeight()+","+p.getClubName()+","+p.getPosition()+","+p.getNumber()+","+p.getSalary());
            bw.write("\n");
        }
        bw.write(s.getName() + "," + s.getCountryName() + "," + s.getAge() + "," + s.getHeight()+","+s.getClubName()+","+s.getPosition()+","+s.getNumber()+","+s.getSalary());
        bw.write("\n");

        bw.close();
    }
    public static List<Player> readFromFile() throws Exception {
        List<Player> PlayerList = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] tokens = line.split(",");
            Player s = new Player(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]);
            PlayerList.add(s);
        }
        br.close();
        return PlayerList;
    }
    public static List<Club> BuildClubList(){
        List<Player> PlayerListTemp=new ArrayList();
        try {
            PlayerListTemp=Builder.readFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List <Club> ClubListTemp=new ArrayList();
        for(int i=0;i< PlayerListTemp.size();i++){
            Boolean isFound=false;
            for(int j=0;j<ClubListTemp.size();j++){
                if(PlayerListTemp.get(i).getClubName().equalsIgnoreCase(ClubListTemp.get(j).getName()))
                {
                    isFound=true;
                    ClubListTemp.get(j).addPlayer(PlayerListTemp.get(i));
                    break;
                }
            }
            if(!isFound){
                ClubListTemp.add(new Club(PlayerListTemp.get(i).getClubName(),PlayerListTemp.get(i)));
            }
        }
        return ClubListTemp;
    }

    public static List<Country> BuildCountryList(){
        List<Player> PlayerListTemp=new ArrayList();
        try {
            PlayerListTemp=Builder.readFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List <Country> CountryListTemp=new ArrayList();
        for(int i=0;i< PlayerListTemp.size();i++){
            Boolean isFound=false;
            for(int j=0;j<CountryListTemp.size();j++){
                if(PlayerListTemp.get(i).getCountryName().equalsIgnoreCase(CountryListTemp.get(j).getName()))
                {
                    isFound=true;
                    CountryListTemp.get(j).addPlayer(PlayerListTemp.get(i));
                    break;
                }
            }
            if(!isFound){
                CountryListTemp.add(new Country(PlayerListTemp.get(i).getCountryName(),PlayerListTemp.get(i)));
            }
        }
        return CountryListTemp;
    }
}
