/*
    Written by Oliver Juul Reder on 07.12.20
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Guess {
    private ArrayList<Integer> colors;
    private int[] checkArr;

    public Guess(ArrayList<Integer> colors) {
        this.colors = colors;
        checkArr = new int[4];
    }

    public void compare(Guess guess){
        ArrayList<Integer> answer = guess.getColors();

        checkArr = checkExactMatches(colors, answer);
        checkArr = checkPartialMatches(checkArr, colors, answer);
    }

    private int[] shuffleArray(int[] arr){
        Random rnd = new Random();
        for(int i = 0; i < arr.length; i++){
            int nextVal = rnd.nextInt(arr.length);
            int tempVal = arr[i];
            arr[i] = arr[nextVal];
            arr[nextVal] = tempVal;
        }
        return arr;
    }

    private int[] checkExactMatches(ArrayList<Integer> guess, ArrayList<Integer> answer){
        int[] returnArray = new int[4];
        for(int i = 0; i < guess.size(); i++){
            if(guess.get(i).equals(answer.get(i))) returnArray[i] = 2;
        }
        return returnArray;
    }

    private int[] checkPartialMatches(int[] check, ArrayList<Integer> guess, ArrayList<Integer> answer){
        for(int i = 0; i < guess.size(); i++){
            if(check[i] == 2) continue;
            for(int j = 0; j < answer.size(); j++){
                if(guess.get(i).equals(answer.get(j)) && check[j] != 2) check[i] = 1;
            }
        }
        return check;
    }


    public ArrayList<Integer> getColors() {
        return colors;
    }

    public int[] getCheckArr() {
        return checkArr;
    }
}
