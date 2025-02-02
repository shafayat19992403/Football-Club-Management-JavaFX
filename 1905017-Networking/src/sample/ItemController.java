package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {
    Player p;
    Main main;

    @FXML
    public Label Name;

    @FXML
    private Label CountryName;

    @FXML
    private Label ClubName;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void ItemButtonOnAction(ActionEvent event) {
        PlayerInfoBox bx=new PlayerInfoBox(p);
    }

    public void setP(Player p) {
        this.p = p;
        change();
    }
    public void change(){
        Name.setText(p.getName());
        CountryName.setText(p.getCountryName());
        ClubName.setText(p.getClubName());
    }
    @FXML
    void ItemSellButtonOnAction(ActionEvent event) {
        /*try {
            main.getNetworkUtil().write(p);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        try {
            main.getNetworkUtil().write("shit");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      /*  */
        //System.out.println(p.getName());
        //change();
    }
}
