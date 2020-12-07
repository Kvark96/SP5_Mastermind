import java.awt.*;
import java.util.Random;

public class AI {
    Color[] availableColors;

    public AI(Color[] availableColors) {
        this.availableColors = availableColors;
    }



    public Color[] createSoloutions(){
        int soloutionArray[];
        soloutionArray = new int[4];
        for(int i = 0; i < soloutionArray.length ; i++){
            pickRandomColorFromColorList(Color[] availableColors);
        }
        return soloutionArray;
    }

    public Color pickRandomColorFromColorList(Color[] availableColors){
        Random rand = new Random();

    }
}
