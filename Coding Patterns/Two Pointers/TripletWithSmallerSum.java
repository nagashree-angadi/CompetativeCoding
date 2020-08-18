/*
* Triplets with Smaller Sum (medium)
* Given an array arr of unsorted numbers and a target sum,
* count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are
* three different indices. Write a function to return the count of such triplets.
* */
import java.util.*;

class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int res = 0;
        for(int i=0; i< arr.length-2; i++){
            int low = i+1;
            int high = arr.length -1;
            while(low < high){
                int localSum = arr[low]+arr[high]+arr[i];
                if( localSum < target){
                    res += high-low;
                    low++;
                }
                else{
                    high--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}