/*
* Permutations (medium)
* Given a set of distinct numbers, find all of its permutations.
* Permutation is defined as the re-arranging of the elements of the set.
* For example, {1, 2, 3} has the following six permutations:
* {1, 2, 3}
* {1, 3, 2}
* {2, 1, 3}
* {2, 3, 1}
* {3, 1, 2}
* {3, 2, 1}
* If a set has ‘n’ distinct elements it will have n! permutations.
* */

import java.util.*;

class Permutations {

//    public static List<List<Integer>> findPermutations(int[] nums) {
//        List<List<Integer>> subsets = new ArrayList<>();
//        Queue<List<Integer>> permutations = new LinkedList<>();
//        permutations.add( new ArrayList<Integer>());
//
//        for(int num: nums){
//            int size = permutations.size();
//            for( int j=0; j< size; j++) {
//                List<Integer> temp = permutations.poll();
//                for( int k=0; k<=temp.size(); k++){
//                    List<Integer> set = new ArrayList<>(temp);
//                    set.add(k,num);
//                    if( set.size() == nums.length)
//                        subsets.add(set);
//                    else
//                        permutations.add(set);
//                }
//            }
//        }
//        return subsets;
//    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
                                                      List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(currentPermutation);
        } else {
            for (int i = 0; i <= currentPermutation.size(); i++) {
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
                newPermutation.add(i, nums[index]);
                generatePermutationsRecursive(nums, index + 1, newPermutation, result);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
        System.out.println("");
    }
}
