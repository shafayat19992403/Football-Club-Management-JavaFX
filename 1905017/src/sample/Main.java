package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

public class Main extends Application {
    public double x=0,y=0;
    Stage stage;
    public static List <Player> PlayerList;
    public static List<Club> ClubList;
    public static List<Country> CountryList;
    public void build(){
        try {
             Main.PlayerList=Builder.readFromFile();
             ClubList=Builder.BuildClubList();
             CountryList=Builder.BuildCountryList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showHomePage(){
        x=0;y=0;
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Home.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root));
        //setting controller
        Controller controller=loader.getController();
        controller.setMain(this);
        root.setOnMousePressed(event -> {
            x= event.getSceneX();
            y=event.getSceneY();
        });
        root.setOnMouseDragged(event->{
            stage.setX(event.getScreenX()-x);
            stage.setY(event.getScreenY()-y);
        });
        //setting stage borderless
        stage.initStyle(StageStyle.UNDECORATED);
        //dragging it
        stage.show();
    }
    public void showLogInPage(){
        x=0;y=0;
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("LogIn.fxml"));
        Parent root= null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LogInController controller=loader.getController();
        controller.setMain(this);
        //setting stage borderless
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        //dragging it
        root.setOnMousePressed(event -> {
            x= event.getSceneX();
            y=event.getSceneY();
        });
        root.setOnMouseDragged(event->{
            stage.setX(event.getScreenX()-x);
            stage.setY(event.getScreenY()-y);
        });
        stage.setTitle("LogIn");
        stage.show();

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        build();
        stage=primaryStage;
        showLogInPage();
    }
    public static String catchString(String str){
        return str;
    }


    public static void main(String[] args) {
        launch(args);
    }

}
