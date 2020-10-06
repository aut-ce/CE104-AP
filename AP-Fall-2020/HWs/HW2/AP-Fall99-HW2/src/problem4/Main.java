package problem4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Shape shape;

        String[] entry = input.nextLine().split(" ");
        switch (Integer.parseInt(entry[0])){
            case 0:
                shape = new Shape(Shape.Type.SQUARE);
                break;
            case 1:
                shape = new Shape(Shape.Type.RECTANGLE);
                break;
            case 2:
                shape = new Shape(Shape.Type.TRIANGLE);
                break;
            case 3:
                shape = new Shape(Shape.Type.CROSS);
                break;
            default:
                return;
        }

        shape.Draw(Arrays.copyOfRange(entry, 1, entry.length));
    }
}
