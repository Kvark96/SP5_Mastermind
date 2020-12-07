import processing.core.PApplet;

public class Main extends PApplet{

    public void setup(){
        Player player = new Player();
        player.select(new Color(255, false, 1));
        player.select(new Color(200, false, 2));
        player.select(new Color(150, false, 3));
        player.select(new Color(100, false, 4));

        Guess g = player.guess();
        System.out.println("Guess ID = " + g.getId());
        System.out.println("Guess colors = " + g.getColors().toString());
    }

    public void draw(){

    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
