package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// https://leetcode.com/problems/palindrome-linked-list/description/

public class LeetCode5 {

    public static void main(String[] args) {
        ListNode head;

        head = new ListNode().fillList(new int[]{1, 2, 3, 4});
        assert !isPalindrome(head);

        head = new ListNode().fillList(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
        assert isPalindrome(head);

        head = new ListNode().fillList(new int[]{1, 2, 2, 1});
        assert isPalindrome(head);

        head = new ListNode().fillList(new int[]{1, 2, 1});
        assert isPalindrome(head);

        head = new ListNode().fillList(new int[]{1, 1});
        assert isPalindrome(head);

        head = new ListNode().fillList(new int[]{1, 2});
        assert !isPalindrome(head);

        head = new ListNode().fillList(new int[]{1});
        assert isPalindrome(head);

        head = new ListNode().fillList(new int[]{});
        assert isPalindrome(head);
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

    public static boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        List<Integer> reversedVals = new ArrayList<>(vals);
        Collections.reverse(reversedVals);

        return Objects.equals(vals, reversedVals);
    }
}
