/*

3. Write a menu driven program to implement a double ended queue using linked list.
*/


import java.util.Scanner;

// Node class to represent the elements in the Linked List
class Node
{
  int data;
  Node next;

    Node (int data)
  {
    this.data = data;
    this.next = null;
  }
}

// Deque class to implement the Double Ended Queue using Linked List
class Deque
{
  Node front, rear;

    Deque ()
  {
    this.front = null;
    this.rear = null;
  }

  // Function to check if the Deque is empty
  boolean isEmpty ()
  {
    return (front == null);
  }

  // Function to add an element to the front of the Deque
  void addFront (int data)
  {
    Node new_node = new Node (data);
    if (front == null)
      {
	front = new_node;
	rear = new_node;
      }
    else
      {
	new_node.next = front;
	front = new_node;
      }
    System.out.println ("Element " + data + " added to the front of Deque");
  }

  // Function to add an element to the rear of the Deque
  void addRear (int data)
  {
    Node new_node = new Node (data);
    if (rear == null)
      {
	front = new_node;
	rear = new_node;
      }
    else
      {
	rear.next = new_node;
	rear = new_node;
      }
    System.out.println ("Element " + data + " added to the rear of Deque");
  }

  // Function to remove an element from the front of the Deque
  void removeFront ()
  {
    if (isEmpty ())
      {
	System.out.println ("Deque is empty");
	return;
      }
    int data = front.data;
    front = front.next;
    if (front == null)
      {
	rear = null;
      }
    System.out.println ("Element " + data +
			" removed from the front of Deque");
  }

  // Function to remove an element from the rear of the Deque
  void removeRear ()
  {
    if (isEmpty ())
      {
	System.out.println ("Deque is empty");
	return;
      }
    int data = rear.data;
    Node temp = front;
    while (temp.next != rear)
      {
	temp = temp.next;
      }
    rear = temp;
    rear.next = null;
    System.out.println ("Element " + data +
			" removed from the rear of Deque");
  }

  // Function to display the elements of the Deque
  void display ()
  {
    if (isEmpty ())
      {
	System.out.println ("Deque is empty");
	return;
      }
    Node temp = front;
    while (temp != null)
      {
	System.out.print (temp.data + " ");
	temp = temp.next;
      }
    System.out.println ();
  }
}

// Main class to implement the Deque using Linked List
public class Main
{
  public static void main (String[]args)
  {
    Scanner sc = new Scanner (System.in);
    Deque dq = new Deque ();

    while (true)
      {
	System.
	  out.println
	  ("\n------- Double Ended Queue using Linked List -------");
	System.out.println ("1. Add element to the front of the Deque");
	System.out.println ("2. Add element to the rear of the Deque");
	System.out.println ("3. Remove element from the front of the Deque");
	System.out.println ("4. Remove element from the rear of the Deque");
	System.out.println ("5. Display the elements of the Deque");
	System.out.println ("6. Exit");

	System.out.print ("\nEnter your choice: ");
	int choice = sc.nextInt ();

	switch (choice)
	  {
	  case 1:
	    System.out.
	      print ("\nEnter element to add to the front of the Deque: ");
	    int data1 = sc.nextInt ();
	      dq.addFront (data1);
	      break;

	    case 2:System.out.
	      print ("\nEnter element to add to the rear of the Deque: ");
	    int data2 = sc.nextInt ();
	      dq.addRear (data2);
	      break;

	    case 3:dq.removeFront ();
	      break;

	    case 4:dq.removeRear ();
	      break;

	    case 5:dq.display ();
	      break;

	    case 6:System.exit (0);
	      break;

	    default:System.out.println ("Invalid choice");
	  }
      }
  }
}




/* OUTPUT -


------- Double Ended Queue using Linked List -------
1. Add element to the front of the Deque
2. Add element to the rear of the Deque
3. Remove element from the front of the Deque
4. Remove element from the rear of the Deque
5. Display the elements of the Deque
6. Exit

Enter your choice: 1

Enter element to add to the front of the Deque: 43
Element 43 added to the front of Deque

------- Double Ended Queue using Linked List -------
1. Add element to the front of the Deque
2. Add element to the rear of the Deque
3. Remove element from the front of the Deque
4. Remove element from the rear of the Deque
5. Display the elements of the Deque
6. Exit

Enter your choice: 1

Enter element to add to the front of the Deque: 54
Element 54 added to the front of Deque

------- Double Ended Queue using Linked List -------
1. Add element to the front of the Deque
2. Add element to the rear of the Deque
3. Remove element from the front of the Deque
4. Remove element from the rear of the Deque
5. Display the elements of the Deque
6. Exit

Enter your choice: 2

Enter element to add to the rear of the Deque: 654
Element 654 added to the rear of Deque

------- Double Ended Queue using Linked List -------
1. Add element to the front of the Deque
2. Add element to the rear of the Deque
3. Remove element from the front of the Deque
4. Remove element from the rear of the Deque
5. Display the elements of the Deque
6. Exit

Enter your choice: 5
54 43 654 

------- Double Ended Queue using Linked List -------
1. Add element to the front of the Deque
2. Add element to the rear of the Deque
3. Remove element from the front of the Deque
4. Remove element from the rear of the Deque
5. Display the elements of the Deque
6. Exit

Enter your choice: 4
Element 654 removed from the rear of Deque

------- Double Ended Queue using Linked List -------
1. Add element to the front of the Deque
2. Add element to the rear of the Deque
3. Remove element from the front of the Deque
4. Remove element from the rear of the Deque
5. Display the elements of the Deque
6. Exit

Enter your choice: 5
54 43 

------- Double Ended Queue using Linked List -------
1. Add element to the front of the Deque
2. Add element to the rear of the Deque
3. Remove element from the front of the Deque
4. Remove element from the rear of the Deque
5. Display the elements of the Deque
6. Exit

Enter your choice: 6


*/

