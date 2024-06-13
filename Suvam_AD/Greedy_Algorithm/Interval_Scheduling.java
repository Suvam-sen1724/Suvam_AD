/*
Pseudo-code:
IntervalScheduling(Jobs):
  Sort Jobs by finish time
  S = {Jobs[0]}
  k = 0
  for i from 1 to n do:
    if Jobs[i].start >= Jobs[k].finish then:
      Add Jobs[i] to S
      k = i
  return S

*/

//Code:
package Greedy_Algorithm;

import java.util.*;

class Job {
    int start, finish;

    Job(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

class IntervalScheduling {
    static void printMaxActivities(Job arr[], int n) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a.finish));

        int i = 0;
        System.out.print("(" + arr[i].start + ", " + arr[i].finish + "), ");

        for (int j = 1; j < n; j++) {
            if (arr[j].start >= arr[i].finish) {
                System.out.print("(" + arr[j].start + ", " + arr[j].finish + "), ");
                i = j;
            }
        }
    }
}

public class Interval_Scheduling {
    public static void main(String[] args) {
        // input
        Job jobs[] = { new Job(1, 2), new Job(3, 4), new Job(0, 6), new Job(5, 7), new Job(8, 9), new Job(5, 9) };
        int n = jobs.length;

        // output
        IntervalScheduling.printMaxActivities(jobs, n);

    }
}
