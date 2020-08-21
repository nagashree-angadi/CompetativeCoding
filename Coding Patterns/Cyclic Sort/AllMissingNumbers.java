/*
* Find all Missing Numbers (easy)
* We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
* The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
* */

import java.util.*;

class AllMissingNumbers {

//    public static List<Integer> findNumbers(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//
//        for(int i=0; i< nums.length; i++){
//            int index = nums[i] > 0 ? nums[i] : nums[i]*-1;
//            nums[index-1] = nums[index-1] >0 ? nums[index-1]*-1 :  nums[index-1];
//        }
//
//        for(int i=0; i< nums.length; i++)
//            if(nums[i]>0)
//                res.add(i+1);
//
//        return res;
//    }

    public static List<Integer> findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
