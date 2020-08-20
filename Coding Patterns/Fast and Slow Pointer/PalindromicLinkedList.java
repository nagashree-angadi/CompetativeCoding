/*
* Palindrome LinkedList (medium) #
* Given the head of a Singly LinkedList,
* write a method to check if the LinkedList is a palindrome or not.
* Your algorithm should use constant space and the input LinkedList
* should be in the original form once the algorithm is finished.
* The algorithm should have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
* */

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = findMiddle(head);
        ListNode secondHead = reverse(mid);
        ListNode secondHeadCopy = secondHead;

        while( head!= null && secondHead!=null){
            if(head.value != secondHead.value){
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        reverse(secondHeadCopy);
        if (head == null || secondHead == null)
            return true;

        return false;
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

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}