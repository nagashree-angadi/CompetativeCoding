/*
* Find the Smallest Missing Positive Number (medium) #
* Given an unsorted array containing numbers, find the smallest missing positive number in it.
* */

class FirstMissingPositive {

    public static int findNumber(int[] nums) {
        int index = 0;
        while(index < nums.length){
            if( nums[index] > 0 && nums[index] <= nums.length
                    && nums[index] != nums[nums[index] - 1]){
                int temp = nums[nums[index]-1];
                nums[nums[index]-1] = nums[index];
                nums[index] = temp;
            }
            else
                index++;
        }

        for( int i=0; i< nums.length; i++)
            if( i+1 != nums[i])
                return i+1;

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FirstMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
        System.out.println(FirstMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
        System.out.println(FirstMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));
    }
}
