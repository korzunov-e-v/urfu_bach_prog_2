package lr9;

public class Example5 {
    public static void main(String[] args) {
        fact(5);
    }

    public static int fact(int n) {
        System.out.println("called fact(" + n + ")");
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fact(n - 2) + fact(n - 1);
        }
    }
}
