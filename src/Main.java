import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet{

    int[] colors;
    int scale;
    Player player;
    UI ui = new UI();

    public void settings(){
        size(400, 600);
    }

    public void setup(){
        player = new Player();

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

        Player player = new Player();
        player.select(new Color(0, 1));
        player.select(new Color(1, 2));
        player.select(new Color(2, 3));
        player.select(new Color(3, 4));

        for(int i = 0; i < 10; i++){
            ui.addGuess(player.guess());
        }

        AI ai = new AI(colors);
        Guess solution = ai.createSolutions();
        ui.grid.get(0).compare(solution);

        //System.out.println("Guess ID = " + g.getId());
        //System.out.println("Guess colors = " + g.getColors().toString());
    }

    public void draw(){
        background(50);

        ui.draw();
        displayBG();
        displayButtons();
        for(int i = 0; i < ui.grid.size(); i++){
            displayGuesses(ui.grid.get(i), i);
        }
    }

    public void displayBG(){
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

    public void displayGuesses(Guess guess, int pos){
        // Box = rect(25, 25, width - 100, height - 100);
        noFill();
        strokeWeight(2);
        stroke(130);
        int h = 50;
        rect( 25, 25 + (h * pos), width - 100, h );

        for(Color c : guess.getColors()){
            fill(colors[c.color]);
            noStroke();
            circle(c.position * 70, 50 + pos * h, 25);
        }

        for(int i = 0; i < guess.getCheckArr().length; i++){
            switch (guess.getCheckArr()[i]) {
            // Right color, right pos
                case 0 -> fill(0, 255, 0);
            // Right color, wrong pos
                case 1 -> fill(0, 0, 255);
            // All wrong
                case 2 -> fill(255, 0, 0);
            }
            // rect(width - 75, 25, 50,height-100);
            if(i < 2){
                rect(width - 70 + i * 22, 30, 20, 20);
            } else {
                rect(width - 114 + i * 22, 52, 20, 20);
            }
        }
    }

    @Override
    public void mousePressed() {
        super.mousePressed();
        player.mousePressed();
    }

    @Override
    public void mouseReleased() {
        super.mouseReleased();
        player.mouseReleased();
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
