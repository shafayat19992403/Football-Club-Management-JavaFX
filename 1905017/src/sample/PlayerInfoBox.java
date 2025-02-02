package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PlayerInfoBox {
    double x,y;

    Stage st;
    Player p;
    PlayerInfoBox(Player p){
        st=new Stage();
        this.p=p;
        loadBox();
    }
    private void loadBox(){
        x=0;y=0;
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("PlayerInfoBoxExtended.fxml"));
        Parent pane= null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        st.setTitle("Player Info");
        st.initStyle(StageStyle.TRANSPARENT);
        Scene sc=new Scene(pane);
        st.setScene(sc);
        sc.setFill(Color.TRANSPARENT);

        PlayerInfoBoxController Controller=loader.getController();
        Controller.setP(p);
        Controller.setSt(st);
        st.show();
        pane.setOnMousePressed(event -> {
            x= event.getSceneX();
            y=event.getSceneY();
        });
        pane.setOnMouseDragged(event->{
            st.setX(event.getScreenX()-x);
            st.setY(event.getScreenY()-y);
        });

    }
}
