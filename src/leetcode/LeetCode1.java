package leetcode;

// https://leetcode.com/problems/powx-n/description/

public class LeetCode1 {

    public static void main(String[] args) {
        assert myPow(2.0, -2) == 0.25;
        assert myPow(6.0, 5) == 7776;
        assert myPow(5.0, 3) == 125;
        assert myPow(2.0, 10) == 1024;

        System.out.println(myPow(0.00001, 2147483647));
    }

    public static Double myPow(Double a, Integer x) {
        assert a != null;
        assert x != null;

        if (x == 0) {
            return 1.0;
        }

        String nBin = Integer.toString(Integer.parseInt(String.valueOf(Math.abs(x)).split("\\.")[0]), 2);

        double[] aiArray = new double[nBin.length()];
        double ai = a;
        for (int i = nBin.length() - 1; i >= 0; i--) {
            aiArray[i] = ai;
            ai = ai * ai;
        }

        int[] powChars = nBin.chars().toArray();
        double result = 1;
        for (int i = 0; i < powChars.length; i++) {
            if ((char) powChars[i] == '1') {
                if (Math.signum(x) == 1) {
                    result *= aiArray[i];
                } else {
                    result *= 1 / aiArray[i];
                }
            }
        }

        return result;
    }
}
