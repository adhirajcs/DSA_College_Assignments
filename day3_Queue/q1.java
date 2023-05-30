package day3;

import java.util.*;

/* 1. Write a program to implement a Queue class (use a list to store the elements of the
Queue). [Implement Queue Overflow and Underflow by Exception]. Write a
method to check two Queue are carrying similar elements or not. (Repetition of the
elements are not consider) */


public class q1 {

    private List<Integer> queueList;
    private int maxSize;

    public q1(int maxSize) {
        this.maxSize = maxSize;
        queueList = new ArrayList<Integer>();
    }

    // Method to add an element to the queue
    public void enqueue(int element) throws Exception {
        if (queueList.size() == maxSize) {
            throw new Exception("Queue Overflow!");
        } else {
            queueList.add(element);
        }
    }

    // Method to remove an element from the queue
    public int dequeue() throws Exception {
        if (queueList.isEmpty()) {
            throw new Exception("Queue Underflow!");
        } else {
            return queueList.remove(0);
        }
    }

    // Method to check whether two queues have similar elements or not
    public static boolean compareQueues(q1 q1, q1 q2) {
        Set<Integer> set1 = new HashSet<Integer>(q1.queueList);
        Set<Integer> set2 = new HashSet<Integer>(q2.queueList);

        return set1.equals(set2);
    }

    // main method to test the implementation
    public static void main(String[] args) {
        q1 q1 = new q1(5);
        q1 q2 = new q1(5);

        try {
            q1.enqueue(1);
            q1.enqueue(2);
            q1.enqueue(3);

            q2.enqueue(3);
            q2.enqueue(2);
            q2.enqueue(1);

            System.out.println(compareQueues(q1, q2)); // expected output: true

            q1.enqueue(4);
            q1.enqueue(5);

            q2.enqueue(4);

            System.out.println(compareQueues(q1, q2)); // expected output: false
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

/* OUTPUT -

true
false

 */