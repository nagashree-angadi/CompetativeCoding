/*
* Find all Duplicate Numbers (easy)
* We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
* The array has some duplicates, find all the duplicate numbers without using any extra space.
* */

import java.util.*;

class FindAllDuplicate {

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
//        for(int i=0; i< nums.length; i++){
//            int index = nums[i] > 0 ? nums[i] : nums[i]*-1;
//            if(nums[index-1] < 0)
//                res.add(index);
//            nums[index-1] *= -1;
//        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                res.add(nums[i]);

        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }
}
