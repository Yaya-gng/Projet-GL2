package sample;


import dateBase.ProfilInstructorDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Inscription {
	

	@FXML RadioButton r1,r2,level1,level2;
	@FXML TextField t1,t2,t3,t4,grade,spec1,spec2;
	@FXML Spinner<Integer> year,section;
	@FXML Button conf,ret;
	@FXML DatePicker d;
	@FXML PasswordField p;
	@FXML Label lb;
		
	
	public void r1(ActionEvent event) {
		
		if(r1.isSelected() == true && r2.isSelected()==false) {
		
			level1.setDisable(true);
			level2.setDisable(true);
			year.setDisable(true);
			section.setDisable(true);
			spec1.setDisable(true);
			t1.setDisable(true);
			
			
			grade.setDisable(false);
			spec2.setDisable(false);
			
		}		
	}
	
	public void r2(ActionEvent event) {
		   if(r2.isSelected() == true && r1.isSelected() == false) {
			  
			grade.setDisable(true);
			spec2.setDisable(true);
			
			t1.setDisable(false);
				 level1.setDisable(false);
					level2.setDisable(false);
					year.setDisable(false);
					section.setDisable(false);
					spec1.setDisable(false);
				
			
		}
		  
	}
	
	public void Return(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
			Scene scene = new Scene(root);
			Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
			s.setScene(scene);
			s.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirme(ActionEvent event) {
		
		if(r1.isSelected()) {
			if(t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || grade.getText().isEmpty() || spec2.getText().isEmpty() || p.getText().isEmpty())
					{	
						lb.setVisible(true);	
						lb.setText("Un ou plusieurs champs sont irremplis");
					}
			else {			
		ProfilInstructorDB.Inscrire(t2.getText(), t3.getText(), (java.sql.Date) d.getDayCellFactory(), t4.getText(), grade.getText(), spec2.getText(),p.getText());
		t2.setText("");
		t3.setText("");
		t4.setText("");
		spec2.setText("");
		grade.setText("");
		p.setText("");
			}
		
		}
		
		else if(r2.isSelected()) {
			
			if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || level1.getText().isEmpty() || spec1.getText().isEmpty() || p.getText().isEmpty())
			{	
				lb.setVisible(true);	
				lb.setText("Un ou plusieurs champs sont irremplis");
			}
			else {
			//ProfilApprenantDB.Inscrire(14789,t2.getText() , t3.getText(), (java.sql.Date) d.getDayCellFactory(),t4.getText(), 3, level1.getText(), spec1.getText(), p.getText());
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			spec1.setText("");
			p.setText("");
			}
		}
		
		Alert al = new Alert(AlertType.INFORMATION);
		al.setTitle("Informaton Dialog");
		al.setHeaderText("Look, an information Dialog");
		al.setContentText("Inscription's done perfectly");
		al.showAndWait();
		
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
			Scene scene = new Scene(root);
			Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
			s.setScene(scene);
			s.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
 

}
