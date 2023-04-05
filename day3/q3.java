package day3;

/* 3. Write a menu driven program to implement a deque using list.
Call the two ends of the deque left and right and write four C functions, remvLeft,
remvRight, insrtLeft, insrtRight to remove and insert elements at the left and right
ends of the deque. Make sure that the routines work properly for empty deque and
that they detect overflow and underflow */



import java.util.ArrayList;
import java.util.Scanner;

public class q3 {
    ArrayList<Integer> deque = new ArrayList<Integer>();
    Scanner sc = new Scanner(System.in);

    // function to insert an element at the left end of the deque
    public void insertLeft() {
        System.out.println("Enter the element to insert at the left end:");
        int element = sc.nextInt();

        // check for overflow
        if (deque.size() == Integer.MAX_VALUE) {
            System.out.println("Deque Overflow!");
            return;
        }

        // insert element at the left end of the deque
        deque.add(0, element);
        System.out.println("Element " + element + " inserted at the left end of the deque.");
    }

    // function to insert an element at the right end of the deque
    public void insertRight() {
        System.out.println("Enter the element to insert at the right end:");
        int element = sc.nextInt();

        // check for overflow
        if (deque.size() == Integer.MAX_VALUE) {
            System.out.println("Deque Overflow!");
            return;
        }

        // insert element at the right end of the deque
        deque.add(element);
        System.out.println("Element " + element + " inserted at the right end of the deque.");
    }

    // function to remove an element from the left end of the deque
    public void removeLeft() {
        // check for underflow
        if (deque.size() == 0) {
            System.out.println("Deque Underflow!");
            return;
        }

        // remove element from the left end of the deque
        int element = deque.remove(0);
        System.out.println("Element " + element + " removed from the left end of the deque.");
    }

    // function to remove an element from the right end of the deque
    public void removeRight() {
        // check for underflow
        if (deque.size() == 0) {
            System.out.println("Deque Underflow!");
            return;
        }

        // remove element from the right end of the deque
        int element = deque.remove(deque.size() - 1);
        System.out.println("Element " + element + " removed from the right end of the deque.");
    }

    public static void main(String[] args) {
        q3 dequeObj = new q3();

        while (true) {
            // display the menu
            System.out.println("Choose an operation to perform:");
            System.out.println("1. Insert an element at the left end of the deque");
            System.out.println("2. Insert an element at the right end of the deque");
            System.out.println("3. Remove an element from the left end of the deque");
            System.out.println("4. Remove an element from the right end of the deque");
            System.out.println("5. Exit");

            int choice = dequeObj.sc.nextInt();

            switch (choice) {
                case 1:
                    dequeObj.insertLeft();
                    break;
                case 2:
                    dequeObj.insertRight();
                    break;
                case 3:
                    dequeObj.removeLeft();
                    break;
                case 4:
                    dequeObj.removeRight();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }
}


/*  OUTPUT -

Choose an operation to perform:
1. Insert an element at the left end of the deque
2. Insert an element at the right end of the deque
3. Remove an element from the left end of the deque
4. Remove an element from the right end of the deque
5. Exit
1
Enter the element to insert at the left end:
43
Element 43 inserted at the left end of the deque.
Choose an operation to perform:
1. Insert an element at the left end of the deque
2. Insert an element at the right end of the deque
3. Remove an element from the left end of the deque
4. Remove an element from the right end of the deque
5. Exit
1
Enter the element to insert at the left end:
545
Element 545 inserted at the left end of the deque.
Choose an operation to perform:
1. Insert an element at the left end of the deque
2. Insert an element at the right end of the deque
3. Remove an element from the left end of the deque
4. Remove an element from the right end of the deque
5. Exit
3
Element 545 removed from the left end of the deque.
Choose an operation to perform:
1. Insert an element at the left end of the deque
2. Insert an element at the right end of the deque
3. Remove an element from the left end of the deque
4. Remove an element from the right end of the deque
5. Exit
4
Element 43 removed from the right end of the deque.
Choose an operation to perform:
1. Insert an element at the left end of the deque
2. Insert an element at the right end of the deque
3. Remove an element from the left end of the deque
4. Remove an element from the right end of the deque
5. Exit
5

 */