/*
 * Start of LinkedList Cycle (medium)
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 * */

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class LinkedListCycleStart {

    private static ListNode findCycleStart(ListNode head) {
        int length = findCycleLength(head);
        if( length == 0)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while(length > 0){
            fast = fast.next;
            length--;
        }

        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    private static int findCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return calculateLength(slow);
        }
        return 0;
    }

    private static int calculateLength(ListNode head){
        ListNode slow = head;
        int res = 0;
        do{
            head = head.next;
            res++;
        }while(slow != head);
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}