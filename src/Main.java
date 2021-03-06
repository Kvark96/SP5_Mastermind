import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet{

    static int[] colors;
    int scale;
    Player player;
    static Guess solution;
    static ArrayList<Integer> currentGuess;
    boolean finished = false;
    static ArrayList<Guess> previousGuesses = new ArrayList<>();

    public void settings(){
        size(400, 600);
    }

    public void setup(){
        player = new Player();
        currentGuess = new ArrayList<>();
        scale = 20;

        // RED=0, GREEN=1, BLUE=2, YELLOW=3, MAGENTA=4, LIGHTBLUE=5
        colors = new int[]{
                color(255, 0, 0),
                color(0, 255, 0),
                color(0, 0, 255),
                color(255, 255, 0),
                color(255, 0, 255),
                color(0, 255, 255)
        };

        AI ai = new AI(colors);
        solution = ai.createSolution();
        }

    public void draw(){
        if(!finished){
            displayBG();
            displayButtons();
            for (Guess g : Main.previousGuesses) g.compare(solution);
            displayCurrentGuess();
            for (int i = 0; i < Main.previousGuesses.size(); i++) {
                displayGuess(Main.previousGuesses.get(i), i);
                if(i > 8) {
                    finished = true;
                    System.out.println("You are out of guesses.\nGame over.");
                }else if(Main.previousGuesses.get(i).getColors().equals(solution.getColors())){
                    finished = true;
                    System.out.println("That is correct!\nYou Win!");
                }
            }

        }
    }

    public void displayBG(){
        background(50);
        noFill();
        stroke(130);
        strokeWeight(3);
        // Big box
        rect(25, 25, width - 100, height - 100);
        // Bottom box
        rect(25, height - 75, width - 100, 50);
        // Right box
        rect(width - 75, 25, 50,height-100);
        noStroke();
        fill(255);
        circle(width - 40, height - 40, 50);
    }

    public void displayButtons(){
        for(int i = 0; i < colors.length; i++){
            fill(colors[i]);
            circle(50 + i * 50, height - 50, 25);
        }
    }

    public void displayGuess(Guess guess, int pos){
        noFill();
        strokeWeight(2);
        stroke(130);
        int h = 50 * pos;
        rect( 25, 25 + h, width - 100, 50 );

        for(int i = 0; i < guess.getColors().size(); i++){
            fill(guess.getColors().get(i));
            noStroke();
            circle((i + 1) * 70, 50 + h, 25);
        }

        noFill();
        for(int i = 0; i < guess.getCheckArr().length; i++){
            switch (guess.getCheckArr()[i]) {
            // Right color, right pos
                case 2 -> fill(0, 255, 0);
            // Right color, wrong pos
                case 1 -> fill(0, 0, 255);
            // All wrong
                case 0 -> fill(255, 0, 0);
            }

            if(i < 2){
                rect(width - 70 + i * 22, h + 30, 20, 20);
            } else {
                rect(width - 114 + i * 22, h + 52, 20, 20);
            }
        }
    }

    public void displayCurrentGuess(){
        noFill();
        strokeWeight(2);
        stroke(130);
        rect(25, height - 105, width - 100, 30);
        noStroke();
        for(int i = 0; i < currentGuess.size(); i++){
            fill(colors[currentGuess.get(i)]);
            circle(25 + (i + 1) * 50, height - 90, 20);
        }
    }

    @Override
    public void mousePressed() {
        super.mousePressed();
        player.mousePressed(mouseX, mouseY);
    }


    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}