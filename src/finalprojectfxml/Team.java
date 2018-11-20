package finalprojectfxml;

import java.util.ArrayList;

/**
 *
 * Instantiates an array used to populate players of each team and is then filled on the maketradeController from the users input.
 * @author Brandon Sarmany, Jason Latinovic, Stephen Brimer
 */
public class Team {

    /**
     * These array lists hold the player which are selected by the user.
     */
    private ArrayList<Player> torontoArray = new ArrayList<>();
    private ArrayList<Player> detroitArray = new ArrayList<>();
    private ArrayList<Player> bostonArray = new ArrayList<>();
    private ArrayList<Player> newyorkArray = new ArrayList<>();

    /**
     * object which holds the players as an array list
     */
    public Team() {
    }

    /**
     *
     * @return the collection of players on the Toronto array list
     */
    public ArrayList<Player> getToronto() {
        return torontoArray;
    }

    /**
     *
     * @return the collection of players on the Detroit array list
     */
    public ArrayList<Player> getDetroit() {
        return detroitArray;
    }

    /**
     *
     * @return the collection of players on the Boston array list
     */
    public ArrayList<Player> getBoston() {
        return bostonArray;
    }

    /**
     *
     * @return the collection of players on the Boston array list
     */
    public ArrayList<Player> getNewYork() {
        return newyorkArray;
    }

    /**
     *
     * @param p the player object to be added to the Toronto player array list
     */
    public void addTorontoPlayer(Player p) {
        torontoArray.add(p);
    }

    /**
     *
     * @param p the player object to be added to the Detroit player array list
     */
    public void addDetroitPlayer(Player p) {
        detroitArray.add(p);
    }

    /**
     *
     * @param p the player object to be added to the Boston player array list
     */
    public void addBostonPlayer(Player p) {
        bostonArray.add(p);
    }

    /**
     *
     * @param p the player object to be added to the New York player array list
     */
    public void addNewYorkPlayer(Player p) {
        newyorkArray.add(p);
    }

}
