package lr9;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String res = getBinary(x);
        System.out.println(x + " (dec) = " + res + " (bin)");
    }

    public static String getBinary(int x) {
        System.out.println("called getBinary(" + x + ")");
        if (x == 1) {
            return "1";
        } else if (x == 0) {
            return "0";
        } else {
            return getBinary(x / 2) + getBinary(x % 2);
        }
    }
}
