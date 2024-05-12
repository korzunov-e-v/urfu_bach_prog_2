package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/merge-two-sorted-lists/description/

public class LeetCode9 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode().fillList(new int[]{1, 3, 4, 5});
        ListNode listNode2 = new ListNode().fillList(new int[]{1, 2, 6, 7});

        ListNode resultListNode = mergeTwoLists(listNode1, listNode2);
        List<Integer> expected = new ArrayList<>();
        Collections.addAll(expected, 1, 1, 2, 3, 4, 5, 6, 7);
        assert resultListNode.toList().equals(expected);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode result = new ListNode();
        if (list1.val <= list2.val) {
            result.val = list1.val;
            list1 = list1.next;
        } else {
            result.val = list2.val;
            list2 = list2.next;
        }

        ListNode curr = result;
        while ((list1 != null) | (list2 != null)) {
            if (list1 == null) {
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                list2 = list2.next;
            } else if (list2 == null) {
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            } else if (list1.val <= list2.val) {
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                list2 = list2.next;
            }
        }
        return result;
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

        public List<Integer> toList() {
            ListNode curr = this;
            List<Integer> result = new ArrayList<>();
            while (curr != null) {
                result.add(curr.val);
                curr = curr.next;
            }
            return result;
        }
    }


}
