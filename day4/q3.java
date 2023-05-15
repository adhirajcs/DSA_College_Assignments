/*

Doubly and Circular Linked List

2. Write a menu driven program to implement a doubly circular linked list with the
following operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list

*/

import java.util.Scanner;

class Node
{
  int data;
  Node next;
  Node prev;

    Node (int data)
  {
    this.data = data;
    this.next = null;
    this.prev = null;
  }
}

class DoublyCircularLinkedList
{
  Node head;

    DoublyCircularLinkedList ()
  {
    head = null;
  }

  void insertFront (int data)
  {
    Node newNode = new Node (data);
    if (head == null)
      {
	head = newNode;
	head.next = head;
	head.prev = head;
      }
    else
      {
	newNode.next = head;
	newNode.prev = head.prev;
	head.prev.next = newNode;
	head.prev = newNode;
	head = newNode;
      }
    System.out.println (data + " inserted at the front");
  }

  void insertEnd (int data)
  {
    Node newNode = new Node (data);
    if (head == null)
      {
	head = newNode;
	head.next = head;
	head.prev = head;
      }
    else
      {
	newNode.next = head;
	newNode.prev = head.prev;
	head.prev.next = newNode;
	head.prev = newNode;
      }
    System.out.println (data + " inserted at the end");
  }

  void insertAfter (int key, int data)
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    Node newNode = new Node (data);
    Node temp = head;
    do
      {
	if (temp.data == key)
	  {
	    newNode.next = temp.next;
	    newNode.prev = temp;
	    temp.next.prev = newNode;
	    temp.next = newNode;
	    System.out.println (data + " inserted after " + key);
	    return;
	  }
	temp = temp.next;
      }
    while (temp != head);
    System.out.println (key + " not found in the list");
  }

  void deleteFront ()
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    if (head.next == head)
      {
	head = null;
      }
    else
      {
	head.prev.next = head.next;
	head.next.prev = head.prev;
	head = head.next;
      }
    System.out.println ("Deleted front node");
  }

  void deleteEnd ()
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    if (head.next == head)
      {
	head = null;
      }
    else
      {
	head.prev.prev.next = head;
	head.prev = head.prev.prev;
      }
    System.out.println ("Deleted end node");
  }

  void deleteNode (int key)
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    Node temp = head;
    do
      {
	if (temp.data == key)
	  {
	    if (temp == head)
	      {
		deleteFront ();
	      }
	    else if (temp.next == head)
	      {
		deleteEnd ();
	      }
	    else
	      {
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		System.out.println ("Deleted node with key " + key);
	      }
	    return;
	  }
	temp = temp.next;
      }
    while (temp != head);
    System.out.println (key + " not found in the list");
  }

  void display ()
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    Node temp = head;
    System.out.print ("List: ");
    do
      {
	System.out.print (temp.data + " ");
	temp = temp.next;
      }
    while (temp != head);
    System.out.println ();
  }
}


// driver class
public class Main
{
  public static void main (String[]args)
  {
    DoublyCircularLinkedList list = new DoublyCircularLinkedList ();
    Scanner sc = new Scanner (System.in);
    int choice, data, key;
    do
      {
	System.out.println ("Menu:");
	System.out.println ("1. Insert at front");
	System.out.println ("2. Insert at end");
	System.out.println ("3. Insert after key");
	System.out.println ("4. Delete front");
	System.out.println ("5. Delete end");
	System.out.println ("6. Delete node");
	System.out.println ("7. Display");
	System.out.println ("8. Exit");
	System.out.print ("Enter your choice: ");
	choice = sc.nextInt ();

	switch (choice)
	  {
	  case 1:
	    System.out.print ("Enter data: ");
	    data = sc.nextInt ();
	    list.insertFront (data);
	    break;
	    case 2:System.out.print ("Enter data: ");
	    data = sc.nextInt ();
	    list.insertEnd (data);
	    break;
	    case 3:System.out.print ("Enter key: ");
	    key = sc.nextInt ();
	    System.out.print ("Enter data: ");
	    data = sc.nextInt ();
	    list.insertAfter (key, data);
	    break;
	    case 4:list.deleteFront ();
	    break;
	    case 5:list.deleteEnd ();
	    break;
	    case 6:System.out.print ("Enter key: ");
	    key = sc.nextInt ();
	    list.deleteNode (key);
	    break;
	    case 7:list.display ();
	    break;
	    case 8:System.out.println ("Exiting program");
	    break;
	    default:System.out.println ("Invalid choice, please try again");
	  }
	System.out.println ();
      }
    while (choice != 8);
  }
}


/* OUTPUT -

Menu:
1. Insert at front
2. Insert at end
3. Insert after key
4. Delete front
5. Delete end
6. Delete node
7. Display
8. Exit
Enter your choice: 1
Enter data: 34
34 inserted at the front

Menu:
1. Insert at front
2. Insert at end
3. Insert after key
4. Delete front
5. Delete end
6. Delete node
7. Display
8. Exit
Enter your choice: 2
Enter data: 54
54 inserted at the end

Menu:
1. Insert at front
2. Insert at end
3. Insert after key
4. Delete front
5. Delete end
6. Delete node
7. Display
8. Exit
Enter your choice: 3 7
List: 34 54 

Menu:
1. Insert at front
2. Insert at end
3. Insert after key
4. Delete front
5. Delete end
6. Delete node
7. Display
8. Exit
Enter your choice: 3
Enter key: 32 4
Enter data: 23
23 inserted after 34

Menu:
1. Insert at front
2. Insert at end
3. Insert after key
4. Delete front
5. Delete end
6. Delete node
7. Display
8. Exit
Enter your choice: 7
List: 34 23 54 

Menu:
1. Insert at front
2. Insert at end
3. Insert after key
4. Delete front
5. Delete end
6. Delete node
7. Display
8. Exit
Enter your choice: 6
Enter key: 54  23
Deleted node with key 23

Menu:
1. Insert at front
2. Insert at end
3. Insert after key
4. Delete front
5. Delete end
6. Delete node
7. Display
8. Exit
Enter your choice: 7
List: 34 54 

Menu:
1. Insert at front
2. Insert at end
3. Insert after key
4. Delete front
5. Delete end
6. Delete node
7. Display
8. Exit
Enter your choice: 8
Exiting program



*/

