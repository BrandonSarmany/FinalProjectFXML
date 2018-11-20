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
 * Controls the help page
 * 
 * @author Brandon Sarmany, Stephen Brimer, Jason Latinovic
 */
public class HelpController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextArea Q1;
    @FXML
    private TextArea Q2;
    @FXML
    private TextArea Q3;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Q1.setEditable(false);
        Q2.setEditable(false);
        Q3.setEditable(false);
    }

    /**
     * 
     * @param event on mouse click, the user will be returned to the main menu
     * @throws IOException thrown if the button fails to function
     */
    @FXML
    private void loadMenu(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
