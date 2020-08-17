/**
 * Smallest Subarray with a given sum (easy)
 Given an array of positive numbers and a positive number ‘S’,
 find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 Return 0, if no such subarray exists.
 **/
class MinSizeSubArraySum{

    public static int minSizeSubArraySum(int[] arrays, int sum) {
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int temp = 0;
        while( i < arrays.length){
            while(temp < sum && j < arrays.length) {
                temp += arrays[j];
                j++;
            }
            if( temp >= sum )
                res = Math.min( res, j-i);

            temp -= arrays[i];
            i++;
        }

        return res;
    }

    public static void main(String[] args){
        int[]  input = {2, 1, 5, 2, 8};
        int sum = 7;
        int res = minSizeSubArraySum(input, sum);
        System.out.println("The output is "+res);
    }
}