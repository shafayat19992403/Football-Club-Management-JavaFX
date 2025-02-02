package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPlayerInterfaceBox {
    Stage st;
    public String display(){
        st=new Stage();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("AddPlayerInterfaceBox.fxml"));
        Parent pane= null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ControllerAddPlayerInterface Controller=new ControllerAddPlayerInterface();
        Controller=loader.getController();
        Controller.setSt(st);
        st.setTitle("Add Player");
        st.setScene(new Scene(pane));
        st.showAndWait();
        return Controller.msg;
    }
}
