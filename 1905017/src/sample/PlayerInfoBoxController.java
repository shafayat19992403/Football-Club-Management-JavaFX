package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerInfoBoxController implements Initializable {
    @FXML
    private Label NameField;

    @FXML
    private Label CountryNameField;

    @FXML
    private Label AgeField;

    @FXML
    private Label HeightField;

    @FXML
    private Label ClubField;

    @FXML
    private Label PositionField;

    @FXML
    private Label NumberField;

    @FXML
    private Label SalaryField;
    Player p;
    Stage st;

    public void setP(Player p) {
        this.p = p;
        NameField.setText(p.getName());
        CountryNameField.setText(p.getCountryName());
        AgeField.setText(String.valueOf(p.getAge()));
        HeightField.setText(String.valueOf(p.getHeight()));
        ClubField.setText(p.getClubName());
        PositionField.setText(p.getPosition());
        NumberField.setText(String.valueOf(p.getNumber()));
        SalaryField.setText("$"+p.getSalary());
    }
    @FXML
    void PlayerInfoCloseOnAction(ActionEvent event) {
        st.close();
    }

    public void setSt(Stage st) {
        this.st = st;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
