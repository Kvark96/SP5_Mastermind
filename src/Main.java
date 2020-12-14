import processing.core.PApplet;

public class Main extends PApplet{

    static int[] colors;
    int scale;
    Player player;
    UI ui = new UI();
    static Guess solution;

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
        /*
        player.select(colors[0]);
        player.select(colors[1]);
        player.select(colors[0]);
        player.select(colors[3]);

        for(int i = 0; i < 10; i++){
            ui.addGuess(player.guess());
        }
        */
        AI ai = new AI(colors);
        solution = ai.createSolutions();
        //System.out.println("Guess ID = " + g.getId());
        //System.out.println("Guess colors = " + g.getColors().toString());
    }

    public void draw(){
        background(50);

        displayBG();
        displayButtons();
        for(Guess g : UI.grid) g.compare(solution);
        for(int i = 0; i < ui.grid.size(); i++) {
            displayGuess(ui.grid.get(i), i);
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

    public void displayGuess(Guess guess, int pos){
        // Box = rect(25, 25, width - 100, height - 100);

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
                case 0 -> fill(0, 255, 0);
            // Right color, wrong pos
                case 1 -> fill(0, 0, 255);
            // All wrong
                case 2 -> fill(255, 0, 0);
            }
            // rect(width - 75, 25, 50,height-100);

            if(i < 2){
                rect(width - 70 + i * 22, h + 30, 20, 20);
            } else {
                rect(width - 114 + i * 22, h + 52, 20, 20);
            }
        }
    }

    @Override
    public void mousePressed() {
        super.mousePressed();
        player.mousePressed(mouseX, mouseY);
    }

    @Override
    public void mouseReleased() {
        super.mouseReleased();
        player.mouseReleased(mouseX, mouseY);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
