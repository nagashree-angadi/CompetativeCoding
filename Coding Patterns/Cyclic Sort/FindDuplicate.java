/*
* Find the Duplicate Number (easy)
* We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
* The array has only one duplicate but it can be repeated multiple times.
* Find that duplicate number without using any extra space.
* You are, however, allowed to modify the input array.
 * */

class FindDuplicate {

    public static int findNumber(int[] nums) {
//        for(int i=0; i< nums.length; i++){
//            int index = nums[i] > 0 ? nums[i] : nums[i]*-1;
//            if(nums[index-1] < 0)
//                return index;
//            nums[index-1] *= -1;
//        }
//        return -1;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return nums[i];

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
