package lr9;

import java.util.ArrayList;

public class Task7 {
    public static void main(String[] args) {
        int n = 100000;
        int result;
        long startTime;
        long finishTime;
        ArrayList<Integer> arrayList;
        Node linkedListHead;

        System.out.println("n = " + n);

        // ArrayList, первый способ
        System.out.println("getArrayWinnerSlow");
        startTime = System.currentTimeMillis();
        arrayList = getFilledArrayList(n);
        result = getArrayWinnerSlow(arrayList);
        finishTime = System.currentTimeMillis();
        System.out.println("Победил - " + result);
        System.out.println("getArrayWinnerSlow: " + (finishTime - startTime) + " ms\n\n");

        // ArrayList, второй способ
        System.out.println("getArrayWinnerFast");
        startTime = System.currentTimeMillis();
        arrayList = getFilledArrayList(n);
        result = getArrayWinnerFast(arrayList);
        finishTime = System.currentTimeMillis();
        System.out.println("Победил - " + result);
        System.out.println("getArrayWinnerFast: " + (finishTime - startTime) + " ms\n\n");

        // linkedList
        System.out.println("getLinkedListWinner");
        startTime = System.currentTimeMillis();
        linkedListHead = getFilledLinkedList(n);
        result = getLinkedListWinner(linkedListHead);
        finishTime = System.currentTimeMillis();
        System.out.println("Победил - " + result);
        System.out.println("getLinkedListWinner: " + (finishTime - startTime) + " ms\n\n");
    }

    // через метод remove
    public static Integer getArrayWinnerSlow(ArrayList<Integer> arrayList) {
        int size = arrayList.size();
        int s = 0;
        int i = 0;
        while (size != 1) {
            // System.out.println(arrayList);
            if (i >= arrayList.size()) {
                i -= arrayList.size();
            }
            s += 1;
            if (s == 2) {
                arrayList.remove(i);
                size -= 1;
                s = 1;
            }
            i += 1;
        }
        return arrayList.get(0);
    }

    // через метод get
    public static Integer getArrayWinnerFast(ArrayList<Integer> arrayList) {
        int i = 0;
        int s = 0;
        int num = arrayList.size();
        Integer candidate = -1;
        Integer winner = null;
        while (num != 1) {
            if (i >= arrayList.size()) {
                i -= arrayList.size();
            }
            if (candidate != -1) {
                winner = candidate;
            }
            candidate = arrayList.get(i);
            if (candidate != -1) {
                s += 1;
                if (s == 2) {
                    arrayList.set(i, -1);
                    num -= 1;
                    s = 0;
                }
            }
            i += 1;
            // System.out.println(arrayList);
        }
        return winner;
    }

    public static Integer getLinkedListWinner(Node head) {
        Node prev = head;
        Node curr = head;
        int s = 0;
        while (curr.next != curr) {
            s += 1;
            if (s == 2) {
                prev.next = curr.next;
                s = 0;
            }
            prev = curr;
            curr = curr.next;
        }
        return curr.value;
    }

    // метод создания заполненного ArrayList
    public static ArrayList<Integer> getFilledArrayList(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    // метод создания заполненного циклического LinkedList
    public static Node getFilledLinkedList(int n) {
        Node first = new Node(0, null);
        Node head = new Node(n - 1, first);
        for (int i = n - 2; i > 0; i--) {
            head = new Node(i, head);
        }
        first.next = head;
        return first;
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
