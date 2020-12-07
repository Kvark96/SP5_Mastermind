public class Guess {
    int id;
    Color[] colors;
    int[] checkArr;

    public Guess(int id, Color[] colors) {
        this.id = id;
        this.colors = colors;
    }

    public int[] compare(Guess guess){
        return guess.checkArr;
    }

    public void display(){
    }
}
