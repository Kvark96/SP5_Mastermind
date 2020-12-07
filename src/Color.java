public class Color {
    int color;
    boolean isHidden;
    int position; // 0 .. 3

    public Color(int color, boolean isHidden, int position) {
        this.color = color;
        this.isHidden = isHidden;
        this.position = position;
    }
}
