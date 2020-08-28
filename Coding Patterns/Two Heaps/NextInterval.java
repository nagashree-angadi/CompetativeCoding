/*
* Next Interval (hard) #
* Given an array of intervals, find the next interval of each interval.
* In a list of intervals, for an interval ‘i’ its next interval ‘j’ will have the smallest
* ‘start’ greater than or equal to the ‘end’ of ‘i’.
* Write a function to return an array containing indices of the next interval of each input interval.
* If there is no next interval of a given interval, return -1. It is given that none of the intervals
* have the same start point.
* */

import java.util.*;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class NextInterval {
    public static int[] findNextInterval(Interval[] intervals) {
        int[] res = new int[intervals.length];
        PriorityQueue<Integer> maxStart = new PriorityQueue<Integer>((a,b)-> intervals[b].start-intervals[a].start);
        PriorityQueue<Integer> maxEnd = new PriorityQueue<Integer>((a,b)-> intervals[b].end-intervals[a].end);

        for (int i = 0; i < intervals.length; i++){
            maxStart.offer(i);
            maxEnd.offer(i);
        }

        while(!maxEnd.isEmpty()){
            int startIndex = -1;
            int endIndex = maxEnd.poll();
            res[endIndex] = -1;
            while(!maxStart.isEmpty() && intervals[maxStart.peek()].start >= intervals[endIndex].end)
                startIndex = maxStart.poll();
            res[endIndex] = startIndex;
            if(startIndex != -1) maxStart.add(startIndex);
        }

        return res;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.print("\n");
    }
}