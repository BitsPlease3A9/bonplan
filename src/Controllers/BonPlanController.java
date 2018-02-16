/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.base.JFXTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Radhi
 */
public class BonPlanController extends ListView<String> implements Initializable{

    @FXML
    private JFXButton btnX;
    @FXML
    private JFXHamburger ham1;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private AnchorPane pane1;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXTreeTableView<User> treeview;
    @FXML
    private JFXButton btnAddPlan;
    @FXML
    private JFXButton btnShowPlans;
    @FXML
    private JFXButton btnMesPlans;

    @FXML
    private void makeAddPlan(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/bonPlanAdd.fxml"));
        Parent root = loader.load();
        //root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        //scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    private void makeShowPlans(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/bonPlan.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    private void makeMesPlans(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/bonPlanMine.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }
   
    class User extends RecursiveTreeObject<User>
    {
        
        ObjectProperty<Image> image;
        StringProperty department;
        StringProperty username;
        StringProperty age;

        public User(Image image, String department, String username, String age) {
            this.image = new SimpleObjectProperty<>(image);
            this.department = new SimpleStringProperty(department);
            this.username = new SimpleStringProperty(username);
            this.age = new SimpleStringProperty(age);
        }
        

        public User(String department ,String username, String age) {
            this.username = new SimpleStringProperty(username);
            this.age = new SimpleStringProperty(age);
            this.department = new SimpleStringProperty(department);
        }
        
    }
    
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) btnX.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        afficher();   
        hamburger();           
        
    }
    
    private void afficher()
    {
        JFXTreeTableColumn<User,String> deptName = new JFXTreeTableColumn<>("Bon Plan");
        deptName.setPrefWidth(150);
        deptName.setCellValueFactory((TreeTableColumn.CellDataFeatures<User, String> param) -> param.getValue().getValue().department);
        
        JFXTreeTableColumn<User,String> ageCol = new JFXTreeTableColumn<>("Age");
        ageCol.setPrefWidth(150);
        ageCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<User, String> param) -> param.getValue().getValue().age);
        
        JFXTreeTableColumn<User,String> nameCol = new JFXTreeTableColumn<>("Username");
        nameCol.setPrefWidth(150);
        nameCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<User, String> param) -> param.getValue().getValue().username);
        
        JFXTreeTableColumn<User,Image> imageCol = new JFXTreeTableColumn<>("Image");
        imageCol.setPrefWidth(300);
        imageCol.setCellValueFactory((TreeTableColumn.CellDataFeatures<User, Image> param) -> param.getValue().getValue().image);
        
        
        
        ObservableList<User> users = FXCollections.observableArrayList();
        
        users.add(new User(new Image("/Content/img9.JPG"),"Camping - Zaghouan","Mehdi Jrebi","24"));
        users.add(new User(new Image("/Content/DSC_0383.JPG"),"Bibo Café - Manar1","Nacer Cherni","35"));
        users.add(new User(new Image("/Content/DSC_0173.JPG"),"Hôtel La cigogne - Tabarka ","Radicali","30"));
        users.add(new User(new Image("/Content/DSC_0139.JPG"),"Randonnée - Bni Mtir","Allalah","20"));
        users.add(new User(new Image("/Content/img9.JPG"),"Camping - Zaghouan","Mehdi Jrebi","24"));
        users.add(new User(new Image("/Content/DSC_0383.JPG"),"Bibo Café - Manar1","Nacer Cherni","35"));
        users.add(new User(new Image("/Content/DSC_0173.JPG"),"Hôtel La cigogne - Tabarka ","Radicali","30"));
        users.add(new User(new Image("/Content/DSC_0139.JPG"),"Randonnée - Bni Mtir","Allalah","20"));
        users.add(new User(new Image("/Content/img9.JPG"),"Camping - Zaghouan","Mehdi Jrebi","24"));
        users.add(new User(new Image("/Content/DSC_0383.JPG"),"Bibo Café - Manar1","Nacer Cherni","35"));
        users.add(new User(new Image("/Content/DSC_0173.JPG"),"Hôtel La cigogne - Tabarka ","Radicali","30"));
        users.add(new User(new Image("/Content/DSC_0139.JPG"),"Randonnée - Bni Mtir","Allalah","20"));
        
        final TreeItem<User> root = new RecursiveTreeItem<>(users,RecursiveTreeObject::getChildren);
        
        imageCol.setCellFactory(column -> new JFXTreeTableCell<User, Image>(){ 
        private final ImageView imageView1 = new ImageView();             
        private final ImageView imageView2 = new ImageView();             
        private final Tooltip tooltip = new Tooltip(); 

        { 
            imageView1.setFitHeight(200); 
            imageView1.setPreserveRatio(true); 
            imageView1.setSmooth(true); 
            tooltip.setText(null); 
            tooltip.setGraphic(imageView2); 
        } 

        @Override 
        protected void updateItem(Image item, boolean empty) { 
            super.updateItem(item, empty);  
            setGraphic(null); 
            setText(null); 
            setTooltip(null); 
            if (!empty && item != null) { 
                imageView1.setImage(item); 
                imageView2.setImage(item); 
                setGraphic(imageView1); 
                setTooltip(tooltip); 
            } 
        }             
    });
        
        treeview.getColumns().addAll(imageCol,deptName,nameCol,ageCol);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
    }
    
    
    
    
    /*private void setNode(Node node)
    {
        
        
        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }*/
    
    
    
    private void hamburger()
    {
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
            System.out.println("Erreur hamburger!");
        }
    }

    
    
}
