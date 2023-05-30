

/*

5. Write a program to implement Fractional knapsack and 0/1 knapsack.

*/


import java.util.*;

// Item class to represent each item
class Item {
    int weight;
    int value;

    // Constructor
    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

// Comparator to sort items based on their value per unit weight in non-decreasing order
class ValuePerWeightComparator implements Comparator<Item> {
    public int compare(Item item1, Item item2) {
        double valuePerWeight1 = (double) item1.value / item1.weight;
        double valuePerWeight2 = (double) item2.value / item2.weight;
        return Double.compare(valuePerWeight2, valuePerWeight1);
    }
}

public class q5 {
    // Function to calculate the maximum value that can be obtained
    static double getMaxValue(int[] weights, int[] values, int capacity) {
        List<Item> items = new ArrayList<>();
        int n = weights.length;

        // Create items from weights and values
        for (int i = 0; i < n; i++) {
            Item item = new Item(weights[i], values[i]);
            items.add(item);
        }

        // Sort items based on value per unit weight
        Collections.sort(items, new ValuePerWeightComparator());

        double totalValue = 0;
        int remainingCapacity = capacity;

        // Iterate over sorted items and add them to the knapsack
        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                // Add the whole item to the knapsack
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Add a fraction of the item to fill the knapsack
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += fraction * item.value;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int[] weights = { 10, 20, 30 };
        int[] values = { 60, 100, 120 };
        int capacity = 50;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}




/*
OUTPUT -


Maximum value that can be obtained: 240.0



*/

