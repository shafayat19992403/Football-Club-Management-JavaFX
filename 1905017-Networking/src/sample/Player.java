package sample;

import javax.lang.model.element.Name;
import java.io.Serializable;
import java.util.Locale;

public class Player implements Serializable {
    private String name;
    private String CountryName;
    private int age;
    private double Height;
    private String ClubName;
    private String Position;
    private int Number;
    private double Salary;

    Player(String Text){
        this.name=Text;
    }

    Player(String name,String CountryName,String age,String Height,String ClubName,String Position,String Number,String Salary)throws PositionNotFoundException{
        this.name=name;
        this.CountryName=CountryName;
        this.age=Integer.parseInt(age);
        this.ClubName=ClubName;
        if(Position.equalsIgnoreCase("Goalkeeper")||Position.equalsIgnoreCase("Defender")||Position.equalsIgnoreCase("Midfielder")||Position.equalsIgnoreCase("Forward"))
            this.Position=Position;
        else throw new PositionNotFoundException();

        this.Number=Integer.parseInt(Number);
        this.Salary=Double.parseDouble(Salary);
        this.Height=Double.parseDouble(Height);
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return Height;
    }

    public String getCountryName() {
        return CountryName;
    }

    public int getAge() {
        return age;
    }

    public String getClubName() {
        return ClubName;
    }

    public String getPosition() {
        return Position;
    }

    public int getNumber() {
        return Number;
    }

    public double getSalary() {
        return Salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClubName(String clubName) {
        ClubName = clubName;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public void show(){
        if(name.equalsIgnoreCase("No Player Found")){
            System.out.println("No such player with this name");
        }
        else {
            System.out.println("Info of the Player is given below:");
            System.out.println("Name             : " + name);
            System.out.println("Country          : " + CountryName);
            System.out.println("Ages(in Years)   : " + age);
            System.out.println("Height(in meters): " + Height);
            System.out.println("Club             : " + ClubName);
            System.out.println("Position         : " + Position);
            System.out.println("Number           : " + Number);
            System.out.println("Weekly Salary    : " + Salary);
        }
    }
}
class PositionNotFoundException extends Exception{
    @Override
    public String toString(){
        return "Not a valid Position";
    }
}
