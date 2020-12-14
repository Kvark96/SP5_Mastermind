import java.util.ArrayList;
import java.util.Random;

public class AI {
    int[] availableColors;



    public AI(int[] availableColors) {
        this.availableColors = availableColors;

    }



    public Guess createSolutions(){
        ArrayList<Integer> solutionArray = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            solutionArray.add(availableColors[0]);          //(pickRandomColorFromColorList())], i));
        }

        return new Guess(solutionArray);
    }

    public int pickRandomColorFromColorList(){
        int index;
        Random rand = new Random();
        index = rand.nextInt(availableColors.length);
        return index;
    }
}
