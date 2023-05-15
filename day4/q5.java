/*

2. Write a program to implement a queue using linked list, such that the operations
‘enqueue’ and ‘dequeue’ are performed in constant time.

*/


class Node {
    int data; // data stored in the node
    Node next; // pointer to the next node in the linked list

    public Node(int data) {
        this.data = data; // set the data for the node
        this.next = null; // initialize the next pointer to null
    }
}

class Queue {
    private Node front, rear; // pointers to the front and rear of the queue

    public Queue() {
        this.front = null; // initialize the front pointer to null
        this.rear = null; // initialize the rear pointer to null
    }

    public void enqueue(int data) {
        Node newNode = new Node(data); // create a new node with the given data
        if (rear == null) { // if the queue is empty
            front = newNode; // set both front and rear pointers to the new node
            rear = newNode;
        } else {
            rear.next = newNode; // set the current rear's next pointer to the new node
            rear = newNode; // set the rear pointer to the new node
        }
    }

    public int dequeue() {
        if (isEmpty()) { // check if the queue is empty
            System.out.println("Queue underflow!"); // print an error message
            return -1; // return a default value
        }
        int dequeued = front.data; // store the data from the front node
        if (front == rear) { // if there's only one element in the queue
            front = null; // set both front and rear pointers to null
            rear = null;
        } else {
            front = front.next; // move the front pointer to the next node
        }
        return dequeued; // return the dequeued data
    }

    public boolean isEmpty() {
        return front == null; // check if the front pointer is null
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(); // create a new queue
        queue.enqueue(1); // enqueue some elements into the queue
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // prints 1
        System.out.println(queue.dequeue()); // prints 2
        System.out.println(queue.dequeue()); // prints 3
        System.out.println(queue.dequeue()); // prints "Queue underflow!"
    }
}


/* OUTPUT -

1
2
3
Queue underflow!
-1


*/

