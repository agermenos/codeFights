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
       ListNode returnLN = doTheAdd(l1, l2);
       ListNode finalLN = doBaseChange(returnLN);
       return finalLN;
    }

    private ListNode doBaseChange(ListNode returnLN) {
        if (returnLN.val>=10) {
            returnLN.val = returnLN.val-10;
            if (returnLN.next!=null)
                returnLN.next.val++;
            else
                returnLN.next=new ListNode(1);
        }
        if (returnLN.next!=null) doBaseChange(returnLN.next);
        return returnLN;
    }

    private ListNode doTheAdd(ListNode l1, ListNode l2) {
        if (l1.next==null && l2.next==null) return new ListNode(l1.val + l2.val);
        if (l1.next==null) l1.next = new ListNode(0);
        if (l2.next==null) l2.next= new ListNode(0);
        return new ListNode (l1.val + l2.val, doTheAdd(l1.next, l2.next));
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