/*
* Find the Duplicate Number (easy)
* We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
* The array has only one duplicate but it can be repeated multiple times.
* Find that duplicate number without using any extra space.
* You are, however, allowed to modify the input array.
 * */

class FindDuplicate {

    public static int findNumber(int[] nums) {

    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
