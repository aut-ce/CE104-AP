package problem6;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String myStr = input.nextLine();

        // We have implemented this problem in 3 different ways. you can uncomment each one you want and run it :D

        //printDuplicatesUsingAsciiTable(myStr);
        //printDuplicatesUsingSort(myStr);
        printDuplicates(myStr);
    }


    public static void printDuplicatesUsingAsciiTable(String myStr) {
        int[] count = new int[128];

        for (int i = 0; i < myStr.length(); i++) {
            int index = myStr.charAt(i);
            count[index]++;
        }

        for (int i = 0; i < myStr.length(); i++) {
            int index = myStr.charAt(i);
            if (count[index] > 1) {
                System.out.println((char) index);
                count[index] = 0;
            }
        }
    }


    public static void printDuplicatesUsingSort(String myStr) {
        ArrayList<Character> duplicates = new ArrayList<>();
        char[] chars = myStr.toCharArray();
        Arrays.sort(chars);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] && (i == chars.length - 1 || chars[i] != chars[i + 1]))
                duplicates.add(chars[i]);
        }

        for (int i = 0; i < myStr.length(); i++) {
            if (duplicates.contains(myStr.charAt(i))) {
                System.out.println(myStr.charAt(i));
                duplicates.remove((Character)myStr.charAt(i));
            }
        }
    }

    public static void printDuplicates(String myStr) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();

        for (int i = 1; i < myStr.length(); i++) {
            if (count.containsKey(myStr.charAt(i)))
                count.put(myStr.charAt(i), count.get(myStr.charAt(i)) + 1);
            else
                count.put(myStr.charAt(i), 1);
        }

        for (int i = 1; i < myStr.length(); i++) {
            if (count.get(myStr.charAt(i)) > 1) {
                System.out.println(myStr.charAt(i));
                count.put(myStr.charAt(i), 1);
            }
        }
    }
}
