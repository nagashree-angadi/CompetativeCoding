/*
* Longest Subarray with Ones after Replacement (hard)
* Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
* find the length of the longest contiguous subarray having all 1s.
* */
import java.util.*;
class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int j=0;
        int res=0;
        int countZeros = 0;

        for(int i=0; i< arr.length; i++){
            if( arr[i] == 0)
                countZeros++;

            if( countZeros > k) {
                if(arr[j] == 0)
                    countZeros--;
                j++;
            }

            res = Math.max( res, i-j+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
    }
}
