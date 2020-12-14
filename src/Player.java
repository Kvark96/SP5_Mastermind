/*
    Written by Oliver Juul Reder on 07.12.20
*/
import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> selectedColors;

    public Player() {
        selectedColors = new ArrayList<>();
    }

    public void select(int col){
        selectedColors.add(col);
    }

    public Guess guess(){
        return new Guess(selectedColors);
    }

    public void mousePressed() {
        System.out.println("Mouse pressed");
    }

    public void mouseReleased() {
        System.out.println("Mouse released");
    }
}
