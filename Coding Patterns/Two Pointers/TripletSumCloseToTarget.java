/*
* Triplet Sum Close to Target (medium)
* Given an array of unsorted numbers and a target number,
* find a triplet in the array whose sum is as close to the target number as possible,
* return the sum of the triplet. If there are more than one such triplet,
* return the sum of the triplet with the smallest sum.
* */
import java.util.*;

class TripletSumCloseToTarget {

    public static int searchTriplet(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0; i< arr.length-2; i++){
            int low = i+1;
            int high = arr.length -1;
            while(low < high){
                int localSum = arr[low]+arr[high]+arr[i];
                int diff = targetSum - localSum;
                if (diff == 0)
                    return localSum;

                if (Math.abs(diff) < Math.abs(minDiff)
                        || (Math.abs(diff) == Math.abs(minDiff) && diff > minDiff))
                    minDiff = diff;

                if(diff > 0)
                    low++;
                else
                    high--;

            }
        }

        return targetSum-minDiff;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }
}