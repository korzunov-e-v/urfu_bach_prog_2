package lr11;

import java.util.*;
import java.util.stream.Collectors;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        System.out.println("Введите число, на которое должны делиться числа в массиве");
        int divBy = in.nextInt();

        List<Integer> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(200));
        }

        System.out.println("Списк list : ");
        System.out.println(list);

        List<Integer> result = getDividedBy(list, divBy);

        System.out.println("Список result : ");
        System.out.println(result);
    }

    public static List<Integer> getDividedBy(List<Integer> list, int divBy) {
        return list.stream().filter(x -> x % divBy == 0).collect(Collectors.toList());
    }
}
