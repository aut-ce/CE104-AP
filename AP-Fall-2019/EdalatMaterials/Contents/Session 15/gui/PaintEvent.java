
import java.awt.Color;

public class PaintEvent {

    public final int X, Y;
    public final int STROKE;
    public final Color COLOR;

    public PaintEvent(int x, int y, int stroke, Color color) {
        X = x;
        Y = y;
        COLOR = color;
        STROKE = stroke;
    }

}

