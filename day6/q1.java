/*

1. Write functions to implement a solution to Towers of Hanoi problem. Check your
program with number of disks = 0, 1, 2 and 3.

*/


import java.util.*;


public class Main{
    public static void hanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        hanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        hanoi(n - 1, aux, to, from);
    }


    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of disks required: ");
        // number of disks
        int n = sc.nextInt();
        // A, B and C are names of rods
        hanoi(n, 'A', 'C', 'B'); 
    }
}


/*
OUTPUT -

Enter the number of disks required:-3
Move disk 1 from rod A to rod C
Move disk 2 from rod A to rod B
Move disk 1 from rod C to rod B
Move disk 3 from rod A to rod C
Move disk 1 from rod B to rod A
Move disk 2 from rod B to rod C
Move disk 1 from rod A to rod C



*/

