/**
 * Pair with Target Sum (easy)
 * Given an array of sorted numbers and a target sum, find a pair in the array
 * whose sum is equal to the given target.
 * */
class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        int low = 0;
        int high = arr.length-1;

        while(low < high){
            int localSum = arr[low] + arr[high];
            if( localSum == targetSum)
                return new int[]{low, high};
            else if( localSum > targetSum)
                high--;
            else
                low++;

        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}