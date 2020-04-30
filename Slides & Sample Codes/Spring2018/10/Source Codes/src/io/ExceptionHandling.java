package io;

import java.util.Scanner;

public class ExceptionHandling {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2, quotient;
        do {
            try {
                System.out.print("\nEnter first number: ");
                num1 = Integer.parseInt(input.next());
                System.out.print("Enter second number: ");
                num2 = Integer.parseInt(input.next());
                quotient = num1 / num2;
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Wrong input! Please enter a number.");
            } catch (ArithmeticException ex) {
                System.out.println("Wrong input! Second number cannot be zero.");
            }
        } while (true);
        System.out.println("The sum is = " + (num1 + num2));
        System.out.printf("The quotient is = %d\n", quotient);

        method1(7);
    }

    public static void method1(int i) {
        method2(i);
    }

    public static void method2(int i)  {
        try {
            method3(i);
        } catch (OddNumberException ex) {
            System.out.println("ODD NUMBER EXCEPTION");
            for (StackTraceElement elem: ex.getStackTrace()) {
                System.out.println("--------");
                System.out.println(elem.getFileName());
                System.out.println(elem.getClassName());
                System.out.println(elem.getMethodName());
                System.out.println(elem.getLineNumber());
            }
        } catch (Exception ex) {
            System.out.println("EXCEPTION");
        }
    }

    /**
     * @throws OddNumberException if i is odd, then such an exception is thrown
     */
    public static void method3(int i) throws Exception {
        if (i % 2 != 0) {
            Exception ex = new OddNumberException("\n" + i + " is odd :(");
            throw ex; //new OddNumberException("\n" + i + " is odd :(");
        }
        else
            System.out.println("\n" + i + " is even :)");
    }
}


class OddNumberException extends RuntimeException {

    public OddNumberException(String msg) {
        super(msg);
    }
}
