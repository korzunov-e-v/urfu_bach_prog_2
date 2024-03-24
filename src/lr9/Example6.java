package lr9;

public class Example6 {
    public static void main(String[] args) {
        System.out.println("Method 1");
        method_1();
        System.out.println("Method 2");
        method_2();
    }

    public static void method_1() {
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node ref = node0;

        while (ref != null) {
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
    }

    public static void method_2() {
        Node head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }

        Node ref = head;
        while (ref != null) {
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
    }

    private static class Node {
        public int value;
        public Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
