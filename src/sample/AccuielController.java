package sample;
import dateBase.Connecter;
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
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;

public class AccuielController implements Initializable {
    @FXML
    private Pane black, green, red;
    @FXML
    private Parent avatar1;
    @FXML private Label l;
    @FXML
    private Button log, rm, sm, bm, wm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        l.setText(String.valueOf(Connecter.getConnected()));
    }

    @FXML
    void affect(ActionEvent event) {

        if (event.getSource() == sm) {
            black.toFront();
        }
        if (event.getSource() == bm) {
            green.toFront();
        }
    }

    @FXML
    public void click() {

        red.toFront();

    }

}