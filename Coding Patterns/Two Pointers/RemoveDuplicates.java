/*
* Remove Duplicates (easy)
* Given an array of sorted numbers, remove all duplicates from it.
* You should not use any extra space; after removing the duplicates in-place
* return the new length of the array.
* */
class RemoveDuplicates {

    public static int remove(int[] arr) {
        int j = 1;
        for( int i=1; i< arr.length; i++){
            if( arr[i] != arr[i-1]){
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
