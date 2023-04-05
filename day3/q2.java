package day3;

/* 2. Write a menu driven program to implement a circular queue (use an array to store
the elements of the queue).
You can follow any one of the schemes A circular list with front and rear indices and
one position left vacant. Or, A circular list with front and rear indices and an integer
variable counting entries */


import java.util.Scanner;

public class q2 {

    private int[] queue;
    private int front, rear, size;

    public q2(int size) {
        this.size = size;
        queue = new int[size];
        front = rear = -1;
    }

    // Method to check whether the queue is empty or not
    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    // Method to check whether the queue is full or not
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Method to add an element to the queue
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else if (isEmpty()) {
            front = rear = 0;
            queue[rear] = element;
        } else {
            rear = (rear + 1) % size;
            queue[rear] = element;
        }
    }

    // Method to remove an element from the queue
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else if (front == rear) {
            System.out.println("Element removed: " + queue[front]);
            front = rear = -1;
        } else {
            System.out.println("Element removed: " + queue[front]);
            front = (front + 1) % size;
        }
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(queue[i] + " ");
                i = (i + 1) % size;
            }
            System.out.println(queue[rear]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the circular queue: ");
        int size = sc.nextInt();

        q2 cq = new q2(size);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = sc.nextInt();
                    cq.enqueue(element);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    cq.display();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}


/* OUTPUT -

Enter the size of the circular queue: 5

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
1
Enter the element to enqueue: 10

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
1
Enter the element to enqueue: 20

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
1
Enter the element to enqueue: 30

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
1
Enter the element to enqueue: 40

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
1
Enter the element to enqueue: 50

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
3
10 20 30 40 50

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
2
Element removed: 10

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
10
Invalid choice!

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
3
20 30 40 50

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
1
Enter the element to enqueue: 60

Choose an option:
1. Enqueue
2. Dequeue
3. Display
4. Exit
1
Enter the element to enqueue: 70
Queue is full!   

Choose an option:
1. Enqueue       
2. Dequeue       
3. Display       
4. Exit
3
20 30 40 50 60   

Choose an option:
1. Enqueue       
2. Dequeue       
3. Display       
4. Exit
4

 */