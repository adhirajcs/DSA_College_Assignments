/*

SDoubly and Circular Linked List
1. Write a menu driven program to implement a doubly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list

*/


import java.util.Scanner;

class DoublyLinkedList
{
  private Node head, tail;

  private class Node
  {
    int data;
    Node prev, next;

      Node (int data)
    {
      this.data = data;
      prev = null;
      next = null;
    }
  }

  DoublyLinkedList ()
  {
    head = null;
    tail = null;
  }

  // Insert at the front of the list
  void insertFront (int data)
  {
    Node newNode = new Node (data);
    if (head == null)
      {
	head = tail = newNode;
      }
    else
      {
	newNode.next = head;
	head.prev = newNode;
	head = newNode;
      }
    System.out.println (data + " inserted at the front");
  }

  // Insert at the end of the list
  void insertEnd (int data)
  {
    Node newNode = new Node (data);
    if (tail == null)
      {
	head = tail = newNode;
      }
    else
      {
	newNode.prev = tail;
	tail.next = newNode;
	tail = newNode;
      }
    System.out.println (data + " inserted at the end");
  }

  // Insert after a specified node
  void insertAfter (int key, int data)
  {
    Node newNode = new Node (data);
    Node temp = head;
    while (temp != null && temp.data != key)
      {
	temp = temp.next;
      }
    if (temp == null)
      {
	System.out.println (key + " not found in the list");
      }
    else if (temp == tail)
      {
	newNode.prev = tail;
	tail.next = newNode;
	tail = newNode;
      }
    else
      {
	newNode.prev = temp;
	newNode.next = temp.next;
	temp.next.prev = newNode;
	temp.next = newNode;
      }
    System.out.println (data + " inserted after " + key);
  }

  // Delete from the front of the list
  void deleteFront ()
  {
    if (head == null)
      {
	System.out.println ("List is empty");
      }
    else if (head == tail)
      {
	System.out.println (head.data + " deleted from the front");
	head = tail = null;
      }
    else
      {
	System.out.println (head.data + " deleted from the front");
	head = head.next;
	head.prev = null;
      }
  }

  // Delete from the end of the list
  void deleteEnd ()
  {
    if (tail == null)
      {
	System.out.println ("List is empty");
      }
    else if (head == tail)
      {
	System.out.println (tail.data + " deleted from the end");
	head = tail = null;
      }
    else
      {
	System.out.println (tail.data + " deleted from the end");
	tail = tail.prev;
	tail.next = null;
      }
  }

  // Delete a specified node
  void deleteNode (int key)
  {
    Node temp = head;
    while (temp != null && temp.data != key)
      {
	temp = temp.next;
      }
    if (temp == null)
      {
	System.out.println (key + " not found in the list");
      }
    else if (temp == head)
      {
	deleteFront ();
      }
    else if (temp == tail)
      {
	deleteEnd ();
      }
    else
      {
	System.out.println (key + " deleted from the list");
	temp.prev.next = temp.next;
	temp.next.prev = temp.prev;
      }
  }

  // Display the list
  void display ()
  {
    if (head == null)
      {
	System.out.println ("List is empty");
      }
    else
      {
	Node temp = head;
	System.out.print ("List: ");
	while (temp != null)
	  {
	    System.out.print (temp.data + " ");
	    temp = temp.next;
	  }
	System.out.println ();
      }
  }
}

// Driver class
public class Main
{
  public static void main (String[]args)
  {
    DoublyLinkedList list = new DoublyLinkedList ();
    Scanner scanner = new Scanner (System.in);
    while (true)
      {
	System.out.println ("1. Insert at front");
	System.out.println ("2. Insert at end");
	System.out.println ("3. Insert after a specified node");
	System.out.println ("4. Delete from front");
	System.out.println ("5. Delete from end");
	System.out.println ("6. Delete a specified node");
	System.out.println ("7. Display the list");
	System.out.println ("8. Exit");

	System.out.print ("Enter your choice: ");
	int choice = scanner.nextInt ();

	switch (choice)
	  {
	  case 1:
	    System.out.print ("Enter the element to insert: ");
	    int data1 = scanner.nextInt ();
	      list.insertFront (data1);
	      break;
	    case 2:System.out.print ("Enter the element to insert: ");
	    int data2 = scanner.nextInt ();
	      list.insertEnd (data2);
	      break;
	    case 3:System.out.print ("Enter the element to insert: ");
	    int data3 = scanner.nextInt ();
	      System.out.print ("Enter the key: ");
	    int key3 = scanner.nextInt ();
	      list.insertAfter (key3, data3);
	      break;
	    case 4:list.deleteFront ();
	      break;
	    case 5:list.deleteEnd ();
	      break;
	    case 6:System.out.print ("Enter the key to delete: ");
	    int key6 = scanner.nextInt ();
	      list.deleteNode (key6);
	      break;
	    case 7:list.display ();
	      break;
	    case 8:System.exit (0);
	    default:System.out.println ("Invalid choice");
	  }
	System.out.println ();
      }
  }
}


/* OUTPUT -



*/

