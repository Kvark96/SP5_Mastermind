/*
    Written by Oliver Juul Reder on 07.12.20
*/

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> selectedColors;

    public Player() {
        selectedColors = new ArrayList<>();
    }

    public void select(int col) {
        selectedColors.add(col);
    }

    public Guess guess() {
        ArrayList<Integer> cols = selectedColors;
        selectedColors = new ArrayList<>();
        return new Guess(cols);
    }

    public void mousePressed(int x, int y) {
        if(selectedColors.size() < 4){
            for (int i = 0; i < 6; i++) {
                int minX = (50 + i * 50) - (25 / 2);
                int maxX = (50 + i * 50) + (25 / 2);
                int minY = 550 - (25 / 2);
                int maxY = 550 + (25 / 2);

                if (x > minX && x < maxX && y > minY && y < maxY) {
                    select(Main.colors[i]);
                    Main.currentGuess.add(i);
                }
            }
        }


        if (x < 385 && x > 335 && y < 585 && y > 535 && selectedColors.size() == 4) {
            Main.currentGuess = new ArrayList<>();
            UI.addGuess(guess());
        }


        /*
        for(int i = 0; i < currentGuess.size(); i++){
            fill(colors[currentGuess.get(i)]);
            circle(25 + (i + 1) * 50, height - 90, 20);
        }*/

            for(int i = 0; i < selectedColors.size(); i++){
                int minX = (25 + (i + 1) * 50) - (20 / 2);
                int maxX = (25 + (i + 1) * 50) + (20 / 2);
                int minY = 510 - (20 / 2);
                int maxY = 510 + (20 / 2);

                if (x > minX && x < maxX && y > minY && y < maxY) {
                    selectedColors.remove(i);
                    Main.currentGuess.remove(i);
                }
            }

    }

}
