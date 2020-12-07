/*
    Written by Oliver Juul Reder on 07.12.20
*/
import java.util.ArrayList;

public class Guess {
    private static int numberOfGuesses = 0;
    private final int id;
    private ArrayList<Color> colors;
    private int[] checkArr;

    public Guess(ArrayList<Color> colors) {
        id = ++numberOfGuesses;
        this.colors = colors;
    }

    public int[] compare(Guess guess){
        return guess.checkArr;
    }

    public void display(){
    }

    public static int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public int[] getCheckArr() {
        return checkArr;
    }
}
