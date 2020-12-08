import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class AI {
    ArrayList<Color> availableColors;



    public AI(ArrayList<Color> availableColors) {
        this.availableColors = availableColors;

    }



    public ArrayList<Color> createSoloutions(){
        int rnd;
        ArrayList<Color> soloutionArray = new ArrayList<Color>();
        for(int i = 0; i < soloutionArray.size() ; i++){
            soloutionArray.add(availableColors.get(pickRandomColorFromColorList()));
        }
        return soloutionArray;
    }

    public int pickRandomColorFromColorList(){
        int index;
        Random rand = new Random();
        index = rand.nextInt(availableColors.size());
        return index;
    }
}
