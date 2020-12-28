package com.sleepsoft.challenges.leetcode;

import org.junit.Test;

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
  public  class MergeTwoLists {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 ==null && l2 == null) return null;
            if (l1 ==null && l2 != null) return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
            if (l1 != null && l2== null) return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
            if (l1.val>l2.val) return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
            else return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
        }

        @Test
        public void test(){
            System.out.println("Input\n[1,2,4]\n[1,3,4]\nExpected[1,1,2,3,4,4]\n");
            ListNode l1 = new ListNode(1, new ListNode(2, new ListNode( 4)));
            ListNode l2 = new ListNode(1, new ListNode(3, new ListNode( 4)));
            ListNode listNode = mergeTwoLists(l1, l2);
            while (listNode.next!=null) {
                System.out.printf("%d, ",listNode.val);
                listNode = listNode.next;
            }
        }
    }

class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
