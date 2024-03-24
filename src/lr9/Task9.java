package lr9;

import java.util.*;

public class Task9 {
    public static void main(String[] args) {
        final double n = 700000;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("Время добаваления в начало коллекции. N=" + n);
        System.out.println("ArrayDeque: " + timeAddFirstDeque(arrayDeque, n) + " ms.");
        System.out.println("ArrayList: " + timeAddFirstList(arrayList, n) + " ms.");
        System.out.println("LinkedList: " + timeAddFirstList(linkedList, n) + " ms.");
        arrayDeque.clear();
        arrayList.clear();
        linkedList.clear();

        System.out.println("\n");
        System.out.println("Время добаваления в середину коллекции. N=" + n);
        System.out.println("ArrayDeque: operation not supported; see ArrayList results.");
        System.out.println("ArrayList: " + timeAddMiddleList(arrayList, n) + " ms.");
        System.out.println("LinkedList: " + timeAddMiddleList(linkedList, n) + " ms.");
        arrayList.clear();
        linkedList.clear();

        System.out.println("\n");
        System.out.println("Время добаваления в конец коллекции. N=" + n);
        System.out.println("ArrayDeque: " + timeAddLastDeque(arrayDeque, n) + " ms.");
        System.out.println("ArrayList: " + timeAddLastList(arrayList, n) + " ms.");
        System.out.println("LinkedList: " + timeAddLastList(linkedList, n) + " ms.");
        arrayDeque.clear();
        arrayList.clear();
        linkedList.clear();

        System.out.println("\n");
        timeAddLastDeque(arrayDeque, n); // заполнение данными
        timeAddLastList(arrayList, n);
        timeAddLastList(linkedList, n);
        System.out.println("Время удаления с начала коллекции. N=" + n);
        System.out.println("ArrayDeque: " + timeRemoveFirstDeque(arrayDeque, n) + " ms.");
        System.out.println("ArrayList: " + timeRemoveFirstList(arrayList, n) + " ms.");
        System.out.println("LinkedList: " + timeRemoveFirstList(linkedList, n) + " ms.");
        arrayDeque.clear();
        arrayList.clear();
        linkedList.clear();

        System.out.println("\n");
        timeAddLastList(arrayList, n); // заполнение данными
        timeAddLastList(linkedList, n);
        System.out.println("Время удаления с середины коллекции. N=" + n);
        System.out.println("ArrayDeque: operation not supported; see ArrayList results.");
        System.out.println("ArrayList: " + timeRemoveMiddleList(arrayList, n) + " ms.");
        System.out.println("LinkedList: " + timeRemoveMiddleList(linkedList, n) + " ms.");
        arrayList.clear();
        linkedList.clear();

        System.out.println("\n");
        timeAddLastDeque(arrayDeque, n); // заполнение данными
        timeAddLastList(arrayList, n);
        timeAddLastList(linkedList, n);
        System.out.println("Время удаления с конца коллекции. N=" + n);
        System.out.println("ArrayDeque: " + timeRemoveLastDeque(arrayDeque, n) + " ms.");
        System.out.println("ArrayList: " + timeRemoveLastList(arrayList, n) + " ms.");
        System.out.println("LinkedList: " + timeRemoveLastList(linkedList, n) + " ms.");
        arrayDeque.clear();
        arrayList.clear();
        linkedList.clear();

        System.out.println("\n");
        timeAddLastList(arrayList, n); // заполнение данными
        timeAddLastList(linkedList, n);
        System.out.println("Время получение элемента по индексу. N=" + n);
        System.out.println("ArrayDeque: operation not supported; see ArrayList results.");
        System.out.println("ArrayList: " + timeGetByIndexList(arrayList, n) + " ms.");
        System.out.println("LinkedList: " + timeGetByIndexList(linkedList, n) + " ms.");
        arrayList.clear();
        linkedList.clear();
    }

    private static long timeAddFirstList(List<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.add(0, i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeAddFirstDeque(Deque<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.addFirst(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeAddMiddleList(List<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.add(i/2, i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeAddLastList(List<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.add(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeAddLastDeque(Deque<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.add(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveFirstList(List<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.remove(0);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveFirstDeque(Deque<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.removeFirst();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveMiddleList(List<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.remove(collection.size()/2);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveLastList(List<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.remove(collection.size()-1);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeRemoveLastDeque(Deque<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            collection.removeLast();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long timeGetByIndexList(List<Integer> collection, double n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int res = collection.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
