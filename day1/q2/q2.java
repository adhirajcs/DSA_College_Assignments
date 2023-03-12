/*

2. Create a Class BasicSort within that implement three Generic methods that can implement the 
BuubleSort(), SelectionSort(), InsertionSort() that can sort of any type of data.

 */

class BasicSort {

    // A generic method that implements the bubble sort algorithm for any array of
    // comparable elements
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                // Compare the adjacent elements and swap them if they are in the wrong order
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    // A generic method that implements the selection sort algorithm for any array
    // of comparable elements
    public static <T extends Comparable<T>> void selectionSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                // Find the index of the minimum element in the unsorted part of the array
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Swap the minimum element with the first element in the unsorted part of the
            // array
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // A generic method that implements the insertion sort algorithm for any array
    // of comparable elements
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            // Move the elements that are greater than the key to one position ahead of
            // their current position
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        Integer[] arr = { 5, 3, 8, 6, 2, 7, 1, 4 };

        // sort the array using bubble sort
        BasicSort.bubbleSort(arr);
        System.out.println("Sorted array using bubble sort:");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // sort the array using selection sort
        BasicSort.selectionSort(arr);
        System.out.println("Sorted array using selection sort:");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // sort the array using insertion sort
        BasicSort.insertionSort(arr);
        System.out.println("Sorted array using insertion sort:");
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

/*
 * OUTPUT -
 * Sorted array using bubble sort:
 * 1 2 3 4 5 6 7 8
 * Sorted array using selection sort:
 * 1 2 3 4 5 6 7 8
 * Sorted array using insertion sort:
 * 1 2 3 4 5 6 7 8
 * 
 */
