package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAddPlayerInterface {
    Stage st;
    String msg;

    public void setSt(Stage st) {
        this.st = st;
    }

    @FXML
    private Label promptLabel3;

    @FXML
    private Label promptLabel1;

    @FXML
    private TextField NameField;

    @FXML
    private TextField NumberField;

    @FXML
    private TextField PositionField;

    @FXML
    private TextField WeeklySalaryField;

    @FXML
    private TextField ClubField;

    @FXML
    private TextField HeightField;

    @FXML
    private TextField AgeField;

    @FXML
    private TextField CountryNameField;

    @FXML
    void PromptBoxSubmitOnAction(ActionEvent event) {
        st.close();
        msg=NameField.getText()+","+CountryNameField.getText()+","+AgeField.getText()+","+HeightField.getText()+","+ClubField.getText()+","+PositionField.getText()+","+NumberField.getText()+","+WeeklySalaryField.getText();

    }
}
