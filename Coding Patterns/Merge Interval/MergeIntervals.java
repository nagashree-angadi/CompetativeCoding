/*
* Merge Intervals (medium)
* Given a list of intervals,
* merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
* */

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a,b)-> a.start - b.start);
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        mergedIntervals.add(intervals.get(0));
        int index = 0;

        for( int i=1; i< intervals.size(); i++){
            Interval last = mergedIntervals.get(index);
            if( last.end > intervals.get(i).start)
                last.end = Math.max(intervals.get(i).end, last.end);
            else{
                mergedIntervals.add(intervals.get(i));
                index++;
            }

        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}