package sample;
import Model.Administrateur;
import dateBase.Connecter;
import dateBase.ProfilAdminDB;
import dateBase.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;

public class AccuielController implements Initializable {
    @FXML
    private Pane black, red, profil, admin, prof;
    @FXML
    private Parent avatar1;
    @FXML TextField t1,t2,t3,t4,t5,t6;
    @FXML Button modify, confirme;
    @FXML private Label l1,l2,l3,l4,l5;
    @FXML
    private Button log, rm, sm, bm, wm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l5.setText(String.valueOf(Connecter.getIdConnected()));
        l1.setText(Connecter.getNameConnected());
        l2.setText(Connecter.getLastNameConnected());

        if(Integer.parseInt(l5.getText()) == 1 ) {
            admin.toFront();
            prof.setVisible(false);
        }

        if(Integer.parseInt(l5.getText()) >1 && Integer.parseInt(l5.getText()) < 2000) {
            prof.toFront();
            admin.setVisible(false);
        }




    }

    @FXML
    void affect(ActionEvent event) {
            red.toFront();
    }

    @FXML
    public void click() {
        profil.toFront();
        ArrayList<Administrateur> ad = ProfilAdminDB.display();

        t1.setText(String.valueOf(ad.get(0).getId()));
        t2.setText(ad.get(0).getNom());
        t3.setText(ad.get(0).getPrenom());
        t4.setText("ad.get(0).getDate()");
        t5.setText(ad.get(0).getAdresse());
        t6.setText(ad.get(0).getPassword());
    }

    @FXML void modifierProfil(){

        t2.setDisable(false);
        t3.setDisable(false);
        t4.setDisable(false);
        t5.setDisable(false);
        t6.setDisable(false);
        confirme.setDisable(false);

    }

    @FXML void confirmeModification(){
        ProfilAdminDB.modify(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),"t4.getDate()", t5.getText(), t6.getText());
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Informaton Dialog");
        a.setHeaderText("Look, an information Dialog");
        a.setContentText("Modification réussite");
        a.showAndWait();

        t2.setDisable(true);
        t3.setDisable(true);
        t4.setDisable(true);
        t5.setDisable(true);
        t6.setDisable(true);
        confirme.setDisable(true);
    }

}