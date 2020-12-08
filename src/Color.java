public class Color{
    int color;
    boolean isHidden;
    int position; // 0 .. 3

    public Color(int color, int position) {
        this.color = color;
        this.position = position;
    }

    @Override
    public String toString() {
        return "{"+ color +
                ", " + isHidden +
                ", " + position + "}";
    }
}
