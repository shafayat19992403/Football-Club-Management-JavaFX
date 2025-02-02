package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PromptBox {
    public String display(String str){
        Stage st=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("PromptBox.fxml"));
        Parent sc= null;
        try {
            sc = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerPromptBox controller=loader.getController();
        controller.setSt(st);
        controller.setPromptLabel(str);
        st.setTitle("User Input Interface");
        st.setScene(new Scene(sc));
        st.showAndWait();
        return controller.tempStr;
    }
}
