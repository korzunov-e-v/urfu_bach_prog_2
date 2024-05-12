package leetcode;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

// https://leetcode.com/problems/power-of-four/description/

public class LeetCode7 {

    public static void main(String[] args) {
        assert isPowerOfFour(4);
        assert isPowerOfFour(16);
        assert isPowerOfFour(64);
        assert !isPowerOfFour(65);
        assert isPowerOfFour(1073741824);
        assert !isPowerOfFour(1073741825);
        assert !isPowerOfFour(2147483647);
    }

    public static boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }

        DecimalFormat df = new DecimalFormat("#.############");
        df.setRoundingMode(RoundingMode.CEILING);
        df.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
        double result = (Math.log(n) / Math.log(4));
        result = Double.parseDouble(df.format(result));
        return result % 1 == 0;
    }

}
