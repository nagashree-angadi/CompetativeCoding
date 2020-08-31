/*
* Subsets With Duplicates (easy)
* Given a set of numbers that might contain duplicates, find all of its distinct subsets.
* */

import java.util.*;

class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add( new ArrayList<Integer>());

        int startIndex = 0;
        for(int i=0; i<nums.length; i++){
            int size = subsets.size();
            int index = ( i!= 0 && nums[i] == nums[i-1])? startIndex: 0;
            for( int j=index; j< size; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
            startIndex = size;
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
        System.out.println("");
    }
}
