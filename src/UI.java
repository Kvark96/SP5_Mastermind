/*
    Written by Oliver Juul Reder on 07.12.20
*/
import java.util.ArrayList;

public class UI{

    static ArrayList<Guess> grid;
    public UI(){
        grid = new ArrayList<>();
    }

    public static void addGuess(Guess g){
        grid.add(g);
    }
}
