/* 

1. Write a program to implement a Stack class (use a Array to store the elements of the stack).
[Implement Stack Overflow and Underflow by user defined Exception]. Write a method to
check two stack are carrying similar elements or not.(Repetition of the elements are not
consider)

*/

import java.util.Arrays;

// Define a custom exception class for Stack Overflow
class StackOverflowException extends Exception {
    public StackOverflowException() {
        super("Stack overflow!");
    }
}

// Define a custom exception class for Stack Underflow
class StackUnderflowException extends Exception {
    public StackUnderflowException() {
        super("Stack underflow!");
    }
}

// Define the Stack class
class Stack {
    private int[] elements; // array to store stack elements
    private int top; // index of top element in the stack
    private int capacity; // maximum number of elements that can be stored in the stack

    // Constructor to create an empty stack with a given capacity
    public Stack(int capacity) {
        elements = new int[capacity];
        top = -1;
        this.capacity = capacity;
    }

    // Method to push an element onto the stack
    public void push(int element) throws StackOverflowException {
        if (top == capacity - 1) {
            throw new StackOverflowException();
        }
        elements[++top] = element;
    }

    // Method to pop an element from the stack
    public int pop() throws StackUnderflowException {
        if (top == -1) {
            throw new StackUnderflowException();
        }
        return elements[top--];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Method to check if two stacks have similar elements
    public boolean hasSimilarElements(Stack other) {
        // Sort both stacks to make comparison easier
        Arrays.sort(elements, 0, top + 1);
        Arrays.sort(other.elements, 0, other.top + 1);
        
        // Loop through both stacks and compare their elements
        int i = 0, j = 0;
        while (i <= top && j <= other.top) {
            if (elements[i] == other.elements[j]) {
                i++;
                j++;
            } else if (elements[i] < other.elements[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        // If we reached the end of one of the stacks, but not both, then they are not similar
        if (i <= top || j <= other.top) {
            return false;
        }
        
        return true;
    }
}

// Driver code
public class q1 {
    public static void main(String[] args) {
        Stack stack1 = new Stack(5);
        Stack stack2 = new Stack(5);

        try {
            stack1.push(1);
            stack1.push(2);
            stack1.push(3);
            stack2.push(3);
            stack2.push(4);
            stack2.push(5);
        } catch (StackOverflowException e) {
            System.out.println("Stack overflow!");
        }

        boolean similar = stack1.hasSimilarElements(stack2);
        System.out.println(similar); // false
    }
}

/* OUTPUT -
false
*/