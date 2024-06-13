/*
Pseudo-code:
WeightedIntervalScheduling(jobs):
Sort jobs by finish time
Compute array P where P[j] is the largest index i < j such that jobs[i] is compatible with jobs[j]
Compute array M where M[j] is the maximum weight of jobs[1..j]
for j = 1 to n
    M[j] = max(M[j-1], jobs[j].weight + M[P[j]])
return M[n]

*/


//Code:

package DP;
import java.util.Arrays;

public class WeightedIntervalScheduling {
    static class Job {
        int start, finish, profit;
        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        // input
        Job[] jobs = {new Job(1, 2, 50), new Job(3, 5, 20),
                      new Job(6, 19, 100), new Job(2, 100, 200)};

        // output
        System.out.println("Max profit: " + schedule(jobs));
    }

    static int schedule(Job jobs[]) {
        // sort jobs according to finish time
        Arrays.sort(jobs, (a, b) -> a.finish - b.finish);

        // Create an array to store solutions of subproblems
        int n = jobs.length;
        int[] table = new int[n];
        table[0] = jobs[0].profit;

        // Fill entries in table[] using recursive property
        for (int i = 1; i < n; i++) {
            // Find profit including the current job
            int inclProf = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1) inclProf += table[l];

            // Store maximum of including and excluding
            table[i] = Math.max(inclProf, table[i - 1]);
        }

        // Store result and free dynamic memory allocated for table[]
        int result = table[n - 1];

        return result;
    }

    // A Binary Search based function to find the latest job (before current job) that doesn't conflict with current job.
    static int binarySearch(Job jobs[], int index) {
        // Initialize 'lo' and 'hi' for Binary Search
        int lo = 0, hi = index - 1;

        // Perform binary Search iteratively
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (jobs[mid].finish <= jobs[index].start) {
                if (jobs[mid + 1].finish <= jobs[index].start)
                    lo = mid + 1;
                else
                    return mid;
            } else
                hi = mid - 1;
        }

        return -1;
    }
}
