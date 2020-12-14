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
        System.out.println("Mouse pressed");
        if (selectedColors.size() >= 4) {
            System.out.println("You can't have that many colors");
        } else {
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

        // circle(width - 40, height - 40, 50);


        /*
        * for(int i = 0; i < colors.length; i++){
            fill(colors[i]);
            circle(50 + i * 50, height - 50, 25);
        }*/
    }

    public void mouseReleased(int x, int y) {
        System.out.println("Mouse released");
    }
}
