/*

1. Write a program to implement a stack using linked list, such that the operations ‘push’
and ‘pop’ are performed in constant time.

*/

class Node {
    int data;  // data stored in the node
    Node next;  // pointer to the next node in the linked list

    public Node(int data) {
        this.data = data;  // set the data for the node
        this.next = null;  // initialize the next pointer to null
    }
}

class Stack {
    private Node top;  // pointer to the top of the stack

    public Stack() {
        this.top = null;  // initialize the top pointer to null
    }

    public void push(int data) {
        Node newNode = new Node(data);  // create a new node with the given data
        newNode.next = top;  // set the new node's next pointer to the current top
        top = newNode;  // set the top pointer to the new node
    }

    public int pop() {
        if (isEmpty()) {  // check if the stack is empty
            System.out.println("Stack underflow!");  // print an error message
            return -1;  // return a default value
        }
        int popped = top.data;  // store the data from the top node
        top = top.next;  // move the top pointer to the next node
        return popped;  // return the popped data
    }

    public boolean isEmpty() {
        return top == null;  // check if the top pointer is null
    }
}

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();  // create a new stack
        stack.push(1);  // push some elements onto the stack
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // prints 3
        System.out.println(stack.pop()); // prints 2
        System.out.println(stack.pop()); // prints 1
        System.out.println(stack.pop()); // prints "Stack underflow!"
    }
}


/* OUTPUT -

3
2
1
Stack underflow!
-1


*/

