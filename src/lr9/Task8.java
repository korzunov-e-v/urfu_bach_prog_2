package lr9;

import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        System.out.println("LinkedList циклом");
//        Integer[] my_ints = new Integer[] {1,2,3,4,5};
//        MyLoopLinkedList loopLinkedList = new MyLoopLinkedList(List.of(my_ints));
        MyLoopLinkedList loopLinkedList = new MyLoopLinkedList();
        loopLinkedList.createHead();
//        loopLinkedList.createTail();
        System.out.println(loopLinkedList);
        loopLinkedList.AddFirst(100);
        System.out.println(loopLinkedList);
        loopLinkedList.AddLast(101);
        System.out.println(loopLinkedList);
        loopLinkedList.Insert(1, 42);
        System.out.println(loopLinkedList);
        loopLinkedList.RemoveLast();
        System.out.println(loopLinkedList);
        loopLinkedList.Remove(3);
        System.out.println(loopLinkedList);

        System.out.println("\n");
        System.out.println("LinkedList рекурсией");
        MyRecursionLinkedList recursionLinkedList = new MyRecursionLinkedList();
//        recursionLinkedList.createHeadRec();
        recursionLinkedList.createTailRec();
        System.out.println(recursionLinkedList);
    }

    // с использованием цикла
    private static class MyLoopLinkedList {
        private int size = 0;
        private Node head = null;
        private Node tail = null;

        public MyLoopLinkedList() {
        }

        public MyLoopLinkedList(Iterable<Integer> coll) {
            for (int item : coll) {
                this.AddLast(item);
            }
        }

        public void createHead() {
            System.out.println("Вводите числа, начиная с головы состава, после введите 'stop'");
            Scanner in = new Scanner(System.in);
            String input;
            int inputInt;
            Node new_node;
            while (true) {
                input = in.nextLine();
                if (input.equals("stop")) {
                    break;
                }
                try {
                    inputInt = Integer.parseInt(input);
                    new_node = new Node(inputInt, null);
                    size += 1;
                    if (this.size == 1) {
                        this.head = new_node;
                    } else {
                        this.tail.next = new_node;
                    }
                    this.tail = new_node;
                } catch (NumberFormatException nfe) {
                    System.out.println("Это не stop и не число.");
                }
            }
        }

        public void createTail() {
            System.out.println("Вводите числа, начиная с хвоста состава, после введите 'stop'");
            Scanner in = new Scanner(System.in);
            String input;
            int inputInt;
            while (true) {
                input = in.nextLine();
                if (input.equals("stop")) {
                    break;
                }
                try {
                    inputInt = Integer.parseInt(input);
                    this.head = new Node(inputInt, this.head);
                    size += 1;
                    if (this.size == 1) {
                        this.tail = this.head;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Это не stop и не число.");
                }
            }
        }

        public String toString() {
            StringBuilder repr = new StringBuilder();
            Node curr = this.head;
            repr.append("[");
            while (curr != null) {
                repr.append(curr.value);
                if (curr.next != null) {
                    repr.append(", ");
                }
                curr = curr.next;
            }
            repr.append("]");
            return repr.toString();
        }

        public void AddFirst(int num) {
            if (this.size == 0) {
                this.head = new Node(num, null);
                this.tail = this.head;
                this.size = 1;
                return;
            }
            this.head = new Node(num, this.head);
            this.size += 1;
        }

        public void AddLast(int num) {
            if (this.size == 0) {
                this.head = new Node(num, null);
                this.tail = this.head;
                this.size = 1;
                return;
            }
            this.tail.next = new Node(num, null);
            this.tail = this.tail.next;
            this.size += 1;
        }

        public void Insert(int index, int num) {
            Node prev = null;
            Node curr = null;
            assert index <= this.size : "index must be less or equal then list size";
            Node newNode = new Node(num, null);
            for (int i = 0; i < index + 1; i++) {
                if (i == 0) {
                    curr = this.head;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            if (prev == null) {
                this.head = new Node(num, this.head);
            } else {
                newNode.next = curr;
                prev.next = newNode;
                this.size += 1;
            }
        }

        public void RemoveFirst() {
            this.head = this.head.next;
            this.size -= 1;
        }

        public void RemoveLast() {
            Node preLast = null;
            Node last = this.head;

            if (this.size == 1) {
                this.head = null;
                this.size = 0;
                return;
            }

            while (last.next != null) {
                preLast = last;
                last = last.next;
            }
            assert preLast != null;
            preLast.next = null;
            this.size -= 1;
        }

        public void Remove(int index) {
            Node prev = null;
            Node curr = null;
            assert index <= this.size : "index must be less or equal then list size";

            if (index == 0) {
                this.head = this.head.next;
                this.size -= 1;
                return;
            }

            for (int i = 0; i <= index; i++) {
                if (i == 0) {
                    curr = this.head;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            assert curr != null;
            assert prev != null;
            prev.next = curr.next;
            this.size -= 1;
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

    private static class MyRecursionLinkedList {
        private int size = 0;
        private Node head = null;
        private Node tail = null;

        public MyRecursionLinkedList() {
        }

        public MyRecursionLinkedList(Iterable<Integer> coll) {
            for (int item : coll) {
                this.AddLast(item);
            }
        }

        public void AddLast(int num) {
            if (this.size == 0) {
                this.head = new Node(num, null);
                this.tail = this.head;
                this.size = 1;
                return;
            }
            this.tail.next = new Node(num, null);
            this.tail = this.tail.next;
            this.size += 1;
        }

        public Node createHeadRec() {
            System.out.println("Вводите целые числа, начиная с головы состава, потом 'stop': ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("stop")) {
                return null;
            } else {
                int input_int = Integer.parseInt(input);

                Node curr = new Node(input_int, null);

                if (this.size == 0) {
                    this.head = curr;
                    this.tail = this.head;
                    this.size = 1;
                } else {
                    this.tail.next = curr;
                    this.tail = this.tail.next;
                    this.size += 1;
                }
                this.tail.next = createHeadRec();
                return curr;
            }
        }

        public Node createTailRec() {
            System.out.println("Вводите целые числа, начиная с хвоста состава, потом 'stop': ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.equals("stop")) {
                return this.head;
            } else {
                int input_int = Integer.parseInt(input);
                this.head = new Node(input_int, this.head);
                return createTailRec();
            }
        }

        public String toStringRec(Node curr) {
            if (curr == null) {
                return "";
            }
            String val = toStringRec(curr.next);
            if (val.equals("")) {
                return String.valueOf(curr.value);
            } else {
                return curr.value + ", " + val;
            }
        }

        public String toString() {
            return "[" + toStringRec(this.head) + "]";
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

}
