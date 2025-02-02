package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import sample.Main;

import java.io.IOException;

public class LogInController {
    Main main;
    @FXML
    private TextField UserNameTextField;

    @FXML
    private PasswordField PasswordTextField;

    @FXML
    private Label WarningLabel;


    @FXML
    void resetOnAction(ActionEvent event) {
        UserNameTextField.clear();
        PasswordTextField.clear();
    }

    @FXML
    void submitOnAction(ActionEvent event) {
    /*if(UserNameTextField.getText().equalsIgnoreCase("Admin")&&PasswordTextField.getText().equals("123"))
    {
        main.showHomePage();
        System.out.println("okay");
    }
    else
    {
        WarningLabel.setText("Wrong UserName or Password");
    }*/
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUserName(UserNameTextField.getText());
        loginDTO.setPassword(PasswordTextField.getText());
        try {
            main.getNetworkUtil().write(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void CancelOnAction(ActionEvent event) {
    System.exit(0);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
