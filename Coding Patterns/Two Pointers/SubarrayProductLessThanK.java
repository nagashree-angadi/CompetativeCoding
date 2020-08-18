/*
* Subarrays with Product Less than a Target (medium)
* Given an array with positive numbers and a target number,
* find all of its contiguous subarrays whose product is less than the target number.
* */
import java.util.*;

class SubarrayProductLessThanK {

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int j=0, product=1;
        for(int i=0; i< arr.length; i++){
            product *= arr[i];
            while(product >= target && j < arr.length){
                product /= arr[j];
                j++;
            }

            List<Integer> temp = new ArrayList<>();
            for(int k=i; k>=j; k--){
                temp.add(arr[k]);
                res.add(new ArrayList<>(temp));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
