package lr9;

public class Example2 {
    public static void main(String[] args) {
        m(1);
    }

    public static void m(int x) {
        if ((2 * x + 1) < 20) {
            m(2 * x + 1);
        }
        System.out.println("x=" + x);
    }
}
