package sample;
import dateBase.*;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import javafx.event.ActionEvent;

import javax.swing.*;

import dateBase.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private Button log,rm,sm,bm,wm;
    @FXML private Pane black,green,red;
    @FXML private Parent avatar1;
    @FXML private TextField t;
    @FXML private PasswordField p;
    @FXML private Label l;

    
    
    public void Connexion(ActionEvent event) {
	
	if(t.getText().isEmpty()  || p.getText().isEmpty()) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Informaton Dialog");
		a.setHeaderText("Look, an information Dialog");
		a.setContentText("Username or password wrong or empty");
		a.showAndWait();
		
		}
	
	
	int a = User.Connect(t.getText(),p.getText());
	if(a == 0) { 
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Accueil1.fxml"));
			Scene scene = new Scene(root);
			Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
			s.setScene(scene);
			s.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
	else if(a == 1) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Accueil1.fxml"));
			Scene scene = new Scene(root);
			Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
			s.setScene(scene);
			s.show();
				
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	else if( a == 2) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Accueil1.fxml"));
			Scene scene = new Scene(root);
			Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
			s.setScene(scene);
			s.show();
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		Alert al= new Alert(AlertType.INFORMATION);
		al.setTitle("Informaton Dialog");
		al.setHeaderText("Look, an information Dialog");
		al.setContentText("Access invalide");	
		al.showAndWait();
		
	}
	else {
		
	}
	
}

////////////////////////////////////////////////////////////////////////////////////////////////////
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
       
       //////////////////////////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	l.setText(String.valueOf(Connecter.getConnected()));
    	
    }
    ///////////////////////////////////////////////////////////////////////////////////
    public void Inscrire(ActionEvent event) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
			Scene scene = new Scene(root);
			Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
			s.setScene(scene);
			s.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
}
    
    
    
}
