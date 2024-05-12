package leetcode;

// https://leetcode.com/problems/add-binary/description/

public class LeetCode10 {

    public static void main(String[] args) {
        assert addBinary("11", "1").equals("100");
        assert addBinary("0", "1").equals("1");
        assert addBinary("0", "0").equals("0");
        assert addBinary("100", "100").equals("1000");
        assert addBinary("1111", "1").equals("10000");
        assert addBinary("11100001101", "11011110011").equals("111000000000");

        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String res = "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000";
        assert addBinary(a, b).equals(res);
    }

    public static String addBinary(String a, String b) {
        if (a.equals("0") & b.equals("0")) {
            return "0";
        }

        int m = 0;

        StringBuilder sb = new StringBuilder();

        char a1;
        char b1;
        int i = 0;
        while (m == 1 | i < a.length() | i < b.length()) {
            if (i < a.length()) {
                a1 = a.charAt(a.length() - 1 - i);
            } else {
                a1 = '0';
            }
            if (i < b.length()) {
                b1 = b.charAt(b.length() - 1 - i);
            } else {
                b1 = '0';
            }

            if (a1 == '1' & b1 == '1') {
                if (m == 0) {
                    sb.append(0);
                    m = 1;
                } else {
                    sb.append("1");
                }
            } else if (a1 == '0' & b1 == '0') {
                if (m == 0) {
                    sb.append("0");
                } else {
                    sb.append("1");
                    m = 0;
                }
            } else {
                if (m == 0) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            i++;
        }
        if (m == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static String addBinary1(String a, String b) {
        int aBin = Integer.parseInt(a, 2);
        int bBin = Integer.parseInt(b, 2);
        return Integer.toString(aBin + bBin, 2);
    }

}
