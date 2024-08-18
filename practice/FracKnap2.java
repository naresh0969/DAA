package practice;

import java.util.Arrays;

class Item implements Comparable<Item> {
    int value, weight;
    float ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (float) value / weight;
    }

    @Override
    public int compareTo(Item other) {
        return Float.compare(other.ratio, this.ratio);
    }
}

class Knap {
    int capacity;
    Item[] items;
    float profit;

    Knap(int[] values, int[] weights, int capacity) {
        this.capacity = capacity;
        this.items = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        this.profit = 0;
    }

    void ks() {
        // Sort items by their value-to-weight ratio in descending order
        Arrays.sort(items);

        for (Item item : items) {
            if (item.weight <= capacity) {
                profit += item.value;
                capacity -= item.weight;
            } else if (capacity > 0) {
                profit += item.ratio * capacity;
                break;
            }
        }

        System.out.println("Profit = " + profit);
    }
}

public class FracKnap2 {
    public static void main(String[] args) {
        int[] values = {10, 8, 12, 5};
        int[] weights = {5, 2, 3, 4};
        int capacity = 12;

        Knap knapsack = new Knap(values, weights, capacity);
        knapsack.ks();
    }
}
