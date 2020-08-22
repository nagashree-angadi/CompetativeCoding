/*
* Reverse a Sub-list (medium)
* Given the head of a LinkedList and two positions ‘p’ and ‘q’,
* reverse the LinkedList from position ‘p’ to ‘q’.
* */

import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseSubList {

    public static ListNode reverse(ListNode head, int m, int n) {
        if (m == n)
            return head;

        ListNode node = head;
        ListNode mNode = null, nNode = null;
        ListNode mPrev = null, nNext = null;
        ListNode prev = null;
        int i=1;

        while( head != null){
            if( i == m){
                mPrev = prev;
                mNode = head;
            }
            if(i  == n){
                nNode = head;
                nNext = head.next;
            }
            i++;
            prev = head;
            head = head.next;
        }

        reverseHelper(mNode, nNode);
        if( mPrev.next == null)
            node = nNode;
        else
            mPrev.next = nNode;
        mNode.next = nNext;

        return node;
    }

    private static void reverseHelper(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        while(prev!=tail){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println("");
    }
}