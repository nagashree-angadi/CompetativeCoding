/*
* Employee Free Time (hard) #
* For ‘K’ employees, we are given a list of intervals representing the working hours of each employee.
* Our goal is to find out if there is a free interval that is common to all employees.
* You can assume that each list of employee working hours is sorted on the start time.
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

class EmployeeInterval {
    Interval interval;
    int employeeIndex;
    int intervalIndex;

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
};


class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
//        List<Interval> intervals = new ArrayList<Interval>();
//        for( int i=0; i<schedule.size(); i++)
//            intervals.addAll(schedule.get(i));
//
//        Collections.sort(intervals,  (a,b) -> a.start - b.start);
//        List<Interval> res = new ArrayList<>();
//
//        for( int i=1; i< intervals.size(); i++){
//            Interval last = intervals.get(i-1);
//            if( last.end < intervals.get(i).start)
//                res.add( new Interval(last.end, intervals.get(i).start));
//        }
//
//        return res;

        List<Interval> res = new ArrayList<>();
        PriorityQueue<EmployeeInterval> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.interval.start, b.interval.start));

        for (int i = 0; i < schedule.size(); i++)
            heap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));

        Interval prev = heap.peek().interval;
        while (!heap.isEmpty()) {
            EmployeeInterval top = heap.poll();
            if (prev.end < top.interval.start) {
                res.add(new Interval(prev.end, top.interval.start));
                prev = top.interval;
            } else {
                if (prev.end < top.interval.end)
                    prev = top.interval;
            }

            List<Interval> empSchedule = schedule.get(top.employeeIndex);
            if (empSchedule.size() > top.intervalIndex + 1)
                heap.offer(new EmployeeInterval(empSchedule.get(top.intervalIndex + 1), top.employeeIndex,
                        top.intervalIndex + 1));

        }
        return res;

    }

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

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
