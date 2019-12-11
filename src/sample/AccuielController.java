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
    private Pane profil, admin, prof,formationIns,app,allStudents, quiz, courQ;
    @FXML
    private Parent avatar1;
    @FXML TextField t1,t2,t3,t4,t5,t6,gra,special,nve,sec,nomFormation, titreCour, addQuiz;
    @FXML Button modify, confirme,disco, ressourceInst, ajouterFormInst, supprimerFormInst, afficherTout, tle, ajouterEtudiant, supprimerEtudiant, supprimerCour, openFile, addFile, ajouterQuiz, supprimerQuiz;
    @FXML private Label id, nom, prenom, grade,spec,niv,section, numF,id_quiz,id_form;
    @FXML
    private Button modifierQuiz;
    @FXML private  TextField ques1, rep1, ch1q1, ch2q1, ch3q1, ch4q1;
    @FXML private  TextField ques2, rep2, ch1q2, ch2q2, ch3q2, ch4q2;
    @FXML private  TextField ques3, rep3, ch1q3, ch2q3, ch3q3, ch4q3;
    @FXML private  TextField ques4, rep4, ch1q4, ch2q4, ch3q4, ch4q4;

    @FXML
    private ListView listFormation, listCours, listQuiz, listCoursQ;
   @FXML private TableView<Cour> tableCours;
   @FXML private TableView<AllApprenant> tableAllStu,tableStuFor;
   @FXML private TableColumn<Cour, String> c1,c2;
   @FXML private TableColumn<AllApprenant,String> nomC, preC, specC,mat,nomC1, prenomC1, specC1, mat1;

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
        mat.setCellValueFactory(new PropertyValueFactory<>("matricule"));

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

    @FXML public void RessourceInst(ActionEvent event){
        formationIns.toFront();
        ArrayList<String> frm = Formations.afficherFormation(Integer.parseInt(id.getText()));
        ajouterFormInst.setDisable(false);
        supprimerFormInst.setDisable(false);
        afficherTout.setDisable(false);
        listFormation.getItems().clear();
        listCours.getItems().clear();
        listQuiz.getItems().clear();
        tableStuFor.getItems().clear();

        listFormation.getItems().addAll(frm);

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


            openFile.setDisable(false);
            addFile.setDisable(false);
            supprimerCour.setDisable(false);

            tle.setDisable(false);
            ajouterEtudiant.setDisable(false);
            supprimerEtudiant.setDefaultButton(false);

            ajouterQuiz.setDisable(false);
            modifierQuiz.setDisable(false);
            supprimerQuiz.setDisable(false);

            Object item = listFormation.getSelectionModel().getSelectedItem();
            String s = (String)item;
            id_form.setText(String.valueOf(Formations.getNumF(s)));

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
                Object o = tableAllStu.getSelectionModel().getSelectedItem();

            if (o != null) {
                AllApprenant a = (AllApprenant)o;
                allStudents.toBack();
                Accee.setAccee(a.getMatricule(),Integer.parseInt(id_form.getText()));
                tableStuFor.getItems().add(a);
            }
        }

        @FXML public void setSupprimerApp(ActionEvent event){

            Object o = tableStuFor.getSelectionModel().getSelectedItem();
            if(o != null){
                AllApprenant item = (AllApprenant) o;
                tableStuFor.getItems().remove(o);
                Accee.supprimerApprenant(item.getMatricule());
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
                Cours.creerCour(titreCour.getText(),f.toString(),Integer.parseInt(id_form.getText()));
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
            Object o = listFormation.getSelectionModel().getSelectedItem();
            if(o != null){
            String s = (String)o;
               if(addQuiz.getText().isEmpty() == false){
                   listQuiz.getItems().add(addQuiz.getText());
                   Quiz.ajouterQuiz(addQuiz.getText(),Integer.parseInt(id_form.getText()));

                   id_quiz.setText(String.valueOf(Quiz.getIdQuiz(addQuiz.getText())));
                   quiz.toFront();

               }
            }
    }
    boolean choixIn(String rep, String c1, String c2, String c3, String c4){
        boolean b = false;
        if(rep.equals(c1)) return true;
        if(rep.equals(c2)) return true;
        if(rep.equals(c3)) return true;
        if(rep.equals(c4)) return true;
        return b;
    }

    @FXML public void confirmeQuiz(ActionEvent event){

        if(ques1.getText().isEmpty() == false && ques2.getText().isEmpty() == false && ques3.getText().isEmpty() == false && ques4.getText().isEmpty() == false && rep1.getText().isEmpty() == false && rep2.getText().isEmpty() == false && rep3.getText().isEmpty() == false && rep4.getText().isEmpty() == false && ch1q1.getText().isEmpty() == false && ch1q2.getText().isEmpty() == false && ch1q3.getText().isEmpty() == false && ch1q4.getText().isEmpty() == false && ch2q1.getText().isEmpty() == false && ch2q2.getText().isEmpty() == false && ch2q3.getText().isEmpty() == false && ch2q4.getText().isEmpty() == false && ch3q1.getText().isEmpty() == false && ch3q2.getText().isEmpty() == false && ch3q3.getText().isEmpty() == false && ch3q4.getText().isEmpty() == false && ch4q1.getText().isEmpty() == false && ch4q2.getText().isEmpty() == false && ch4q3.getText().isEmpty() == false && ch4q4.getText().isEmpty() == false ){
        if(choixIn(rep1.getText(),ch1q1.getText(),ch2q1.getText(),ch3q1.getText(),ch4q1.getText())&& choixIn(rep2.getText(),ch1q2.getText(),ch2q2.getText(),ch3q2.getText(),ch4q2.getText())&& choixIn(rep3.getText(),ch1q3.getText(),ch2q3.getText(),ch3q3.getText(),ch4q3.getText())&& choixIn(rep4.getText(),ch1q4.getText(),ch2q4.getText(),ch3q4.getText(),ch4q4.getText()))  {
            Question.setQuestion(Integer.parseInt(id_quiz.getText()), ques1.getText(), rep1.getText(), ch1q1.getText(), ch2q1.getText(), ch3q1.getText(), ch4q1.getText());
            Question.setQuestion(Integer.parseInt(id_quiz.getText()), ques2.getText(), rep2.getText(), ch1q2.getText(), ch2q2.getText(), ch3q2.getText(), ch4q2.getText());
            Question.setQuestion(Integer.parseInt(id_quiz.getText()), ques3.getText(), rep3.getText(), ch1q3.getText(), ch2q3.getText(), ch3q3.getText(), ch4q3.getText());
            Question.setQuestion(Integer.parseInt(id_quiz.getText()), ques4.getText(), rep4.getText(), ch1q4.getText(), ch2q4.getText(), ch3q4.getText(), ch4q4.getText());
                System.out.println("Quiz cree");
        }
        else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Informaton Dialog");
            a.setHeaderText("Look, an information Dialog");
            a.setContentText("La reponse n'existe pas dans les choix");
            a.showAndWait();
        }

        }
        else {
            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setTitle("Informaton Dialog");
            b.setHeaderText("Look, an information Dialog");
            b.setContentText("Remplissez tous les champs");
            b.showAndWait();
        }
    }

    @FXML public void setSupprimerQuiz(ActionEvent event){
        Object o = listQuiz.getSelectionModel().getSelectedItem();
        if(o != null){
            String s1 = (String)o;
            id_quiz.setText(String.valueOf(Quiz.getIdQuiz(s1)));
            listQuiz.getItems().remove(o);
            Quiz.supprimerQuiz(Integer.parseInt(id_quiz.getText()));
            System.out.println("Suppression quiz table");

        }
    }

    @FXML public void setModifierQuiz(ActionEvent event){
        Object o = listQuiz.getSelectionModel().getSelectedItem();
        if(o != null){
                String s = (String)o;
                id_quiz.setText(String.valueOf(Quiz.getIdQuiz(s)));
                ArrayList<Questions> q = Question.getQestQuiz(Integer.parseInt(id_quiz.getText()));
                quiz.toFront();
                ques1.setText(q.get(0).getQ());
                rep1.setText(q.get(0).getR());
                ch1q1.setText(q.get(0).getC1());
                ch2q1.setText(q.get(0).getC2());
                ch3q1.setText(q.get(0).getC3());
                ch4q1.setText(q.get(0).getC4());
            ques2.setText(q.get(1).getQ());
            rep2.setText(q.get(1).getR());
            ch1q2.setText(q.get(1).getC1());
            ch2q2.setText(q.get(1).getC2());
            ch3q2.setText(q.get(1).getC3());
            ch4q2.setText(q.get(1).getC4());
                                ques3.setText(q.get(2).getQ());
                                rep3.setText(q.get(2).getR());
                                ch1q3.setText(q.get(2).getC1());
                                ch2q3.setText(q.get(2).getC2());
                                ch3q3.setText(q.get(2).getC3());
                                ch4q3.setText(q.get(2).getC4());
                                    ques4.setText(q.get(3).getQ());
                                    rep4.setText(q.get(3).getR());
                                    ch1q4.setText(q.get(3).getC1());
                                    ch2q4.setText(q.get(3).getC2());
                                    ch3q4.setText(q.get(3).getC3());
                                    ch4q4.setText(q.get(3).getC4());
        }

    }

    @FXML public void ouvrirCourQ(ActionEvent event){

    }

}