package finalprojectfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * First user screen that lets them select which page they want to go into.
 * 
 * @author Brandon Sarmany, Stephen Brimer, Jason Latinovic
 */
public class MainMenuController implements Initializable {

    
    @FXML
    private AnchorPane rootPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
    /**
     * 
     * @param event once clicked, the user is sent to the draft page
     * @throws IOException thrown if the button fails to function
     */
    @FXML
    private void loadTrade(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MakeTrade.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    
    /**
     * 
     * @param event once clicked, the user is sent to the about creators page
     * @throws IOException thrown if the button fails to function
     */
    @FXML
    private void loadCreator(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AboutCreator.fxml"));
        rootPane.getChildren().setAll(pane);
}   
    /**
     * 
     * @param event once clicked, the user is sent to the help page
     * @throws IOException thrown if the button fails to function
     */
    @FXML
    private void loadHelp(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Help.fxml"));
        rootPane.getChildren().setAll(pane);
}
}
    