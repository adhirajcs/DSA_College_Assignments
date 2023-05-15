/*

3. Write functions for each of the following sorting techniques
a. Radix
b. Heap sort

*/

import java.util.*;

public class Main
{

// Sorts an array of integers using the radix sort algorithm.
  public static void radixSort (int[]arr)
  {
    // Find the maximum element in the array.
    int max = getMax (arr);

    // Do counting sort for every digit from least significant to most significant.
    for (int exp = 1; max / exp > 0; exp *= 10)
      {
	countingSort (arr, exp);
      }
  }

// Returns the maximum element in an array of integers.
  private static int getMax (int[]arr)
  {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++)
      {
	if (arr[i] > max)
	  {
	    max = arr[i];
	  }
      }
    return max;
  }

// Sorts an array of integers using the counting sort algorithm.
  private static void countingSort (int[]arr, int exp)
  {
    int[] output = new int[arr.length];
    int[] count = new int[10];

    // Count the number of occurrences of each digit.
    for (int i = 0; i < arr.length; i++)
      {
	count[(arr[i] / exp) % 10]++;
      }

    // Compute the cumulative count of each digit.
    for (int i = 1; i < 10; i++)
      {
	count[i] += count[i - 1];
      }

    // Build the output array.
    for (int i = arr.length - 1; i >= 0; i--)
      {
	output[count[(arr[i] / exp) % 10] - 1] = arr[i];
	count[(arr[i] / exp) % 10]--;
      }

    // Copy the output array to the original array.
    for (int i = 0; i < arr.length; i++)
      {
	arr[i] = output[i];
      }
  }

// Sorts an array of integers using the heap sort algorithm.
  public static void heapSort (int[]arr)
  {
    int n = arr.length;

    // Build a max-heap.
    for (int i = n / 2 - 1; i >= 0; i--)
      {
	heapify (arr, n, i);
      }

    // Extract elements from the heap one by one and place them at the end of the array.
    for (int i = n - 1; i >= 0; i--)
      {
	// Swap the root element (maximum value) with the last element of the heap.
	int temp = arr[0];
	arr[0] = arr[i];
	arr[i] = temp;

	// Maintain the heap property on the remaining elements.
	heapify (arr, i, 0);
      }
  }

// Maintains the heap property on a subtree with the root at the given index.
  private static void heapify (int[]arr, int n, int i)
  {
    int largest = i;		// Initialize the largest as the root.
    int left = 2 * i + 1;	// Index of the left child.
    int right = 2 * i + 2;	// Index of the right child.

    // If the left child is larger than the root, update the largest.
    if (left < n && arr[left] > arr[largest])
      {
	largest = left;
      }

    // If the right child is larger than the largest so far, update the largest.
    if (right < n && arr[right] > arr[largest])
      {
	largest = right;
      }

    // If the largest is not the root, swap the root and the largest, and recursively heapify the affected subtree.
    if (largest != i)
      {
	int temp = arr[i];
	arr[i] = arr[largest];
	arr[largest] = temp;
	heapify (arr, n, largest);
      }
  }




// main function
  public static void main(String[] args) {
    int[] arr = {4, 1, 7, 3, 9, 2, 6, 8, 5};
    System.out.println("Original array: " + Arrays.toString(arr));
    
    // method for radix
    radixSort(arr);
    System.out.println("Sorted array: " + Arrays.toString(arr));

    // method for heap sort
    heapSort(arr);
    System.out.println("Sorted array: " + Arrays.toString(arr));
}

}


/*
OUTPUT -

Original array: [4, 1, 7, 3, 9, 2, 6, 8, 5]
Sorted array: [1, 2, 3, 4, 5, 6, 7, 8, 9]
Sorted array: [1, 2, 3, 4, 5, 6, 7, 8, 9]



*/
