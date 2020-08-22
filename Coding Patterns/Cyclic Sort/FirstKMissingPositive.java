/*
* Find the First K Missing Positive Numbers (hard) #
* Given an unsorted array containing numbers and a number ‘k’,
* find the first ‘k’ missing positive numbers in the array.
* */

import java.util.*;

class FirstKMissingPositive {

    public static List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> extras = new HashSet<>();
        int index = 0;
        while(index < nums.length){
            if( nums[index] > 0 && nums[index] <= nums.length
                    && nums[index] != nums[nums[index] - 1]){
                int temp = nums[nums[index]-1];
                nums[nums[index]-1] = nums[index];
                nums[index] = temp;
            }
            else
                index++;
        }

        for( int i=0; i< nums.length; i++){
            if( res.size() < k && i+1 != nums[i]) {
                res.add(i + 1);
                extras.add(nums[i]);
            }
        }

        index++;
        while(res.size() < k){
            if(!extras.contains(index))
                res.add(index);
            index++;
        }

        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
        System.out.println("Missing numbers: " + missingNumbers);

        missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
