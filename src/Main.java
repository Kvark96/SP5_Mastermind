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

        ui.addGuess(player.guess());
        ui.addGuess(player.guess());
        ui.addGuess(player.guess());

        AI ai = new AI(colors);
        Guess solution = ai.createSolutions();
        ui.grid.get(0).compare(solution);

        //System.out.println("Guess ID = " + g.getId());
        //System.out.println("Guess colors = " + g.getColors().toString());
    }

    public void draw(){
        background(50);
        //translate(scale, scale);

        ui.draw();
        displayBG();
        displayButtons();
        displayGuesses();
    }

    public void displayBG(){
        noFill();
        stroke(130);
        strokeWeight(3);
        translate(0,0);
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
        translate(25, height-75);

        for(int i = 0; i < colors.length; i++){
            fill(colors[i]);
            circle(25 + i * 50, 25, 25);
        }
    }

    public void displayGuesses(){
        translate(0 ,-(height-100));
        for(int i = 0; i < ui.grid.size(); i++){
            noFill();
            stroke(130);
            strokeWeight(2);
            rect(5, 5 + i * 60, width - 110, 50);

            for(Color c : ui.grid.get(i).getColors()){
                fill(colors[c.color]);
                noStroke();
                circle(c.position * 60, 30 + i * 60, 25);
            }
            for(int j : ui.grid.get(i).getCheckArr()){
                if(j == 0){
                    // rect(width - 75, 25, 50,height-100);
                    fill(255, 0, 0);

                } else if(j == 1){
                    // rect(width - 75, 25, 50,height-100);
                } else {
                    // rect(width - 75, 25, 50,height-100);
                }

                int w = 50;
                noFill();
                int rectX = width - 75 - w/2;
                int rectY = height - 100 - w/2;
                rect(rectX, rectY, w, w);

                for(int x = 1; x < 3; x++){
                    for(int y = 1; y < 3; y++){
                        int size = (w / 3) / 2;
                        circle(rectX + (w / 3) * x, rectY + (w / 3) * y, size);
                    }
                }

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
