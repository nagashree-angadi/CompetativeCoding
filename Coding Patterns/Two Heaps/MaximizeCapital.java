/*
* Maximize Capital (hard)
* Given a set of investment projects with their respective profits, we need to find the most profitable projects.
* We are given an initial capital and are allowed to invest only in a fixed number of projects.
* Our goal is to choose projects that give us the maximum profit. Write a function that returns the
* maximum total capital after selecting the most profitable projects.
* We can start an investment project only when we have the required capital.
* Once a project is selected, we can assume that its profit has become our capital.
* */

import java.util.*;

class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        PriorityQueue<Integer> minCapital = new PriorityQueue<Integer>((a,b)-> capital[a]-capital[b]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<Integer>((a,b)-> profits[b]-profits[a]);

        for (int i = 0; i < capital.length; i++)
            minCapital.offer(i);

        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= availableCapital)
                maxProfit.add(minCapital.poll());

            if (maxProfit.isEmpty())
                break;
            availableCapital += profits[maxProfit.poll()];
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}