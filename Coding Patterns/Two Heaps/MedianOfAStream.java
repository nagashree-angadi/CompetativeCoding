/*
* Find the Median of a Number Stream (medium)
* Design a class to calculate the median of a number stream. The class should have the following two methods:
* insertNum(int num): stores the number in the class
* findMedian(): returns the median of all numbers inserted in the class
* If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.
* */

import java.util.*;

class MedianOfAStream {

    public PriorityQueue<Integer> largerHalf;
    public PriorityQueue<Integer> smallerHalf;

    public MedianOfAStream(){
        largerHalf = new PriorityQueue<Integer>((a,b)-> a-b);
        smallerHalf = new PriorityQueue<Integer>((a,b)-> b-a);
    }
    public void insertNum(int num) {

        if(smallerHalf.isEmpty() || num < smallerHalf.peek())
            smallerHalf.add(num);
        else
            largerHalf.add(num);


        if( largerHalf.size()+1 <= smallerHalf.size())
            largerHalf.add(smallerHalf.poll());
        else if( smallerHalf.size() < largerHalf.size())
            smallerHalf.add(largerHalf.poll());

    }

    public double findMedian() {
        if( smallerHalf.size() == largerHalf.size())
            return (smallerHalf.peek() + largerHalf.peek())/2.0;
        return smallerHalf.peek();
    }

    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
