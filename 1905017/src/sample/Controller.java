package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Main main;
    ObservableList <String> SearchPlayerList= FXCollections.observableArrayList();
    ObservableList <String> SearchClubList=FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> SearchPlayerComboBox;

    @FXML
    private ComboBox<String> SearchClubComboBox;
    @FXML
    private Label ClubCount;

    @FXML
    private Label PlayerCount;

    @FXML
    private Label CountryCount;

    public void setMain(Main main) {
        this.main = main;
    }
    public void updateCountryCount(int x){
        CountryCount.setText(String.valueOf(x));
    }
    public void updatePlayerCount(int x){
        PlayerCount.setText(String.valueOf(x));
    }
    public void updateClubCount(int x){
        ClubCount.setText(String.valueOf(x));
    }
    public void loadPlayers(List<Player> p){

        List<Node> NodeList=new ArrayList();
        for(int i=0;i<p.size();i++){
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("Item.fxml"));
            Parent pane= null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ItemController controller=loader.getController();
            controller.setP(p.get(i));
            NodeList.add(pane);

           /* try {
                NodeList.add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        itemVbox.getChildren().setAll(NodeList);
    }

    @FXML
    private VBox itemVbox;


    @FXML
    void exitButtonOnAction(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void logOutOnAction(ActionEvent event) {
        main.showLogInPage();
    }
    @FXML
    void SearchPlayerOnAction(ActionEvent event) {

    }
    @FXML
    void AddPlayerOnAction(ActionEvent event) {
    AddPlayerClass AddPlayerObj=new AddPlayerClass();
    AddPlayerInterfaceBox box=new AddPlayerInterfaceBox();
    AddPlayerObj.addNewPlayer(box.display());
    loadPlayers(Main.PlayerList);
        updateClubCount(Main.ClubList.size());
        updateCountryCount(Main.CountryList.size());
        updatePlayerCount(Main.PlayerList.size());
    }
    public void initComboBox(){
        SearchPlayerList.addAll("None","By Players Name","By Club and Country","By Position","By Salary Range","Country-wise player Count");
        SearchPlayerComboBox.getItems().addAll(SearchPlayerList);
        SearchClubList.addAll("None","Players with Maximum Salary","Players with the maximum age","Players with the maximum height","Total yearly salary of a Club");
        SearchClubComboBox.getItems().addAll(SearchClubList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SearchClass SearchObj=new SearchClass();
        updateClubCount(Main.ClubList.size());
        updateCountryCount(Main.CountryList.size());
        updatePlayerCount(Main.PlayerList.size());
        loadPlayers(Main.PlayerList);
        initComboBox();
        SearchPlayerComboBox.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue,oldValue,newValue)->{
                    if(newValue.equalsIgnoreCase("By Players Name")){
                        PromptBox box=new PromptBox();
                        loadPlayers(SearchObj.SearchByPlayerName(box.display("Enter Name:")));
                    }
                    if(newValue.equalsIgnoreCase("None")){
                        loadPlayers(Main.PlayerList);
                    }
                    if(newValue.equalsIgnoreCase("By Position")){
                        PromptBox box=new PromptBox();
                        loadPlayers(SearchObj.SearchByPosition(box.display("Enter Position: ")));
                    }
                    if(newValue.equalsIgnoreCase("By Club and Country")){
                        PromptBoxTwo box=new PromptBoxTwo();
                        String[] temp=box.display("Enter Club","Enter Country").split(" ");
                        loadPlayers(SearchObj.SearchByClubAndCountry(temp[0],temp[1]));
                    }
                    if(newValue.equalsIgnoreCase("By Salary Range")){
                        PromptBoxTwo box=new PromptBoxTwo();
                        String[] temp=box.display("Enter lower Limit:","Enter higher limit:").split(" ");
                        loadPlayers(SearchObj.SearchBySalaryRange(Double.parseDouble(temp[0]),Double.parseDouble(temp[1])));
                    }
                    if(newValue.equalsIgnoreCase("Country-wise player Count")){
                        String content="";
                        for(int i=0;i<Main.CountryList.size();i++){
                            content=content.concat(" "+Main.CountryList.get(i).getName()+" :"+Main.CountryList.get(i).getCount()+"\n");
                        }
                        Alert a=new Alert(Alert.AlertType.INFORMATION);
                        a.setHeaderText("Country-Wise Player Count");
                        a.setContentText(content);
                        a.show();
                    }
                }
        );
        SearchClubComboBox.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue,oldValue,newValue)->{
                   if(newValue.equalsIgnoreCase("None")){
                       loadPlayers(Main.PlayerList);
                   }
                   if(newValue.equalsIgnoreCase("Players with Maximum Salary")){
                       PromptBox box=new PromptBox();
                        loadPlayers(SearchObj.SearchByClub(box.display("Enter Club:")).getMaxSalaryPlayer());
                   }
                   if(newValue.equalsIgnoreCase("Players with the maximum age")){
                       PromptBox box=new PromptBox();
                       loadPlayers(SearchObj.SearchByClub(box.display("Enter Club:")).getMaxAgePlayer());
                   }
                    if(newValue.equalsIgnoreCase("Players with the maximum height")){
                        PromptBox box=new PromptBox();
                        loadPlayers(SearchObj.SearchByClub(box.display("Enter Club:")).getMaxHeightPlayer());
                    }
                    if(newValue.equalsIgnoreCase("Total yearly salary of a Club")){
                        PromptBox box=new PromptBox();
                        String ClubName=box.display("Enter Club:");

                        Alert a=new Alert(Alert.AlertType.INFORMATION);
                        a.setHeaderText("Total yearly salary of "+ClubName);
                        a.setContentText(SearchObj.SearchByClub(ClubName).getTotalYearlySalary()+"");
                        a.show();
                    }
        }
        );

    }
}
