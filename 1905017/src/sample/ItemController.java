package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemController implements Initializable {
    Player p;

    @FXML
    public Label Name;

    @FXML
    private Label CountryName;

    @FXML
    private Label ClubName;

    @FXML
    private Label Salary;

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
        Salary.setText("$"+String.valueOf(p.getSalary()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      /*  */
        //System.out.println(p.getName());
        //change();
    }
}
