package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerPromptBox {
    String tempStr;
    Stage st;

    @FXML
    private TextField promptTextField;

    @FXML
    private Label promptLabel;



    public void setPromptLabel(String str){
        promptLabel.setText(str);
    }

    public void setSt(Stage st) {
        this.st = st;
    }

    public String getStr(){
        return tempStr;
    }
    @FXML
    void PromptBoxSubmitOnAction(ActionEvent event) {
        tempStr=promptTextField.getText();
        st.close();
    }

}
