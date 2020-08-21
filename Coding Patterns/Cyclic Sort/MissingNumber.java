/*
* Find the Missing Number (easy)
* We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
* Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
* */

class MissingNumber {

    public static int findMissingNumber(int[] nums) {
//        int sum = nums.length * (nums.length+1)/2;
//        int localSum = 0;
//        for( int num: nums)
//            localSum += num;
//        return sum-localSum;
        sort(nums);

        for(int i=0; i<nums.length; i++){
            if( i != nums[i])
                return i;
        }
        return -1;
    }

    public static void sort(int[] nums) {
        int index = 0;
        while(index < nums.length){
            if( nums[index] < nums.length && index != nums[index]){
                int temp = nums[nums[index]];
                nums[nums[index]] = nums[index];
                nums[index] = temp;
            }
            else
                index++;
        }
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
