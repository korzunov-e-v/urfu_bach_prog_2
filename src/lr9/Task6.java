package lr9;

import java.util.ArrayList;
import java.util.HashMap;

public class Task6 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0, "aaaaa");
        hashMap.put(1, "bbbbbb");
        hashMap.put(2, "ccc");
        hashMap.put(3, "dd");
        hashMap.put(4, "eeeeeee");
        hashMap.put(5, "ffff");
        hashMap.put(6, "ggg");
        hashMap.put(7, "hhhhhh");
        hashMap.put(8, "iii");
        hashMap.put(9, "jjjj");

        int valuesLenAboveFiveMultRes = 1;
        ArrayList<String> whereKeysAboveFive = new ArrayList<>();
        for (Integer key : hashMap.keySet()) {
            String val = hashMap.get(key);
            if (key > 5) {
                whereKeysAboveFive.add(val);
            }
            if (key == 0) {
                System.out.println(hashMap.values());
            }
            if (val.length() > 5) {
                valuesLenAboveFiveMultRes *= key;
            }
        }
        System.out.println("Строки, у которых ключ>5: " + whereKeysAboveFive);
        System.out.println("Перемножение всех ключей, где длина строки>5: " + valuesLenAboveFiveMultRes);
    }
}
