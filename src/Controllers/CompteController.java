/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Radhi
 */
public class CompteController implements Initializable{

    @FXML
    private JFXButton btnX;
    @FXML
    private JFXHamburger ham1;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane pane1;

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) btnX.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane box = FXMLLoader.load(getClass().getResource("/views/drawerContent.fxml"));
        
            drawer.setSidePane(box);
            
            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(ham1);
        
            ham1.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
            transition.setRate(transition.getRate()*(-1));
            transition.play();
            
            
            
            if(drawer.isShown())
            {
                transition.setRate(-1);
                drawer.close();
            }
            else
            {
                transition.setRate(1);
                drawer.open();
            }
        });
        
        } catch (IOException ex) {
            Logger.getLogger(BonPlanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
