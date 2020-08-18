/*
* Triplet Sum to Zero (medium)
* Given an array of unsorted numbers,
* find all unique triplets in it that add up to zero.
* */
import java.util.*;

class TripletSumToZero {

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<List<Integer>>();
        Arrays.sort(arr);

        for(int i=0; i< arr.length-2; i++){
            int targetSum = arr[i]*-1;
            int low = i+1;
            int high = arr.length -1;

            while(low <= high){
                int localSum = arr[low]+arr[high];
                if( localSum == targetSum){
                    List<Integer> temp = new LinkedList<Integer>(){};
                    temp.add(arr[i]);
                    temp.add(arr[low]);
                    temp.add(arr[high]);
                    if( !seen.contains(temp)){
                        triplets.add(temp);
                        seen.add(temp);
                    }
                    Collections.sort(temp);

                    low++;
                    high--;
                }
                else if(localSum > targetSum)
                    high--;
                else
                    low++;
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }
}