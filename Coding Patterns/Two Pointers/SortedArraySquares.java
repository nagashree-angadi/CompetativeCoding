/**
 * Squaring a Sorted Array (easy)
 * Given a sorted array, create a new array containing squares of all the
 * number of the input array in the sorted order.
 */
import java.util.*;

class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
//        for(int i=0; i<arr.length; i++){
//            squares[i] = arr[i]*arr[i];
//        }
//        Arrays.sort(squares);

        int low=0;
        int high=arr.length-1;
        int index=arr.length-1;
        while(low <= high){
            int left = arr[low]*arr[low];
            int right = arr[high]*arr[high];
            if( left > right){
                squares[index--] = left;
                low++;
            }else{
                squares[index--] = right;
                high--;
            }
        }

        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
