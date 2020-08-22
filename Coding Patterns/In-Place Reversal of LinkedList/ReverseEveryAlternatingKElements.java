/*
* Reverse alternating K-element Sub-list (medium) #
* Given the head of a LinkedList and a number ‘k’,
* reverse every alternating ‘k’ sized sub-list starting from the head.
* If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
* */

import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseEveryAlternatingKElements {

    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        while(true){
            int i = 0;
            ListNode beforeReverse = prev;
            ListNode afterReverse = curr;

            while( i<k && curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }

            if( beforeReverse == null)
                head = prev;
            else
                beforeReverse.next = prev;
            afterReverse.next = curr;
            prev = afterReverse;

            i=0;
            while( i<k && curr != null){
                prev = curr;
                curr = curr.next;
                i++;
            }

            if( curr == null)
                break;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryAlternatingKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
        System.out.println("");
    }
}