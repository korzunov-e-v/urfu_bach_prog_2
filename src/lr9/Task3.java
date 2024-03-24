package lr9;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Integer[] result = getArray();
        System.out.println(Arrays.toString(result));
    }

    public static Integer[] getArray() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        if (Objects.equals(input, "stop")) {
            return new Integer[]{};
        } else {
            int input_int = Integer.parseInt(input);
            List<Integer> mem = new ArrayList<>(List.of(input_int));
            mem.addAll(Arrays.asList(getArray()));
            System.out.println("mem=" + mem);
            Integer[] result = new Integer[mem.size()];
            for (int i = 0; i < mem.size(); i++) {
                result[i] = mem.get(i);
            }
            return result;
        }
    }
}
