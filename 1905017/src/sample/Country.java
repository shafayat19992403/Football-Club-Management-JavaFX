package sample;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String Name;
    private int count;
    private List<Player> PlayerListInCountry;

    Country(String name){
        count=0;
        this.Name=name;
        PlayerListInCountry=new ArrayList();
    }
    Country(String Name,Player p){
        count=1;
        this.Name=Name;
        PlayerListInCountry=new ArrayList();
        PlayerListInCountry.add(p);
    }

    public String getName() {
        return Name;
    }

    public int getCount() {
        return count;
    }

    public List<Player> getPlayerListInCountry() {
        return PlayerListInCountry;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPlayerListInCountry(List<Player> playerListInCountry) {
        PlayerListInCountry = playerListInCountry;
    }
    public void addPlayer(Player p){
        PlayerListInCountry.add(p);
        ++count;
    }
    public void show(){
        System.out.println("THE PLAYERS OF "+getName()+" ARE SHOWN BELOW: ");
        for(int i=0;i<PlayerListInCountry.size();i++){
            System.out.println((i+1)+".");
            PlayerListInCountry.get(i).show();
            System.out.println("\n");
        }
        System.out.println("\n\n\n");
    }
}
