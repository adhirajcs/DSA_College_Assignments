/*

2. Write functions for each of the following sorting techniques
a. Quick
b. Merge

*/

import java.util.*;

public class Main
{

// Quick Sort algorithm implementation in Java.
  public static void quickSort (int[]arr, int low, int high)
  {
    if (low < high)
      {
	int pivotIndex = partition (arr, low, high);
	  quickSort (arr, low, pivotIndex - 1);
	  quickSort (arr, pivotIndex + 1, high);
      }
  }

// method to partition the array
  private static int partition (int[]arr, int low, int high)
  {
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++)
      {
	if (arr[j] < pivot)
	  {
	    i++;
	    swap (arr, i, j);
	  }
      }
    swap (arr, i + 1, high);
    return i + 1;
  }

// swap method
  private static void swap (int[]arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


// Sorts an array of integers using the merge sort algorithm.
  public static void mergeSort (int[]arr, int left, int right)
  {
    if (left < right)
      {
	// Find the middle index of the array.
	int middle = (left + right) / 2;

	// Recursively sort the left and right subarrays.
	mergeSort (arr, left, middle);
	mergeSort (arr, middle + 1, right);

	// Merge the sorted subarrays.
	merge (arr, left, middle, right);
      }
  }

// Merges two subarrays of an array of integers.

  private static void merge (int[]arr, int left, int middle, int right)
  {
    // Create temporary arrays to hold the left and right subarrays.
    int[] leftArr = new int[middle - left + 1];
    int[] rightArr = new int[right - middle];

    // Copy the elements of the original array into the temporary arrays.
    for (int i = 0; i < leftArr.length; i++)
      {
	leftArr[i] = arr[left + i];
      }

    for (int i = 0; i < rightArr.length; i++)
      {
	rightArr[i] = arr[middle + 1 + i];
      }

    // Merge the left and right subarrays into the original array.
    int i = 0, j = 0, k = left;
    while (i < leftArr.length && j < rightArr.length)
      {
	if (leftArr[i] <= rightArr[j])
	  {
	    arr[k++] = leftArr[i++];
	  }
	else
	  {
	    arr[k++] = rightArr[j++];
	  }
      }

    // Copy any remaining elements from the left or right subarrays into the original array.
    while (i < leftArr.length)
      {
	arr[k++] = leftArr[i++];
      }

    while (j < rightArr.length)
      {
	arr[k++] = rightArr[j++];
      }
  }



// main function
  public static void main (String[]args)
  {
    int[] arr = { 5, 2, 8, 3, 1, 6, 9, 7, 4 };
    System.out.println ("Original array: " + Arrays.toString (arr));


    // Sort the array using quick sort.
    quickSort (arr, 0, arr.length - 1);
    System.out.println ("Sorted array: " + Arrays.toString (arr));


    // Sort the array using merge sort.
    mergeSort (arr, 0, arr.length - 1);
    System.out.println ("Sorted array: " + Arrays.toString (arr));

  }
}


/*
OUTPUT -

Original array: [5, 2, 8, 3, 1, 6, 9, 7, 4]
Sorted array: [1, 2, 3, 4, 5, 6, 7, 8, 9]
Sorted array: [1, 2, 3, 4, 5, 6, 7, 8, 9]



*/
