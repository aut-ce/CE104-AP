package problem5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String num = input.nextLine();
        System.out.println(atoi(num));

    }

    public static int atoi(String num) {
        int result = 0;
        Byte sign = 0;

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == ' ' && (result != 0 || sign != 0))
                return applySign(sign, result);

            if (num.charAt(i) == '+') {
                if (sign == 0 && result == 0) {
                    sign = 1;
                    continue;
                } else
                    return applySign(sign, result);
            }

            if (num.charAt(i) == '-') {
                if (sign == 0 && result == 0) {
                    sign = -1;
                    continue;
                } else
                    return applySign(sign, result);
            }

            switch (num.charAt(i)) {
                case '0':
                    result = result * 10;
                    break;
                case '1':
                    result = result * 10 + 1;
                    break;
                case '2':
                    result = result * 10 + 2;
                    break;
                case '3':
                    result = result * 10 + 3;
                    break;
                case '4':
                    result = result * 10 + 4;
                    break;
                case '5':
                    result = result * 10 + 5;
                    break;
                case '6':
                    result = result * 10 + 6;
                    break;
                case '7':
                    result = result * 10 + 7;
                    break;
                case '8':
                    result = result * 10 + 8;
                    break;
                case '9':
                    result = result * 10 + 9;
                    break;
                case ' ':
                    break;
                default:
                    return applySign(sign, result);
            }
        }

        return applySign(sign, result);
    }

    private static int applySign(Byte sign, int num) {
        if (sign == 0)
            return num;

        return sign * num;
    }
}
