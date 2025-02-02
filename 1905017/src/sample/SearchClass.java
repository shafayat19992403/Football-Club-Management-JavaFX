package sample;

import java.util.ArrayList;
import java.util.List;

public class SearchClass {

        public List<Player> SearchByPlayerName(String name){
            List<Player> temp=new ArrayList();
            for(int i=0;i<Main.PlayerList.size();i++){
                if(name.equalsIgnoreCase(Main.PlayerList.get(i).getName()))
                {
                    temp.add(Main.PlayerList.get(i));
                    return temp;
                }
            }
            temp.add(new Player("No Player Found"));
            return temp;
        }

        public List<Player> SearchByClubAndCountry(String Club, String Country){
            List<Player> Temp=new ArrayList();
            if(Country.equalsIgnoreCase("Any"))
            {
                for(int i=0;i<Main.PlayerList.size();i++){
                    if(Club.equalsIgnoreCase(Main.PlayerList.get(i).getClubName()))
                        Temp.add(Main.PlayerList.get(i));
                }
            }
            else if(Club.equalsIgnoreCase("Any"))
            {
                for(int i=0;i<Main.PlayerList.size();i++){
                    if(Country.equalsIgnoreCase(Main.PlayerList.get(i).getCountryName()))
                        Temp.add( Main.PlayerList.get(i));
                }
            }
            else{
                for(int i=0;i<Main.PlayerList.size();i++) {
                    if (Country.equalsIgnoreCase(Main.PlayerList.get(i).getCountryName())) {
                        if (Club.equalsIgnoreCase(Main.PlayerList.get(i).getClubName())) {
                            Temp.add( Main.PlayerList.get(i));
                        }
                    }
                }
            }
            return Temp;
        }
        public List<Player> SearchByPosition(String Position){
            List<Player> temp=new ArrayList();
            for(int i=0;i<Main.PlayerList.size();i++){
                if(Position.equalsIgnoreCase(Main.PlayerList.get(i).getPosition()))
                {
                    temp.add(Main.PlayerList.get(i));
                }
            }
            return temp;
        }

        public List<Player> SearchBySalaryRange(double lower,double upper){
            List<Player> temp=new ArrayList();
            for(int i=0;i<Main.PlayerList.size();i++){
                if(Main.PlayerList.get(i).getSalary()>lower && Main.PlayerList.get(i).getSalary()<upper){
                    temp.add(Main.PlayerList.get(i));
                }
            }
            return temp;
        }
        public int CountryWisePlayerCount(String Country){
            for(int i=0;i<Main.CountryList.size();i++){
                if(Country.equalsIgnoreCase(Main.CountryList.get(i).getName()))
                    return Main.CountryList.get(i).getCount();
            }
            return -1;
        }
        public Club SearchByClub(String name){
            for(int i=0;i<Main.ClubList.size();i++){
                if(name.equalsIgnoreCase(Main.ClubList.get(i).getName()))
                    return Main.ClubList.get(i);
            }
            return new Club("No Club Found");
        }
    }

