/*
* Find the Corrupt Pair (easy) #
* We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
* The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
* one of the numbers got duplicated which also resulted in one number going missing.
* Find both these numbers.
 */

class FindCorruptNums {

    public static int[] findNumbers(int[] nums) {
//        int[] res = new int[2];
//        for(int i=0; i< nums.length; i++){
//            int index = nums[i] > 0 ? nums[i] : nums[i]*-1;
//            if(nums[index-1] < 0)
//                res[0] = index;
//            nums[index-1] *= -1;
//        }
//        for(int i=0; i< nums.length; i++){
//            if(nums[i] > 0)
//                res[1] = i+1;
//        }
//
//        return res;

        int i = 0;
        int[] res = new int[2];
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1){
                res[0] = nums[i];
                res[1] = i+1;
            }


        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
        System.out.println(nums[0] + ", " + nums[1]);
        nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
        System.out.println(nums[0] + ", " + nums[1]);
    }
}
