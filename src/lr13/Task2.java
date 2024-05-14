package lr13;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task2 {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер столбца от 1 до " + matrix[0].length);

        try {
            int column = in.nextInt();
            assert column <= matrix[0].length;
            int[] res = Arrays.stream(matrix).mapToInt(ints -> ints[column-1]).toArray();
            System.out.println(Arrays.toString(res));
        } catch (InputMismatchException e) {
            System.out.println("Введено некорректное значение");
        } catch (AssertionError e) {
            System.out.println("Введено число больше размера матрицы");
        }
    }
}
