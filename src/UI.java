/*
    Written by Oliver Juul Reder on 07.12.20
*/


import java.util.ArrayList;

public abstract class UI {

    static ArrayList<Guess> grid = new ArrayList<>();
    static int size;

    public static void setSize(int _size){
        size = _size;
    }

    public static void addGuess(Guess g){
        grid.add(g);
    }
}
