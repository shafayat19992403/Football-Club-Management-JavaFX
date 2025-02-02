package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Club {
    private String name;
    private List<Player> PlayerListInClub;
    private Double MaxSalary;
    private int MaxAge;
    private double MaxHeight;
    private Double TotalYearlySalary;
    private Scanner input;
    private int count;
    Club(String Name){
        name=Name;
        PlayerListInClub=new ArrayList();
        count=0;
        input=new Scanner(System.in);
    }
    Club(String name,Player p){
        this.name=name;
        PlayerListInClub=new ArrayList();
        count++;
        PlayerListInClub.add(p);
        input=new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayerListInClub() {
        return PlayerListInClub;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerListInClub(List<Player> playerListInClub) {
        PlayerListInClub = playerListInClub;
    }
    public List<Player> getMaxSalaryPlayer(){
        double temp=0;
        //int index=0;
        List<Player> TempList=new ArrayList();
        for(int i=0;i<PlayerListInClub.size();i++){
            if(PlayerListInClub.get(i).getSalary()>temp){
                temp=PlayerListInClub.get(i).getSalary();
                //index=i;
            }
        }
        MaxSalary=temp;
        for(int i=0;i<PlayerListInClub.size();i++){
            if(PlayerListInClub.get(i).getSalary()==MaxSalary)
                TempList.add(PlayerListInClub.get(i));
        }

        return TempList;
    }
    public List<Player> getMaxAgePlayer(){
        int temp=0;
        //int index=0;
        List<Player> TempList=new ArrayList();
        for(int i=0;i<PlayerListInClub.size();i++){
            if(PlayerListInClub.get(i).getAge()>temp){
                temp=PlayerListInClub.get(i).getAge();
                //index=i;
            }
        }
        MaxAge=temp;
        for(int i=0;i<PlayerListInClub.size();i++){
            if(PlayerListInClub.get(i).getAge()==MaxAge)
                TempList.add(PlayerListInClub.get(i));
        }
        return TempList;
    }
    public List<Player> getMaxHeightPlayer(){
        List<Player> TempList=new ArrayList();
        double temp=0;
        //int index=0;
        for(int i=0;i<PlayerListInClub.size();i++){
            if(PlayerListInClub.get(i).getHeight()>temp){
                temp=PlayerListInClub.get(i).getHeight();
                //index=i;
            }
        }
        MaxHeight=temp;
        for(int i=0;i<PlayerListInClub.size();i++){
            if(PlayerListInClub.get(i).getHeight()==MaxHeight)
                TempList.add(PlayerListInClub.get(i));
        }
        return TempList;
    }
    public double getTotalYearlySalary(){
        double sum=0;
        for(int i=0;i<PlayerListInClub.size();i++){
            sum+=PlayerListInClub.get(i).getSalary();
        }
        TotalYearlySalary=sum;
        return TotalYearlySalary;
    }
    public void addPlayer(Player p){
        PlayerListInClub.add(p);
        count++;
    }
    public void show(){
        if(name.equalsIgnoreCase("No CLub Found")){
            System.out.println("No such club with this name");
        }
        else
        {
            System.out.println("THE PLAYERS OF "+getName()+" ARE SHOWN BELOW:");
            for(int i=0;i<PlayerListInClub.size();i++){
                System.out.println((i+1)+".");
                PlayerListInClub.get(i).show();
                System.out.println("\n");
                System.out.println("\n\n\n\n");
            }

        }
    }
}
