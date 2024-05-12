package lr12;

import java.util.Arrays;

public class Task5 {

    private static final int coreCount = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {

        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int[] results = new int[coreCount];

        for (int i = 0; i < coreCount; i++) {
            int size = (int) Math.ceil((double) array.length / (double) coreCount);

            int start = (size) * i;
            int end = start + size;

            int finalI = i;
            Thread thread = new Thread(() -> {
                int[] chunk = Arrays.stream(array, start, Math.min(end, array.length)).toArray();
                int res = chunk[0];
                for (int k : chunk) {
                    if (k > res) {
                        res = k;
                    }
                }
                results[finalI] = res;
                System.out.println(Arrays.toString(results));
            });
            thread.start();
            thread.join();
        }
        int t = results[0];
        for (int k : results) {
            if (k > t) {
                t = k;
            }
        }
        System.out.println(t);
    }
}
