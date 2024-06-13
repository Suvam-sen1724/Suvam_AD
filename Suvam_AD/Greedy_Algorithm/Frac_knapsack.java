/*
Pseudo-code:
FractionalKnapsack(Items, W):
  Sort Items by value/weight ratio in descending order
  knapsack = 0
  for i from 0 to n do:
    if Items[i].weight <= W then:
      knapsack += Items[i].value
      W -= Items[i].weight
    else:
      knapsack += Items[i].value * (W / Items[i].weight)
      break
  return knapsack

*/

//Code:
package Greedy_Algorithm;

import java.util.*;

class Item {
    int value, weight;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double res = 0.0;

        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                res += arr[i].value;
                W -= arr[i].weight;
            } else {
                res += arr[i].value * ((double) W / arr[i].weight);
                break;
            }
        }

        return res;
    }
}

public class Frac_knapsack {
    public static void main(String[] args) {

        // input
        Item arr[] = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        int n = 3, W = 50;

        // output
        FractionalKnapsack fk = new FractionalKnapsack();
        System.out.println("Maximum value we can obtain = " + fk.fractionalKnapsack(W, arr, n));

    }
}
