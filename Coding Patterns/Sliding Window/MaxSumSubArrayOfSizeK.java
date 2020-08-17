/**
Maximum Sum Subarray of Size K (easy)
Given an array of positive numbers and a positive number ‘k’,
find the maximum sum of any contiguous subarray of size ‘k’.
 **/
class MaxSumSubArrayOfSizeK{

    public static int findMaxSubArray(int[] arrays, int K) {
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for( int i=0; i< arrays.length; i++){
            sum += arrays[i];
            if( i>= (K-1)) {
                res = Math.max(res, sum);
                sum -= arrays[i-K+1];
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[]  input = { 2, 1, 5, 1, 3, 2 };
        int K=5;
        int res = findMaxSubArray(input, 3);
        System.out.println("The output is "+res);
    }
}