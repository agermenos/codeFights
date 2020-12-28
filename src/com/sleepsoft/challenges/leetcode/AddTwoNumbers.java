package com.sleepsoft.challenges.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        boolean carry = false;
        if (l1 == null) l1 = new ListNode(0);
        if (l2 == null) l2 = new ListNode(0);
        int newVal = l1.val + l2.val;
        if (newVal >= 10) {
            newVal = newVal % 10;
            carry = true;
        }
        if (carry) {
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else l1.next = new ListNode(l1.next.val + 1, l1.next.next);
        }
        return new ListNode(newVal, addTwoNumbers(l1.next, l2.next));
    }


    class ListNode {
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
    }

    public void printNode (ListNode listNode) {
        System.out.print(" [");
        while (listNode!=null) {
            if (listNode != null) System.out.print(listNode.val);
            if (listNode.next != null) System.out.print(", ");
            listNode = listNode.next;
        }
        System.out.println("]");
    }

    public void test(){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.print ("[2, 4, 3] + [5, 6, 4]  Expected [7, 0, 8] ---> ");
        printNode(addTwoNumbers.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))));
    }

    public static void main(String args[]) {
        AddTwoNumbers addTwoNumbers=new AddTwoNumbers();
        addTwoNumbers.test();
    }
}