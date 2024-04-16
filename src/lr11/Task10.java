package lr11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        System.out.println("Введите число, меньше которого должны быть числа в итоговом массиве");
        int maxVal = in.nextInt();

        List<Integer> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(200));
        }

        System.out.println("Списк list : ");
        System.out.println(list);

        List<Integer> result = getBelong(list, maxVal);

        System.out.println("Список result : ");
        System.out.println(result);
    }

    public static List<Integer> getBelong(List<Integer> list, int maxValue) {
        return list.stream().filter(x -> x < maxValue).collect(Collectors.toList());
    }
}
