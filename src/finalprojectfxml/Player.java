package finalprojectfxml;

/**
 *
 * Super class of the skater and goalie class.
 * 
 * @author Brandon Sarmany, Jason Latinovic, Stephen Brimer
 */
public abstract class Player {

    /**
     * Holds the string of the player name.
     */
    String name;

    /**
     * Creates an instance of a Player object
     */
    public Player() {
    }

    /**
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     *
     * @return returns the string of the player name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return returns a formatted the string of the of the player.
     */
    @Override
    public String toString() {
        return this.getName();
    }

}
