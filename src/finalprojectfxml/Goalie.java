package finalprojectfxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * used as a way to get the goalies name and populate that name into a string array list. A subclass of the player class.
 * 
 * @author Brandon Sarmany, Jason Latinovic, Stephen Brimer
 */
public class Goalie extends Player {

    private ArrayList<String> GoalieList = new ArrayList<String>();
    File gFile = new File("GoalieDraft.txt");

    /**
     * creates an instance of a goalie object by reading from the
     * GoalieDraft.txt file
     */
    public Goalie() {
        Scanner g1 = null;
        try {
            g1 = new Scanner(gFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (g1.hasNext()) {
            GoalieList.add(g1.nextLine());
        }
        g1.close();
    }

    /**
     * 
     * @param name the name of the goalie
     */
    public Goalie(String name) {
        super(name);
    }

    /**
     * 
     * @return returns the array list of goalie objects as a string
     */
    public ArrayList<String> getList() {
        return GoalieList;
    }

    /**
     * 
     * @return returns the name of the goalie object
     */
    @Override
    public String toString() {
        return this.getName();
    }

}
