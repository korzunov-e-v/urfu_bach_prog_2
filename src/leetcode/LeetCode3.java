package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/reverse-linked-list/description/

public class LeetCode3 {

    public static void main(String[] args) {
        ListNode head;
        ListNode result;

        head = new ListNode().fillList(new int[]{1, 2, 3, 4});
        System.out.println(head);
        result = reverseList(head);
        System.out.println(result);

        head = new ListNode().fillList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(head);
        result = reverseList(head);
        System.out.println(result);
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        private ListNode fillList(int[] vals) {
            ListNode head = new ListNode();
            ListNode curr = head;
            for (int i = 0; i < vals.length; i++) {
                curr.val = vals[i];
                if (i == vals.length - 1) {
                    curr.next = null;
                } else {
                    curr.next = new ListNode();
                    curr = curr.next;
                }
            }

            return head;
        }

        @Override
        public String toString() {
            ListNode curr = this;
            StringBuilder sb = new StringBuilder("[ ");
            while (curr != null) {
                sb.append(curr.val);
                if (curr.next != null) {
                    sb.append(", ");
                } else {
                    sb.append(" ]");
                }
                curr = curr.next;
            }
            return sb.toString();
        }
    }

    public static ListNode reverseList(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode curr = head;

        if (head == null) {
            return null;
        }

        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }
        Collections.reverse(vals);

        ListNode newHead = new ListNode();
        curr = newHead;
        for (int i = 0; i < vals.size(); i++) {
            curr.val = vals.get(i);
            if (i == vals.size() - 1) {
                curr.next = null;
            } else {
                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        return newHead;
    }
}
