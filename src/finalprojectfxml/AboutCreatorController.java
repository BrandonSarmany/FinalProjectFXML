/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * This controller shows a simple description about the creators.
 * 
 * @author Brandon Sarmany, Jason Latinovic, Stephen Brimer
 */
public class AboutCreatorController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private AnchorPane rootPane;
     @FXML
     private TextArea creatorTx;
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        creatorTx.setEditable(false);
    }  
    @FXML
    private void loadMenu(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
