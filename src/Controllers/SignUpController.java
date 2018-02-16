package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import javafx.fxml.FXML;
import javafx.scene.Node;

public class SignUpController {

    public JFXButton annuler;

    @FXML

    protected JFXButton btnX;
    @FXML
    private JFXHamburger ham1;


    public void makeAnnuler(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

    public void makeValider(ActionEvent actionEvent) {
    }

    @FXML
    public void close(ActionEvent actionEvent) throws Exception
    {
        Stage stage = (Stage) btnX.getScene().getWindow();
        stage.close();
    }

    
}
