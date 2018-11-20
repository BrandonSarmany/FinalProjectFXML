/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalprojectfxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * used as a way to get the skaters name and populate that name into a string array list. A subclass of the player class.
 * 
 * @author Brandon Sarmany, Jason Latinovic, Stephen Brimer
 */
public class Skater extends Player {

    /**
     *  Holds objects of type skater as strings.
     */
    private ArrayList<String> SkaterList = new ArrayList<String>();
    /**
     * The file to read from to create player objects.
     */
    File fFile = new File("SkaterDraft.txt");

    /**
     * creates Skater object by reading from the SkaterDraft.txt file
     */
    public Skater() {

        Scanner s1 = null;
        try {
            s1 = new Scanner(fFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s1.hasNext()) {
            SkaterList.add(s1.nextLine());
        }
        s1.close();
    }

    /**
     * 
     * @param name creates a player of type skater
     */
    public Skater(String name) {
        super(name);
    }

    /**
     * 
     * @return returns an array list of type String of the players
     */
    public ArrayList<String> getList() {
        return SkaterList;
    }

    /**
     * 
     * @return returns the name of the Skater object
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
