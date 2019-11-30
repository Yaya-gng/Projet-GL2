package sample;
import Model.Administrateur;
import Model.Apprenant;
import Model.Instructeur;
import dateBase.*;
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;

public class AccuielController implements Initializable {
    @FXML
    private Pane black, red, profil, admin, prof,formationAd,app;
    @FXML
    private Parent avatar1;
    @FXML TextField t1,t2,t3,t4,t5,t6,gra,special,nve,sec;
    @FXML Button modify, confirme,disco;
    @FXML private Label l1,l2,l3,l4,l5,grade,spec,niv,section;
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
            app.setVisible(false);
        }

        if(Integer.parseInt(l5.getText()) >1 && Integer.parseInt(l5.getText()) < 100) {
            prof.toFront();
            admin.setVisible(false);
            app.setVisible(false);
        }

        if(Integer.parseInt(l5.getText()) >100 && Integer.parseInt(l5.getText()) < 1000){
            app.toFront();
            admin.setVisible(false);
            prof.setVisible(false);
        }
    }

    @FXML
    void affect(ActionEvent event) {
            red.toFront();
    }

    @FXML
    public void click() {
        profil.toFront();
       if(Integer.parseInt(l5.getText()) == 1) {
           ArrayList<Administrateur> ad = ProfilAdminDB.display();

           t1.setText(String.valueOf(ad.get(0).getId()));
           t2.setText(ad.get(0).getNom());
           t3.setText(ad.get(0).getPrenom());
           t4.setText("ad.get(0).getDate()");
           t5.setText(ad.get(0).getAdresse());
           t6.setText(ad.get(0).getPassword());

           grade.setVisible(false);
           gra.setVisible(false);
           spec.setVisible(false);
           special.setVisible(false);
           niv.setVisible(false);
           nve.setVisible(false);
           section.setVisible(false);
           sec.setVisible(false);

       }

       if(Integer.parseInt(l5.getText()) > 1 && Integer.parseInt(l5.getText()) < 100){

           ArrayList<Instructeur> ad = ProfilInstructorDB.display(Integer.parseInt(l5.getText()));

           t1.setText(String.valueOf(ad.get(0).getId()));
           t2.setText(ad.get(0).getNom());
           t3.setText(ad.get(0).getPrenom());
           t4.setText("ad.get(0).getDate()");
           t5.setText(ad.get(0).getAdresse());
           t6.setText(ad.get(0).getPassword());
           gra.setText(ad.get(0).getGrade());
           special.setText(ad.get(0).getSpec());
           niv.setVisible(false);
           nve.setVisible(false);
           section.setVisible(false);
           sec.setVisible(false);

       }
      if(Integer.parseInt(l5.getText()) > 100 && Integer.parseInt(l5.getText()) < 1000) {
          System.out.println("zarezra");
           ArrayList<Apprenant> ad = ProfilApprenantDB.display(Integer.parseInt(l5.getText()));
           t1.setText(String.valueOf(ad.get(0).getMatricule()));
           t2.setText(ad.get(0).getNom());
           t3.setText(ad.get(0).getPrenom());
           t4.setText("ad.get(0).getDate()");
           t5.setText(ad.get(0).getAdresse());
           t6.setText(ad.get(0).getPassword());
           special.setText(ad.get(0).getSpec());
           grade.setVisible(false);
           gra.setVisible(false);
           nve.setText(String.valueOf(ad.get(0).getNiv()));
           sec.setText(String.valueOf(ad.get(0).getSection()));

       }
    }

    @FXML void modifierProfil(){

        t2.setDisable(false);
        t3.setDisable(false);
        t4.setDisable(false);
        t5.setDisable(false);
        t6.setDisable(false);
        confirme.setDisable(false);

        if(Integer.parseInt(l5.getText()) >1 && Integer.parseInt(l5.getText()) <100){
            t1.setDisable(false);
            gra.setDisable(false);
            special.setDisable(false);
        }

        if(Integer.parseInt(l5.getText()) >100 && Integer.parseInt(l5.getText()) <1000){
            t1.setVisible(false);
            nve.setDisable(false);
            special.setDisable(false);
            sec.setDisable(false);
        }

    }

    @FXML void confirmeModification(){
        if(Integer.parseInt(l5.getText()) == 1)
            ProfilAdminDB.modify(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),"t4.getDate()", t5.getText(), t6.getText());

        else if(Integer.parseInt(l5.getText()) > 1 && Integer.parseInt(l5.getText()) < 2000) {
            ProfilInstructorDB.modify(Integer.parseInt(t1.getText()), t2.getText(), t3.getText(), "t4.getDate()", t5.getText(), t6.getText(),gra.getText(), special.getText());
            grade.setDisable(true);
            gra.setDisable(true);
            spec.setDisable(true);
            special.setDisable(true);
        }

        else {
            ProfilApprenantDB.modify(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),"t4.getDate()", t5.getText(), 0,t6.getText(), special.getText(), nve.getText(), sec.getText());;
            spec.setDisable(true);
            special.setDisable(true);
            niv.setDisable(true);
            nve.setDisable(true);
            sec.setDisable(true);
            section.setDisable(true);
        }

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

    @FXML public void disconnect(ActionEvent event){


        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
            s.setScene(scene);
            s.show();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

}