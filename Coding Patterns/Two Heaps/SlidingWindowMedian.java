/*
* Sliding Window Median (hard)
* Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized
* sub-arrays (or windows) of the array.
* */

import java.util.*;

class SlidingWindowMedian {
    public double[] findSlidingWindowMedian(int[] nums, int k) {
        PriorityQueue<Integer> largerHalf = new PriorityQueue<Integer>((a,b)-> a-b);
        PriorityQueue<Integer> smallerHalf = new PriorityQueue<Integer>((a,b)-> b-a);
        double[] res = new double[nums.length - k + 1];

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            if(smallerHalf.isEmpty() || smallerHalf.peek() >= num)
                smallerHalf.add(num);
            else
                largerHalf.add(num);

            if( smallerHalf.size() > largerHalf.size()+1)
                largerHalf.add(smallerHalf.poll());
            else if( smallerHalf.size() < largerHalf.size())
                smallerHalf.add(largerHalf.poll());

            if(i-k+1 >= 0) {
                double median = 0;
                if( smallerHalf.size() == largerHalf.size())
                    median =  (smallerHalf.peek() + largerHalf.peek())/2.0;
                else
                    median = smallerHalf.peek();
                res[i - k + 1] = median;

                num = nums[i-k+1];
                if( num <= smallerHalf.peek())
                    smallerHalf.remove(num);
                else
                    largerHalf.remove(num);

                if( smallerHalf.size() > largerHalf.size()+1)
                    largerHalf.add(smallerHalf.poll());
                else if( smallerHalf.size() < largerHalf.size())
                    smallerHalf.add(largerHalf.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}