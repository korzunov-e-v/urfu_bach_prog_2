package leetcode;

// https://leetcode.com/problems/reorder-list/description/

import java.util.ArrayList;
import java.util.List;

public class LeetCode2 {

    public static void main(String[] args) {
        ListNode head = new ListNode().fillList(new int[]{1, 2, 3, 4});
        reorderList(head);
        System.out.println(head);

        head = new ListNode().fillList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(head);
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

    public static void reorderList(ListNode head) {
        ListNode curr = head;
        List<Integer> vals = new ArrayList<>();

        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }
        // 1 2 3 4 5 6 7 8 9
        // 1 9 2 8 3 7 4 6 5

        int j = 0;
        int index = 1;
        while (index <= vals.size()) {
            vals.add(index, vals.get(vals.size() - 1));
            vals.remove(vals.size() - 1);
            j++;
            index = 2 * j + 1;
        }

        curr = head;
        for (int i = 1; i < vals.size(); i++) {
            curr.next = new ListNode(vals.get(i));
            curr = curr.next;
        }
    }
}
