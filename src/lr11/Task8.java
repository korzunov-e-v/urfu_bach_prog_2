package lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        System.out.println("Введите число, не меньше которого должны быть числа в массиве");
        int minVal = in.nextInt();

        List<Integer> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(200));
        }

        System.out.println("Списк list : ");
        System.out.println(list);

        List<Integer> result = getAbove(list, minVal);

        System.out.println("Список result : ");
        System.out.println(result);
    }

    public static List<Integer> getAbove(List<Integer> list, int minVal) {
        return list.stream().filter(i -> i > minVal).collect(Collectors.toList());
    }
}
