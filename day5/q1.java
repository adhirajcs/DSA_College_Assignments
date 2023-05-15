/*

1. Write functions for each of the following sorting techniques (show the result after each
iteration)
a. Selection
b. Insertion

*/

import java.util.*;

public class Main
{
  public static void selectionSort (int[]arr)
  {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++)
      {
	int min_idx = i;
	for (int j = i + 1; j < n; j++)
	  {
	    if (arr[j] < arr[min_idx])
	      {
		min_idx = j;
	      }
	  }
	int temp = arr[min_idx];
	arr[min_idx] = arr[i];
	arr[i] = temp;
	System.out.println (Arrays.toString (arr));	// print array after each iteration
      }
  }


  public static void insertionSort (int[]arr)
  {
    int n = arr.length;
    for (int i = 1; i < n; i++)
      {
	int key = arr[i];
	int j = i - 1;
	while (j >= 0 && arr[j] > key)
	  {
	    arr[j + 1] = arr[j];
	    j = j - 1;
	  }
	arr[j + 1] = key;
	System.out.println (Arrays.toString (arr));	// print array after each iteration
      }
  }

// main function
  public static void main (String[]args)
  {
    int[] arr = { 64, 25, 12, 22, 11 };
    selectionSort (arr);
    insertionSort (arr);

  }
}


/*
OUTPUT -

[11, 25, 12, 22, 64]
[11, 12, 25, 22, 64]
[11, 12, 22, 25, 64]
[11, 12, 22, 25, 64]
[11, 12, 22, 25, 64]
[11, 12, 22, 25, 64]
[11, 12, 22, 25, 64]
[11, 12, 22, 25, 64]


*/
