package problem4;

import java.util.Scanner;

public class Main {
    //this problem might be so easy but its so important as it was one of snapp interview questions with one
    // condition/constraint : assume print costs a lot so use minimum print instructions
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String result = "";
        int num = input.nextInt();
        if (num % 3 == 0)
            result += "Pthree";
        if (num % 5 == 0)
            result += "Pfive";
        if (num % 7 == 0)
            result += "Pseven";

        if (result.length() == 0)
            System.out.println(num);
        else
            System.out.println(result);
    }
}
