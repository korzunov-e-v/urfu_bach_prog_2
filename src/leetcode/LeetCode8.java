package leetcode;

// https://leetcode.com/problems/fibonacci-number/description/

public class LeetCode8 {

    public static void main(String[] args) {
        assert fib(2) == 1;
        assert fib(3) == 2;
        assert fib(4) == 3;
        assert fib(30) == 832040;

    }

    public static int fib(int n) {
        int f0 = 0;
        int f1 = 1;

        int result = 0;
        for (int i = 0; i <= n; i++) {
            result = f0;
            f0 = f1;
            f1 = result + f0;
        }
        return result;
    }

}
