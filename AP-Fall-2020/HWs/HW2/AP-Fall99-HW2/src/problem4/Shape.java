package problem4;

public class Shape {
    public enum Type {
        SQUARE,
        RECTANGLE,
        TRIANGLE,
        CROSS
    }

    private Type type;

    public Shape(Type type) {
        this.type = type;
    }

    public void Draw(String[] args) {
        switch (this.type) {
            case SQUARE:
                drawSquare(Integer.parseInt(args[0]));
                break;
            case RECTANGLE:
                drawRectangle(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                break;
            case TRIANGLE:
                drawTriangle(Integer.parseInt(args[0]));
                break;
            case CROSS:
                drawCross(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
                break;
        }
    }

    private void drawSquare(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    private void drawRectangle(int length, int width) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    private void drawTriangle(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    private void drawCross(int length, int width) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (i == length / 2 || j == width / 2)
                    System.out.print("*\t");
                else
                    System.out.print(" \t");
            }
            System.out.println();
        }
    }
}
