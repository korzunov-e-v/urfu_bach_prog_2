package leetcode;

// https://leetcode.com/problems/power-of-two/description/

public class LeetCode4 {

    public static void main(String[] args) {
        assert !isPowerOfTwo(0);
        assert isPowerOfTwo(1);
        assert isPowerOfTwo(2);
        assert !isPowerOfTwo(3);
        assert isPowerOfTwo(4);
        assert !isPowerOfTwo(5);
        assert isPowerOfTwo(8);
        assert isPowerOfTwo(1024);
        assert !isPowerOfTwo(2147483647);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 != 0) {
            return false;
        } else {
            return isPowerOfTwo(n / 2);
        }
    }

}
