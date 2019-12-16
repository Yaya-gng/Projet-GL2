package sample;


import dateBase.ProfilApprenantDB;
import dateBase.ProfilInstructorDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Inscription implements Initializable {
	

	@FXML private RadioButton r1,r2;
	@FXML private TextField t1,t2,t3,t4,grade,spec, level;
	@FXML private Spinner<Integer> section;
	@FXML private Button conf,ret, parcourir;
	@FXML private DatePicker d;
	@FXML private PasswordField p;
	@FXML private Label lb;
	@FXML private ImageView image;

	SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);


	
	public void r1(ActionEvent event) {
		
		if(r1.isSelected() == true && r2.isSelected()==false) {
		
			level.setDisable(true);
			section.setDisable(true);
			grade.setDisable(false);

			
		}		
	}
	
	public void r2(ActionEvent event) {
		   if(r2.isSelected() == true && r1.isSelected() == false) {
			  
			grade.setDisable(true);
			
			     t1.setDisable(false);
				 level.setDisable(false);
				 section.setDisable(false);
				 spec.setDisable(false);
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
			if(t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || grade.getText().isEmpty() || spec.getText().isEmpty() || p.getText().isEmpty())
					{	
						lb.setVisible(true);	
						lb.setText("Un ou plusieurs champs sont irremplis");
					}
			else {			
		ProfilInstructorDB.Inscrire(Integer.parseInt(t1.getText()),t2.getText(), t3.getText(), java.sql.Date.valueOf(d.getValue()), t4.getText(), grade.getText(), spec.getText(),p.getText(), image.getImage().getUrl());
		t2.clear();
		t3.clear();
		t4.clear();
		spec.clear();
		grade.clear();
		p.clear();
		image.setImage(null);
			}
		
		}
		
		else if(r2.isSelected()) {
			
			if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || level.getText().isEmpty() || spec.getText().isEmpty() || p.getText().isEmpty())
			{	
				lb.setVisible(true);	
				lb.setText("Un ou plusieurs champs sont irremplis");
			}
			else {
			ProfilApprenantDB.Inscrire(Integer.parseInt(t1.getText()),t2.getText() ,t3.getText(), java.sql.Date.valueOf(d.getValue()),t4.getText(),spec.getText(), Integer.parseInt(level.getText()),section.getValue(), p.getText(), image.getImage().getUrl());
			t1.clear();
			t2.clear();
			t3.clear();
			t4.clear();
			level.clear();
			spec.clear();
			p.clear();
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
		private Stage stage;

	@FXML public void setParcourir(){

		FileChooser fc = new FileChooser();
		fc.setTitle("Open File");
		fc.setInitialDirectory(new File(System.getProperty("user.home")));
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Image Files ", "*.jpg")
				// new FileChooser.ExtensionFilter("Image Files", "*.jpeg"),
				//new FileChooser.ExtensionFilter("Image Files", "*.png")
		);

		image.setImage(null);
		File f = fc.showOpenDialog(stage);
		String imagePath = f.toURI().toString();
		System.out.println(imagePath);

		Image im = new Image(imagePath);
		image.setImage(im);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		section.setValueFactory(valueFactory);
	}
}
