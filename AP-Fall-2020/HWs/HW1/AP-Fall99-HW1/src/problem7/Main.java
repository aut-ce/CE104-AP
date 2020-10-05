package problem7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str1 = input.nextLine();
        String str2 = input.nextLine();

        if (areAnagrams(str1, str2))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    //There are many ways to sort an array. You should implement one (Merge sort, bubble sort, insertion sort and ...)
    public static boolean areAnagrams(String str1, String str2){
        if (str1.length() != str2.length())
            return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < str1.length(); i++) {
            if (chars1[i] != chars2[i])
                return false;
        }

        return true;
    }
}
