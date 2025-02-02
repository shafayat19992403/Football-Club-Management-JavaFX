package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPromptBox2 implements Initializable {
    String tempStr;
    Stage st;
    @FXML
    private TextField promptTextField1;

    @FXML
    private Label promptLabel1;

    @FXML
    private TextField promptTextField2;

    @FXML
    private Label promptLabel2;

    public void setPromptLabel1(String str){
        promptLabel1.setText(str);
    }
    public void setPromptLabel2(String str){
        promptLabel2.setText(str);
    }
    public void setSt(Stage st) {
        this.st = st;
    }

    @FXML
    void PromptBoxSubmitOnAction(ActionEvent event) {
        tempStr=promptTextField1.getText()+" "+promptTextField2.getText();
        st.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
