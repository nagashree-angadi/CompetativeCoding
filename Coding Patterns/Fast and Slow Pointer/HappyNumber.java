/*
* Happy Number (medium)
* Any number will be called a happy number if,
* after repeatedly replacing it with a number equal to the sum of the square of all of its digits,
* leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’.
* Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
* */
import java.util.*;
class HappyNumber {

    public static boolean find(int num) {
        if( num < 9)
            return num==0;

//        Set<Integer> set = new HashSet<Integer>();
//
//        while(num != 1){
//            num = findSum(num);
//            if( set.contains(num))
//                return false;
//            set.add(num);
//        }
//
//        return true;

        int slow = num;
        int fast = num;

        do{
            slow = findSum(slow);
            fast = findSum(findSum(fast));
            if( slow == 1)
                return true;
        }while(slow != fast);

        return slow == 1;
    }

    private static int findSum(int num){
        int sum = 0;
        while(num > 0){
            sum += (num%10)*(num%10);
            num = num/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}