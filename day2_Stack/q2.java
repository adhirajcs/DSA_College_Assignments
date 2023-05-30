/*

2. Write a method in a separate class to check an expression is valid or not.

*/

import java.util.*;

// Stack class
class Stack<T> {
    private Node<T> top;  // top node of the stack
    private int size;     // number of elements in the stack

    // Constructor to create an empty stack
    public Stack() {
        top = null;
        size = 0;
    }

    // Push an element onto the stack
    public void push(T data) {
        Node<T> newNode = new Node<>(data);  // create a new node with the given data
        newNode.next = top;                 // set the new node's next pointer to the current top node
        top = newNode;                      // set the new node as the new top node
        size++;                             // increment the size of the stack
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {                    // if the stack is empty, throw an exception
            throw new EmptyStackException();
        }
        T data = top.data;                  // get the data from the top node
        top = top.next;                     // set the top node to the next node in the stack
        size--;                             // decrement the size of the stack
        return data;                        // return the data from the popped node
    }

    // Peek at the top element of the stack
    public T peek() {
        if (isEmpty()) {                    // if the stack is empty, throw an exception
            throw new EmptyStackException();
        }
        return top.data;                    // return the data from the top node without removing it
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;                 // the stack is empty if there is no top node
    }

    // Get the size of the stack
    public int size() {
        return size;                        // return the number of elements in the stack
    }

    // Node class for the linked list implementation
    private static class Node<T> {
        private T data;                     // data stored in the node
        private Node<T> next;               // reference to the next node in the stack

        // Constructor to create a new node with the given data
        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
}


// Method in a separate class to check an expression is valid or not
class ExpressionValidator {
    public static boolean isValid(String expression) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < expression.length(); i++) {
        char ch = expression.charAt(i);
        if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
        } else if (ch == ')' || ch == '}' || ch == ']') {
            if (stack.isEmpty()) {
                return false;
            }
            char top = stack.pop();
            if ((ch == ')' && top != '(') ||
                (ch == '}' && top != '{') ||
                (ch == ']' && top != '[')) {
                return false;
            }
        }
    }
    // If there are still open brackets on the stack, the expression is invalid
    return stack.isEmpty();
    }
}

// driver code
public class Main {
    public static void main(String[] args) {
        String expression1 = "{(a+b)*(c-d)}";
        String expression2 = "{(a+b)*[c-d)}";
        boolean result1 = ExpressionValidator.isValid(expression1);
        boolean result2 = ExpressionValidator.isValid(expression2);
        System.out.println(result1); // Prints true
        System.out.println(result2); // Prints false
    }
}

/* OUTPUT -
true
false

*/
