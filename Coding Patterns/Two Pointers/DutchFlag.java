/*
* Dutch National Flag Problem (medium)
* Given an array containing 0s, 1s and 2s, sort the array in-place.
* You should treat numbers of the array as objects, hence,
* we can’t count 0s, 1s, and 2s to recreate the array.
*/
class DutchFlag {

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length -1;

        while(left < right){
            if( arr[left] > arr[right]){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            if(arr[left] == 0)
                left++;
            else if( arr[right] == 2)
                right--;
            else
                left++;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
