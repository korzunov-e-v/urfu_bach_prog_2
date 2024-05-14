package lr13;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Введите размер массивва: ");
        int[] array = new int[in.nextInt()];
        in.nextLine();

        for (int i = 0; i < array.length; i++) {
            String input = in.nextLine();
            try {
                if (input.contains(".") | input.contains(",")) {
                    throw new Exception();
                }
                int num = Integer.parseInt(input);
                array[i] = num;
                assert num > 0;
            } catch (NumberFormatException e) {
                System.out.println("Введена строка");
            } catch (AssertionError e) {
                System.out.println("Число не положительное");
            } catch (Exception e) {
                System.out.println("Некорректный формат числа");
            }
        }
        System.out.println(Arrays.toString(array));
        OptionalDouble avg = Arrays.stream(array).average();
        if (avg.isPresent()) {
            System.out.println(avg.getAsDouble());
        }

    }

}
