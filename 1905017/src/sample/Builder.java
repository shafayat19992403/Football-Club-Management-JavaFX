package sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Builder {
    private static final String INPUT_FILE_NAME ="src/sample/players.txt";
    private static final String OUTPUT_FILE_NAME="src/sample/players.txt";

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
        List <Club> ClubListTemp=new ArrayList();
        for(int i=0;i< Main.PlayerList.size();i++){
            Boolean isFound=false;
            for(int j=0;j<ClubListTemp.size();j++){
                if(Main.PlayerList.get(i).getClubName().equalsIgnoreCase(ClubListTemp.get(j).getName()))
                {
                    isFound=true;
                    ClubListTemp.get(j).addPlayer(Main.PlayerList.get(i));
                    break;
                }
            }
            if(!isFound){
                ClubListTemp.add(new Club(Main.PlayerList.get(i).getClubName(),Main.PlayerList.get(i)));
            }
        }
        return ClubListTemp;
    }

    public static List<Country> BuildCountryList(){
        List <Country> CountryListTemp=new ArrayList();
        for(int i=0;i< Main.PlayerList.size();i++){
            Boolean isFound=false;
            for(int j=0;j<CountryListTemp.size();j++){
                if(Main.PlayerList.get(i).getCountryName().equalsIgnoreCase(CountryListTemp.get(j).getName()))
                {
                    isFound=true;
                    CountryListTemp.get(j).addPlayer(Main.PlayerList.get(i));
                    break;
                }
            }
            if(!isFound){
                CountryListTemp.add(new Country(Main.PlayerList.get(i).getCountryName(),Main.PlayerList.get(i)));
            }
        }
        return CountryListTemp;
    }
}
