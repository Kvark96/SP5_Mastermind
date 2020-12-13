/*
    Written by Oliver Juul Reder on 07.12.20
*/
import java.util.ArrayList;
import java.util.Arrays;

public class Guess {
    private static int numberOfGuesses = 0;
    private final int id;
    private ArrayList<Color> colors;
    private int[] checkArr;

    public Guess(ArrayList<Color> colors) {
        id = ++numberOfGuesses;
        this.colors = colors;
        checkArr = new int[4];
        //System.out.println(Arrays.toString(checkArr));
    }

    public void compare(Guess guess){
        System.out.println("Our guess is:");
        System.out.println(this.colors + "\n");
        System.out.println("The answer is:");
        System.out.println(guess.getColors());
        for(int i = 0; i < colors.size(); i++){
            if (colors.get(i) == guess.getColors().get(i)){
                checkArr[i] = 2;
            } else if(guess.getColors().contains(colors.get(i)))
            {
                checkArr[i] = 1;
            } else {
                checkArr[i] = 0;
            }
        }
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
