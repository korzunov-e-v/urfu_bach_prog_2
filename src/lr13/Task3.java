package lr13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массива типа 'byte':");
        int size = in.nextInt();
        in.nextLine();

        byte[] vals = new byte[size];

        for (int i = 0; i < vals.length; i++) {
            String input = in.nextLine();
            try {
                int inputInt = Integer.parseInt(input);
                vals[i] = Byte.parseByte(input);
                if (inputInt < -128 | inputInt > 127) {
                    throw new Exception();
                }
            } catch (NumberFormatException e) {
                System.out.println("Введено некорректное значение.");
                System.exit(1);
            } catch (Exception e) {
                System.out.println("Введено число вне диапазона.");
                System.exit(1);
            }
        }
        int res = IntStream.range(0, vals.length).map(j -> vals[j]).sum();
        try {
            if (res < -128 | res > 127) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Результат вне диапазона.");
            System.exit(1);
        }
        System.out.println(res);
    }
}
