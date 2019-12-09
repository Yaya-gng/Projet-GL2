package sample;
import Model.*;
import Model.Quizs;
import dateBase.*;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.util.Callback;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;
import java.lang.String;

public class AccuielController implements Initializable {

    @FXML
    private Pane profil, admin, prof,formationIns,app,allStudents;
    @FXML
    private Parent avatar1;
    @FXML TextField t1,t2,t3,t4,t5,t6,gra,special,nve,sec,nomFormation, titreCour, addQuiz;
    @FXML Button modify, confirme,disco, ressourceInst, ajouterFormInst, supprimerFormInst, afficherTout, tle, ajouterEtudiant, supprimerEtudiant, supprimerCour, openFile, addFile, ajouterQuiz, supprimerQuiz;
    @FXML private Label id, nom, prenom, grade,spec,niv,section, numF;
    @FXML
    private Button creerQuiz, ouvrireQuiz;
    @FXML
    private ListView listFormation, listCours, listQuiz;
   @FXML private TableView<Cour> tableCours;
   @FXML private TableView<AllApprenant> tableAllStu,tableStuFor;
   @FXML private TableColumn<Cour, String> c1,c2;
   @FXML private TableColumn<AllApprenant,String> nomC, preC, specC,nomC1, prenomC1, specC1, mat1;

    @FXML ImageView im;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       id.setText(String.valueOf(Connecter.getIdConnected()));
       nom.setText(Connecter.getNameConnected());
       prenom.setText(Connecter.getLastNameConnected());
/*
        if(Integer.parseInt(l5.getText()) == 1 ) {
            admin.toFront();
        }

        if(Integer.parseInt(l5.getText()) >1 && Integer.parseInt(l5.getText()) < 100) {
            prof.toFront();

        }

        if(Integer.parseInt(l5.getText()) >100 && Integer.parseInt(l5.getText()) < 1000){
            app.toFront();
        }*/



        nomC.setCellValueFactory(new PropertyValueFactory<>("nom"));
        preC.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        specC.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        nomC1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomC1.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        specC1.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        mat1.setCellValueFactory(new PropertyValueFactory<>("matricule"));
    }

    @FXML
    void affect(ActionEvent event) {

    }

    @FXML
    public void afficheProfil() {
        profil.toFront();
       if(Integer.parseInt(id.getText()) == 1) {
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

       if(Integer.parseInt(id.getText()) > 1 && Integer.parseInt(id.getText()) < 100){

           ArrayList<Instructeur> ad = ProfilInstructorDB.display(Integer.parseInt(id.getText()));

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
      if(Integer.parseInt(id.getText()) > 100 && Integer.parseInt(id.getText()) < 1000) {
          System.out.println("zarezra");
           ArrayList<Apprenant> ad = ProfilApprenantDB.display(Integer.parseInt(id.getText()));
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

        if(Integer.parseInt(id.getText()) >1 && Integer.parseInt(id.getText()) <100){
            t1.setDisable(false);
            gra.setDisable(false);
            special.setDisable(false);
        }

        if(Integer.parseInt(id.getText()) >100 && Integer.parseInt(id.getText()) <1000){
            t1.setVisible(false);
            nve.setDisable(false);
            special.setDisable(false);
            sec.setDisable(false);
        }

    }

    @FXML void confirmeModification(){
        if(Integer.parseInt(id.getText()) == 1)
            ProfilAdminDB.modify(Integer.parseInt(t1.getText()),t2.getText(),t3.getText(),"t4.getDate()", t5.getText(), t6.getText());

        else if(Integer.parseInt(id.getText()) > 1 && Integer.parseInt(id.getText()) < 2000) {
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
        a.setContentText("Modification r�ussite");
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

    @FXML public void RessourceInst(ActionEvent event){
        formationIns.toFront();
        ArrayList<String> frm = Formations.afficherFormation(Integer.parseInt(id.getText()));
        listFormation.getItems().clear();
        listCours.getItems().clear();
        listQuiz.getItems().clear();
        tableStuFor.getItems().clear();


        listFormation.getItems().addAll(frm);
        if(listFormation.getItems().isEmpty() == false) {

            tle.setDisable(false);
            openFile.setDisable(false);
            addFile.setDisable(false);
        }


    }

    @FXML public void setAjouterFormInst(ActionEvent event){
        if(nomFormation.getText().isEmpty() == false){
                listFormation.getItems().add(nomFormation.getText());
                Formations.ajouterFormation(nomFormation.getText(), Integer.parseInt(id.getText()));
                nomFormation.clear();
        }
    }

    @FXML public void setSupprimerFormInst(ActionEvent event){
        Object item = listFormation.getSelectionModel().getSelectedItem();

            listFormation.getItems().remove(item);
            String s = (String)item;
            Formations.supprimerFormation(Formations.getNumF(s));
    }

        @FXML public void AfficherTout(ActionEvent event){
            tableStuFor.getItems().clear();
            listCours.getItems().clear();
            listCours.getItems().clear();
            ajouterQuiz.setVisible(true);
            creerQuiz.setVisible(true);
            ouvrireQuiz.setVisible(true);
            Object item = listFormation.getSelectionModel().getSelectedItem();
            String s = (String)item;
            numF.setText(String.valueOf(Formations.getNumF(s)));

            ArrayList<String> cour = Cours.afficherCours(s,Integer.parseInt(id.getText()));

            for(int i=0; i<cour.size();i++) {
                listCours.getItems().add(cour.get(i));
            }

            ArrayList<AllApprenant> alp = Accee.getApprenant(Formations.getNumF(s));
            for(int i=0; i<alp.size();i++) tableStuFor.getItems().add(alp.get(i));


            ArrayList<String> q = Quiz.getQuiz(Formations.getNumF(s));
            for(int j=0; j<q.size();j++) {
                listQuiz.getItems().add(q.get(j));
            }

       }

        @FXML public void setAllStudents(ActionEvent event) {

            allStudents.toFront();
            tableAllStu.getItems().clear();
            ArrayList<AllApprenant> app = AllLearners.diplayAll();
            for (int i = 0; i < app.size(); i++)
                tableAllStu.getItems().add(app.get(i));

            if (tableAllStu.getItems().isEmpty() == false) {
                ajouterEtudiant.setDisable(false);
                supprimerEtudiant.setDisable(false);
            }
        }

        @FXML public void setAjouterEtudiant(ActionEvent event) {
            if (listFormation.getSelectionModel().getSelectedItems().isEmpty() == false) {
                allStudents.toBack();


            }
        }

        @FXML public void setSupprimerApp(ActionEvent event){

            Object o = tableStuFor.getSelectionModel().getSelectedItem();
            if(o != null){
                AllApprenant item = (AllApprenant) o;
                tableStuFor.getItems().remove(o);
                AllLearners.supprimerApprenant(item.getMatricule());
                System.out.println("Suppression dans la table");

            }


        }
    ////////////////////////////////////////////////////////////////////////////////////
       @FXML public void ajouterCour(ActionEvent event) {
            if(titreCour.getText().isEmpty() == false) {
                FileChooser fc = new FileChooser();
                fc.setTitle("Open text file");
                fc.setInitialDirectory(new File(System.getProperty("user.home")));
                fc.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Text Files ", "*.pdf"),
                        new FileChooser.ExtensionFilter("All Files ", "*.*")
                );
                File f = fc.showOpenDialog(stage);

                if (f != null) System.out.println("Choosen file " + f);
                Object o = listFormation.getSelectionModel().getSelectedItem();
                String s = (String)o;
                Cours.creerCour(titreCour.getText(),f.toString(),Formations.getNumF(s));
                titreCour.clear();



            }

        }

        @FXML public void setSupprimerCour(ActionEvent event){

        Object o = listCours.getSelectionModel().getSelectedItem();
        if(o != null){
            String item = (String)o;
            Cours.supprimerCour(item);
            System.out.println("Cour supprimer");
        }

        }
        ///////////////////////////////////////////////

    private Stage stage;

    public void init(Stage stage) {
       this.stage = stage;

    }

    @FXML public void ouvrirCour(ActionEvent event){
        try {
            Object item = listCours.getSelectionModel().getSelectedItem();
            String s = (String) item;

            String path = Cours.getPath(s);
            File f = new File(path);
            Desktop.getDesktop().open(f);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    @FXML public void setAjouterQuiz(ActionEvent event){
        if(addQuiz.getText().isEmpty() == false){
            listQuiz.getItems().add(addQuiz.getText());
            Object o = listFormation.getSelectionModel().getSelectedItem();
            String s = (String)o;
            Quiz.ajouterQuiz(addQuiz.getText(),Formations.getNumF(s));
            System.out.println("Ajout de quiz table");
        }
        else System.out.println("Champ d'ajout du cour vide");
            }

    @FXML public void setSupprimerQuiz(ActionEvent event){
        Object o = listQuiz.getSelectionModel().getSelectedItem();
        if(o != null){
            listQuiz.getItems().remove(o);
            Object ob = listFormation.getSelectionModel().getSelectedItem();
            String s = (String)ob;
            Object n = listQuiz.getSelectionModel().getSelectedItem();
            String s1 = (String)n;
            Quiz.supprimerQuiz(s1,Formations.getNumF(s));
            System.out.println("Suppression quiz table");

        }

    }

    @FXML public void setCreerQuiz(ActionEvent event){
        Object o = listQuiz.getSelectionModel().getSelectedItem();
        if(o != null){
            String s = (String)o;


        }

    }

}