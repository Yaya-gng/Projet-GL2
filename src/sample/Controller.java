package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.control.*;
import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Button log,rm,sm,bm,wm;
    @FXML private Pane black,green,red;
    @FXML private Parent avatar1;
     @FXML public void accueilButtonPushed(ActionEvent event) throws IOException {
        Parent acceuilParent = FXMLLoader.load(getClass().getResource("Accueil1.fxml"));
        Scene accueilScene = new Scene(acceuilParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(accueilScene);
        window.show();
    }

    @FXML
    void affect(ActionEvent event) {

            if(event.getSource()==sm){
                black.toFront();
            }
            if(event.getSource()==bm){
                green.toFront();
            }
    }

       public void click(){

         red.toFront();

       }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
