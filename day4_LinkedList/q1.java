/*

Singly Linked List
1. Write a menu driven program to implement a singly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists

*/


import java.util.Scanner;

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

class LinkedList
{
  Node head;

    LinkedList ()
  {
    head = null;
  }

  void insertFront (int data)
  {
    Node newNode = new Node (data);
    newNode.next = head;
    head = newNode;
  }

  void insertEnd (int data)
  {
    Node newNode = new Node (data);
    if (head == null)
      {
	head = newNode;
	return;
      }
    Node last = head;
    while (last.next != null)
      last = last.next;
    last.next = newNode;
  }

  void insertAfter (int key, int data)
  {
    Node newNode = new Node (data);
    Node curr = head;
    while (curr != null && curr.data != key)
      curr = curr.next;
    if (curr == null)
      {
	System.out.println (key + " not found in the list");
	return;
      }
    newNode.next = curr.next;
    curr.next = newNode;
  }

  void insertPos (int pos, int data)
  {
    Node newNode = new Node (data);
    if (pos == 1)
      {
	newNode.next = head;
	head = newNode;
	return;
      }
    Node prev = head;
    for (int i = 1; i < pos - 1 && prev != null; i++)
      prev = prev.next;
    if (prev == null)
      {
	System.out.println ("Invalid position");
	return;
      }
    newNode.next = prev.next;
    prev.next = newNode;
  }

  void deleteFront ()
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    head = head.next;
  }

  void deleteEnd ()
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    if (head.next == null)
      {
	head = null;
	return;
      }
    Node last = head, prev = null;
    while (last.next != null)
      {
	prev = last;
	last = last.next;
      }
    prev.next = null;
  }

  void deleteKey (int key)
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    if (head.data == key)
      {
	head = head.next;
	return;
      }
    Node curr = head, prev = null;
    while (curr != null && curr.data != key)
      {
	prev = curr;
	curr = curr.next;
      }
    if (curr == null)
      {
	System.out.println (key + " not found in the list");
	return;
      }
    prev.next = curr.next;
  }

  void deletePos (int pos)
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    if (pos == 1)
      {
	head = head.next;
	return;
      }
    Node curr = head, prev = null;
    for (int i = 1; i < pos && curr != null; i++)
      {
	prev = curr;
	curr = curr.next;
      }
    if (curr == null)
      {
	System.out.println ("Invalid position");
	return;
      }
    prev.next = curr.next;
  }

  void display ()
  {
    if (head == null)
      {
	System.out.println ("List is empty");
	return;
      }
    Node curr = head;
    while (curr != null)
      {
	System.out.print (curr.data + " ");
	curr = curr.next;
      }
    System.out.println ();
  }

  boolean search (int key)
  {
    Node curr = head;
    while (curr != null)
      {
	if (curr.data == key)
	  return true;
	curr = curr.next;
      }
    return false;
  }

  int countNodes ()
  {
    int count = 0;
    Node curr = head;
    while (curr != null)
      {
	count++;
	curr = curr.next;
      }
    return count;
  }

  void reverse ()
  {
    Node prev = null, curr = head, next = null;
    while (curr != null)
      {
	next = curr.next;
	curr.next = prev;
	prev = curr;
	curr = next;
      }
    head = prev;
  }

  void concatenate (LinkedList list)
  {
    if (head == null)
      {
	head = list.head;
	return;
      }
    Node curr = head;
    while (curr.next != null)
      curr = curr.next;
    curr.next = list.head;
  }
}


// Driver class
public class Main
{
  public static void main (String[]args)
  {
    Scanner sc = new Scanner (System.in);
    LinkedList list = new LinkedList ();
    LinkedList list2 = new LinkedList ();
    int choice, data, pos, key;
    do
      {
	System.out.println ("1. Insert at front");
	System.out.println ("2. Insert at end");
	System.out.println ("3. Insert after a specified element");
	System.out.println ("4. Insert at a specified position");
	System.out.println ("5. Delete from front");
	System.out.println ("6. Delete from end");
	System.out.println ("7. Delete a specified element");
	System.out.println ("8. Delete from a specified position");
	System.out.println ("9. Display");
	System.out.println ("10. Search");
	System.out.println ("11. Count nodes");
	System.out.println ("12. Reverse the list");
	System.out.println ("13. Concatenate two lists");
	System.out.println ("0. Exit");
	System.out.print ("Enter your choice: ");
	choice = sc.nextInt ();
	switch (choice)
	  {
	  case 1:
	    System.out.print ("Enter the data: ");
	    data = sc.nextInt ();
	    list.insertFront (data);
	    break;
	    case 2:System.out.print ("Enter the data: ");
	    data = sc.nextInt ();
	    list.insertEnd (data);
	    break;
	    case 3:System.out.print ("Enter the key: ");
	    key = sc.nextInt ();
	    System.out.print ("Enter the data: ");
	    data = sc.nextInt ();
	    list.insertAfter (key, data);
	    break;
	    case 4:System.out.print ("Enter the position: ");
	    pos = sc.nextInt ();
	    System.out.print ("Enter the data: ");
	    data = sc.nextInt ();
	    list.insertPos (pos, data);
	    break;
	    case 5:list.deleteFront ();
	    break;
	    case 6:list.deleteEnd ();
	    break;
	    case 7:System.out.print ("Enter the key: ");
	    key = sc.nextInt ();
	    list.deleteKey (key);
	    break;
	    case 8:System.out.print ("Enter the position: ");
	    pos = sc.nextInt ();
	    list.deletePos (pos);
	    break;
	    case 9:list.display ();
	    break;
	    case 10:System.out.print ("Enter the key: ");
	    key = sc.nextInt ();
	    if (list.search (key))
	      System.out.println (key + " found in the list");
	    else
	      System.out.println (key + " not found in the list");
	    break;
	    case 11:System.out.println ("Number of nodes: " + list.countNodes ());
	    break;
	    case 12:list.reverse ();
	    break;
	    case 13:System.out.
	      println ("Enter the elements of the second list (0 to stop): ");
	    data = sc.nextInt ();
	    while (data != 0)
	      {
		list2.insertEnd (data);
		data = sc.nextInt ();
	      }
	    list.concatenate (list2);
	    break;
	  case 0:
	    System.out.println ("Exiting...");
	    break;
	  default:
	    System.out.println ("Invalid choice!");
	    break;
	  }
	System.out.println ();
      }
    while (choice != 0);
    sc.close ();
  }
}


/* OUTPUT -

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 1
Enter the data: 45

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 2
Enter the data: 54

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 2
Enter the data: 76

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 3
Enter the key: 76
Enter the data: 9

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 9
45 54 76 9 

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 10
Enter the key: 54
54 found in the list

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 11
Number of nodes: 4

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 9
45 54 76 9 

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 12

1. Insert at front
2. Insert at end
3. Insert after a specified element
4. Insert at a specified position
5. Delete from front
6. Delete from end
7. Delete a specified element
8. Delete from a specified position
9. Display
10. Search
11. Count nodes
12. Reverse the list
13. Concatenate two lists
0. Exit
Enter your choice: 13
Enter the elements of the second list (0 to stop): 


*/

