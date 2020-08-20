/*
* Rearrange a LinkedList (medium) #
* Given the head of a Singly LinkedList,
* write a method to modify the LinkedList such that the nodes from the second half
* of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
* So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should
* return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
* */
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RearrangeList {

    public static void reorder(ListNode head) {

        if (head == null || head.next == null)
            return;

        ListNode mid = findMiddle(head);
        ListNode secondHead = reverse(mid);

        while( head!= null && secondHead!=null){
            ListNode temp = head.next;
            head.next = secondHead;
            head = temp;

            temp = secondHead.next;
            secondHead.next = head;
            secondHead = temp;
        }
        if (head != null)
            head.next = null;

    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}