package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PromptBoxTwo {
    public String display(String msg1,String msg2){
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("PromptBoxTwo.fxml"));
        Stage st=new Stage();
        Parent pane= null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
       ControllerPromptBox2 controller=loader.getController();
        controller.setSt(st);
        controller.setPromptLabel1(msg1);
        controller.setPromptLabel2(msg2);
        st.setTitle("User Input Interface");
        st.setScene(new Scene(pane));
        st.showAndWait();
        return controller.tempStr;
    }
}
