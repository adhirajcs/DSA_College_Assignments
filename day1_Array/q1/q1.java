/*

1. Create a Class Search within that implement two Generic method LinearSearch(),
BinarySearch(). Test your program for different data.

*/

import java.util.*;

class Search<T> {

    // method to perform linear search on the array
    void LinearSearch(T arr[], T key) {
        int c = 0;
        // iterate over the array and check if key is present
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                c++;
                break;
            }
        }
        // print the result of the search
        if (c == 0) {
            System.out.println(key + " is not present.");
        } else {
            System.out.println(key + " is present.");
        }
    }

    // method to perform binary search on the array
    void BinarySearch(T arr[], T key) {
        // initialize left and right indices
        int left = 0, right = arr.length - 1;
        // loop until left index is less than or equal to right index
        while (left <= right) {
            // calculate the middle index
            int mid = (left + right) / 2;
            // if key is found at mid index, print the result and return
            if (key == arr[mid]) {
                System.out.println(key + " is present.");
                return;
                // if key is less than arr[mid], search the left half of the array
            } else if ((Integer) key < (Integer) arr[mid]) {
                right = mid - 1;
                // if key is greater than arr[mid], search the right half of the array
            } else {
                left = mid + 1;
            }
        }
        // if key is not found, print the result
        System.out.println(key + " is not present.");
    }
}

public class q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // create a Search object for Integer type
        Search<Integer> obj = new Search<>();

        // get input from user
        System.out.println("How many elements you want to enter: ");
        int n = sc.nextInt();
        Integer arr[] = new Integer[n];
        System.out.println("Enter the values: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the element you want to find: ");
        int key = sc.nextInt();
        // perform linear and binary search on the array
        obj.LinearSearch(arr, key);
        obj.BinarySearch(arr, key);

        sc.close();
    }

}

/*
 * OUTPUT -
 * How many elements you want to enter:
 * 5
 * Enter the values:
 * 3
 * 7
 * 8
 * 2
 * 1
 * Enter the element you want to find:
 * 7
 * 7 is present.
 * 7 is present.
 * 
 */