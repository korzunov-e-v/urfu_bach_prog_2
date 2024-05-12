package leetcode;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

// https://leetcode.com/problems/power-of-three/description/

public class LeetCode6 {

    public static void main(String[] args) {
        assert !isPowerOfThree(0);
        assert isPowerOfThree(3);
        assert !isPowerOfThree(4);
        assert isPowerOfThree(9);
        assert isPowerOfThree(27);
        assert !isPowerOfThree(10);
        assert !isPowerOfThree(19682);
        assert !isPowerOfThree(2147483647);

    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }

        DecimalFormat df = new DecimalFormat("#.############");
        df.setRoundingMode(RoundingMode.CEILING);
        df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
        double result = (Math.log(n) / Math.log(3));
        result = Double.parseDouble(df.format(result));
        return result % 1 == 0;
    }
}
