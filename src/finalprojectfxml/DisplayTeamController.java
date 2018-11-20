package finalprojectfxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * This controller will display the finalized team after the draft process is complete. The buttons display the text file that the teams are in.
 * 
 * @author Brandon Sarmany, Stephen Brimer, Jason Latinovic
 */
public class DisplayTeamController implements Initializable {

    
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button menuButton;
    @FXML
    private TextArea TorontoFinal;
    @FXML
    private TextArea DetroitFinal;
    @FXML
    private TextArea BostonFinal;
    @FXML
    private TextArea NewYorkFinal;
    @FXML
    private Button showTorontoTx;
    @FXML
    private Button showDetroitTx;
    @FXML
    private Button showBostonTx;
    @FXML
    private Button showNewYorkTx;

    /**
     * 
     * @param event mouse click will move the user back to the main menu
     * @throws IOException thrown in case the button fails to function
     */
    @FXML
    private void loadMenu(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    @FXML
    private void sTTx(ActionEvent event) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "torontoFile.txt");
        pb.start();
    }
    @FXML
    private void sDTx(ActionEvent event) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "detroitFile.txt");
        pb.start();
    }
    @FXML
    private void sBTx(ActionEvent event) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "bostonFile.txt");
        pb.start();
    }
    @FXML
    private void sNYx(ActionEvent event) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "NewYorkFile.txt");
        pb.start();
    }

    /**
     * 
     * @param url 
     * @param rb 
     * 
     * Initializes the view team page once the finalize button is pressed on the draft page.
     * Traverses through each teams array and displays them in the text area.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TorontoFinal.setEditable(false);
        DetroitFinal.setEditable(false);
        BostonFinal.setEditable(false);
        NewYorkFinal.setEditable(false);

        System.out.println(MakeTradeController.torontoArray);
        for (Player player : MakeTradeController.torontoArray) {
            TorontoFinal.appendText(player.toString() + "\n");
        }

        for (Player player1 : MakeTradeController.detroitArray) {
            DetroitFinal.appendText(player1.toString() + "\n");
        }

        for (Player player2 : MakeTradeController.bostonArray) {
            BostonFinal.appendText(player2.toString() + "\n");
        }

        for (Player player3 : MakeTradeController.newyorkArray) {
            NewYorkFinal.appendText(player3.toString() + "\n");
        }

    }

}
