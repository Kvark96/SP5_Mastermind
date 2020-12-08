import processing.core.PApplet;

public class Main extends PApplet{

    int[] colors;
    public void settings(){
        size(400, 400);

        // RED=0, GREEN=1, BLUE=2, YELLOW=3, MAGENTA=4, LIGHTBLUE=5
        colors = new int[]{
                color(255, 0, 0),
                color(0, 255, 0),
                color(0, 0, 255),
                color(255, 255, 0),
                color(255, 0, 255),
                color(0, 255, 255)
        };
    }

    public void setup(){
        Player player = new Player();
        player.select(new Color(colors[0], false, 0));
        player.select(new Color(colors[1], false, 1));
        player.select(new Color(colors[4], false, 2));
        player.select(new Color(colors[5], false, 3));

        UI.addGuess(player.guess());
        UI.addGuess(player.guess());
        UI.addGuess(player.guess());
        UI.addGuess(player.guess());
        System.out.println(UI.grid.size());

        UI.setSize(width / 10);
    }

    public void draw(){
        background(0);
        translate(UI.size, UI.size);
        for(int i = 0; i < UI.grid.size(); i++){
            for(Color c : UI.grid.get(i).getColors()){
                fill(c.color);
                circle(c.position * UI.size, i * UI.size, UI.size);
            }
        }

    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
