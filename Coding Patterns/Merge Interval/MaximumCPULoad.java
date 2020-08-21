/*
* Maximum CPU Load (hard) #
* We are given a list of Jobs. Each job has a Start time, an End time,
* and a CPU load when it is running. Our goal is to find the maximum CPU load
* at any time if all the jobs are running on the same machine.
* */

import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        Collections.sort(jobs,  (a,b) -> a.start - b.start);
        PriorityQueue<Job> heap = new PriorityQueue<Job>(
                (a,b) -> a.end - b.end
        );

        int res = 0;
        int currCPULoad = 0;
        for(Job job: jobs){
            while( !heap.isEmpty() && heap.peek().end <= job.start  )
                currCPULoad -= heap.poll().cpuLoad;

            currCPULoad += job.cpuLoad;
            res = Math.max( res, currCPULoad);
            heap.add(job);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
