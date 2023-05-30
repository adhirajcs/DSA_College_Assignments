/*

2. Write a recursive function to find the maximum and minimum number is the given list
that solves this using divide and conquer.

*/

import java.util.Scanner;

public class Main {
    public static int[] findMaxMin(int[] arr, int start, int end) {
        int[] result = new int[2];
        
        // Base case when only one element is present
        if (start == end) { 
            
            // The maximum and minimum is the same element
            result[0] = arr[start]; 
            result[1] = arr[start];
            
            // Base case when only two elements are present
        } else if (end - start == 1) { 
            if (arr[start] > arr[end]) {
                
                // The maximum is the first element
                result[0] = arr[start]; 
                
                // The minimum is the second element
                result[1] = arr[end]; 
            } else {
                
                // The maximum is the second element
                result[0] = arr[end]; 
                
                // The minimum is the first element
                result[1] = arr[start]; 
            }
            
            // Recursive case when more than two elements are present
        } else { 
            int mid = (start + end) / 2;
            
            // Recursively find max and min in left half
            int[] leftResult = findMaxMin(arr, start, mid); 
            
            // Recursively find max and min in right half
            int[] rightResult = findMaxMin(arr, mid + 1, end); 
            if (leftResult[0] > rightResult[0]) {
                
                // The maximum is the maximum of the left half and right half
                result[0] = leftResult[0]; 
            } else {
                result[0] = rightResult[0];
            }
            if (leftResult[1] < rightResult[1]) {
                
                // The minimum is the minimum of the left half and right half
                result[1] = leftResult[1]; 
            } else {
                result[1] = rightResult[1];
            }
        }
        return result;
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the values: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] result = findMaxMin(arr, 0, arr.length - 1);
        System.out.println("Maximum number: " + result[0]);
        System.out.println("Minimum number: " + result[1]);
    }
}



/*
OUTPUT -

Enter the range: 
5
Enter the values: 
4
7
1
18
3
Maximum number: 18
Minimum number: 1



*/

