/*
    Written by Oliver Juul Reder on 07.12.20
*/
import java.util.ArrayList;

public class Player {
    private ArrayList<Color> selectedColors = new ArrayList<>();

    public Player() {
    }

    public void select(Color col){
        selectedColors.add(col);
    }

    public Guess guess(){
        return new Guess(selectedColors);
    }
}
