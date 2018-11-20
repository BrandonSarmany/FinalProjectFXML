package finalprojectfxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 *
 * the main process that takes place in the GUI. This class turns the array lists made in the player class to populate the list view. 
 * Allows the users to select the wanted player and add it to their team. Cycles through the draft process until all the players are selected.
 * If teams have taken their needed players, the finalized button then takes each teams choice and passes it on to the final screen to be viewed.
 * 
 * @author Brandon Sarmany, Stephen Brimer, Jason Latinovic
 *
 */
public class MakeTradeController implements Initializable {

    File f1 = new File("DraftPool.txt");
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextArea torontoTx;
    @FXML
    private TextArea detroitTx;
    @FXML
    private TextArea bostonTx;
    @FXML
    private TextArea newyorkTx;
    @FXML
    ListView lv;
    @FXML
    private Tab toronto;
    @FXML
    private Tab detroit;
    @FXML
    private Tab newyork;
    @FXML
    private Tab boston;
    @FXML
    private TabPane tabPane;
    @FXML
    private Label teamPicking;
    @FXML
    private ListView lvG;
    @FXML
    private Button draftButton;
    @FXML
    private Button menuButton;
    @FXML
    private TextArea roundNumber;
    @FXML
    private Button checkTeam;
    int teamCount = 0;
    int roundCount = 1;

    /**
     * creates an instance of a goalie, skater, and team objects
     */
    Goalie g1 = new Goalie();
    Skater s1 = new Skater();
    static Team team = new Team();
    /**
     * creates references of the array lists for each team
     * these were made static to be accessed in the displayTeamConroller
     */
    static ArrayList<Player> torontoArray = team.getToronto();
    static ArrayList<Player> detroitArray = team.getDetroit();
    static ArrayList<Player> bostonArray = team.getBoston();
    static ArrayList<Player> newyorkArray = team.getNewYork();
    /**
     * references the goalie and skater array list
     */
    ArrayList<String> GoalieList = g1.getList();
    ArrayList<String> SkaterList = s1.getList();
    /**
     * creates observable lists for tabView
     */
    ObservableList<String> OskaterList = FXCollections.observableArrayList();
    ObservableList<String> OgoalieList = FXCollections.observableArrayList();
    
    // Teams Observable Array List. (Add scenes to builder and set variables)
    ObservableList<String> OTeam1 = FXCollections.observableArrayList();
    ObservableList<String> OTeam2 = FXCollections.observableArrayList();
    ObservableList<String> OTeam3= FXCollections.observableArrayList();
    ObservableList<String> OTeam4 = FXCollections.observableArrayList();


    /**
     *
     * @param arg0
     * @param arg1
     * 
     * initializes the trade page. sets the names to their proper tabs (ie, goalie names 
     * in the goalie tab). The listener listens for mouse clicks on the tabs of the list view.
     * if a mouse click occurs, then the draft is enabled.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        for (String skater : SkaterList) {
            OskaterList.add(skater);
        }
        lv.setItems(OskaterList);

        for (String goalie : GoalieList) {
            OgoalieList.add(goalie);
        }
        lvG.setItems(OgoalieList);

        lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                draftButton.disableProperty().setValue(false);
            }
        });
        lvG.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                draftButton.disableProperty().setValue(false);
            }
        });

        torontoTx.setEditable(false);
        detroitTx.setEditable(false);
        bostonTx.setEditable(false);
        newyorkTx.setEditable(false);
        roundNumber.setEditable(false);
        teamPicking.setText("Toronto is Picking.");

    }

    /**
     * 
     * @param event click on the menu button
     * @throws IOException thrown in case the menu button fails to function
     */
    @FXML
    private void loadMenu(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    /**
     * 
     * @param event loads the teams to the list view
     * @throws IOException thrown in case the finalize button fails to function
     */
    @FXML
    private void loadTeams(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("displayTeam.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    /**
     *
     * @throws FileNotFoundException thrown incase the file 
     * @throws IOException thrown in case the draft button fails to function
     * 
     * This button loads the name selected player into the list view and array list to the particular team. 
     * It switches from tab to tab as the button is pressed each individual time and once the 
     * round is complete, increments the round number that is displayed. Finally, it controls 
     * the string a the top of the page to indicate which team is selecting.
     */
    public void DraftPlayer() throws FileNotFoundException, IOException {
        roundNumber.setText(Integer.toString(roundCount));
        teamCount++;
        if (teamCount == 1) {
            teamPicking.setText("Detroit is Picking");
            String textAreaString = "";

            if (lv.getSelectionModel().getSelectedItems().isEmpty() == false) {
                torontoArray.add(new Skater(lv.getSelectionModel().getSelectedItem().toString() + ""));

            }
            if (lvG.getSelectionModel().getSelectedItems().isEmpty() == false) {
                torontoArray.add(new Goalie(lvG.getSelectionModel().getSelectedItem().toString() + ""));

            }

            for (Player item : torontoArray) {
                textAreaString += item.getName() + "\r\n";
            }
            this.torontoTx.setText(textAreaString);

            deletePlayer();
            boolean go = true;
            while (go) {
                lv.getSelectionModel().clearSelection();
                lvG.getSelectionModel().clearSelection();
                go = false;
            }

            PrintWriter saveToFile = new PrintWriter("torontoFile.txt");

            for (Player str : torontoArray) {
                saveToFile.println(("Toronto: \n" + str));
            }

            tabPane.getSelectionModel().select(detroit);
            saveToFile.close();

        }
        if (teamCount == 2) {
            teamPicking.setText("Boston is Picking.");
            String textAreaString2 = "";
            if (lv.getSelectionModel().getSelectedItems().isEmpty() == false) {
                detroitArray.add(new Skater(lv.getSelectionModel().getSelectedItem() + ""));

            }
            if (lvG.getSelectionModel().getSelectedItems().isEmpty() == false) {
                detroitArray.add(new Goalie(lvG.getSelectionModel().getSelectedItem() + ""));
            }

            for (Player item : detroitArray) {
                textAreaString2 += String.format("%s%n", item);
            }

            this.detroitTx.setText(textAreaString2);

            deletePlayer();
            boolean go = true;
            while (go) {
                lv.getSelectionModel().clearSelection();
                lvG.getSelectionModel().clearSelection();
                go = false;
            }

            PrintWriter saveToFile = new PrintWriter("detroitFile.txt");

            for (Player str : detroitArray) {
                saveToFile.println(("Detroit: \n" + str));
            }
            saveToFile.close();
            tabPane.getSelectionModel().select(boston);
        }

        if (teamCount == 3) {
            teamPicking.setText("New York is Picking.");
            String textAreaString3 = "";

            if (lv.getSelectionModel().getSelectedItems().isEmpty() == false) {
                bostonArray.add(new Skater(lv.getSelectionModel().getSelectedItem() + ""));

            }
            if (lvG.getSelectionModel().getSelectedItems().isEmpty() == false) {
                bostonArray.add(new Goalie(lvG.getSelectionModel().getSelectedItem() + ""));
            }

            for (Player item : bostonArray) {
                textAreaString3 += String.format("%s%n", item);
            }
            this.bostonTx.setText(textAreaString3);

            deletePlayer();
            boolean go = true;
            while (go) {
                lv.getSelectionModel().clearSelection();
                lvG.getSelectionModel().clearSelection();
                go = false;
            }

            lv.getSelectionModel().clearSelection();

            PrintWriter saveToFile = new PrintWriter("bostonFile.txt");

            for (Player str : bostonArray) {
                saveToFile.println(("Boston: \n" + str));
            }
            saveToFile.close();
            tabPane.getSelectionModel().select(newyork);
        }

        if (teamCount == 4) {
            teamPicking.setText("Toronto is Picking");
            String textAreaString4 = "";

            if (lv.getSelectionModel().getSelectedItems().isEmpty() == false) {
                newyorkArray.add(new Skater(lv.getSelectionModel().getSelectedItem() + ""));

            }
            if (lvG.getSelectionModel().getSelectedItems().isEmpty() == false) {
                newyorkArray.add(new Goalie(lvG.getSelectionModel().getSelectedItem() + ""));
            }

            for (Player item : newyorkArray) {
                textAreaString4 += String.format("%s%n", item);
            }
            this.newyorkTx.setText(textAreaString4);

            deletePlayer();
            boolean go = true;
            while (go) {
                lv.getSelectionModel().clearSelection();
                lvG.getSelectionModel().clearSelection();
                go = false;
            }

            lv.getSelectionModel().clearSelection();

            PrintWriter saveToFile = new PrintWriter("NewYorkFile.txt");

            for (Player str : newyorkArray) {
                saveToFile.println(("NewYork: \n" + str));
            }
            saveToFile.close();

            teamCount++;
        }
        if (teamCount == 5) {
            tabPane.getSelectionModel().select(toronto);
            teamCount = 0;
            roundCount++;
            roundNumber.setText(Integer.toString(roundCount));
        }
        draftButton.disableProperty().setValue(true);
    }
    
    /**
     * removes the selected player from the list view once drafted
     */
    @FXML
    public void deletePlayer() {
        lv.getItems().removeAll(lv.getSelectionModel().getSelectedItem());
        lvG.getItems().removeAll(lvG.getSelectionModel().getSelectedItem());

    }

}
