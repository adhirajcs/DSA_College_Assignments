/*

3. Write a program to construct a Binary Search Tree (BST) and perform the following
a. Traverse the tree in preorder, inorder, postorder and levelorder
b. Count the number of nodes
c. Count the number of leaves
d. Find the height of the tree
e. Search for an item in the tree
f. Remove a node from the tree

*/



class Main
{
  class Node
  {
    int key;
    Node left, right;

    public Node (int item)
    {
      key = item;
      left = right = null;
    }
  }

  Node root;

  public Main ()
  {
    root = null;
  }

  // Inserts a new node into the tree
  public void insert (int key)
  {
    root = insertRec (root, key);
  }

  // A recursive function to insert a new key in BST
  private Node insertRec (Node root, int key)
  {
    // If the tree is empty, return a new node
    if (root == null)
      {
	root = new Node (key);
	return root;
      }

    // Otherwise, recur down the tree
    if (key < root.key)
      root.left = insertRec (root.left, key);
    else if (key > root.key)
      root.right = insertRec (root.right, key);

    // Return the unchanged node pointer
    return root;
  }

  // Performs preorder traversal of the tree
  public void preOrderTraversal (Node node)
  {
    if (node != null)
      {
	System.out.print (node.key + " ");
	preOrderTraversal (node.left);
	preOrderTraversal (node.right);
      }
  }

  // Performs inorder traversal of the tree
  public void inOrderTraversal (Node node)
  {
    if (node != null)
      {
	inOrderTraversal (node.left);
	System.out.print (node.key + " ");
	inOrderTraversal (node.right);
      }
  }

  // Performs postorder traversal of the tree
  public void postOrderTraversal (Node node)
  {
    if (node != null)
      {
	postOrderTraversal (node.left);
	postOrderTraversal (node.right);
	System.out.print (node.key + " ");
      }
  }

  // Performs level order traversal of the tree
  public void levelOrderTraversal (Node root)
  {
    int height = height (root);
    for (int i = 1; i <= height; i++)
      {
	printGivenLevel (root, i);
      }
  }

  // Prints nodes at the given level
  private void printGivenLevel (Node root, int level)
  {
    if (root == null)
      return;
    if (level == 1)
      System.out.print (root.key + " ");
    else if (level > 1)
      {
	printGivenLevel (root.left, level - 1);
	printGivenLevel (root.right, level - 1);
      }
  }

  // Returns the number of nodes in the tree
  public int countNodes (Node root)
  {
    if (root == null)
      return 0;
    else
      return (countNodes (root.left) + 1 + countNodes (root.right));
  }

  // Returns the number of leaves in the tree
  public int countLeaves (Node root)
  {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    else
      return countLeaves (root.left) + countLeaves (root.right);
  }

  // Returns the height of the tree
  public int height (Node root)
  {
    if (root == null)
      return 0;
    else
      {
	// Compute the height of each subtree
	int leftHeight = height (root.left);
	int rightHeight = height (root.right);

	// Use the larger one
	if (leftHeight > rightHeight)
	  return (leftHeight + 1);
	else
	  return (rightHeight + 1);
      }
  }

  // Searches for a given item in the tree
  public boolean search (Node root, int key)
  {
// Base Cases: root is null or key is present at root
    if (root == null || root.key == key)
      return (root != null);
    // Key is greater than root's key
    if (root.key < key)
      return search (root.right, key);

    // Key is smaller than root's key
    return search (root.left, key);
  }

// Removes a node with the given key from the tree
  public void remove (int key)
  {
    root = removeRec (root, key);
  }

// A recursive function to delete a key in BST
  private Node removeRec (Node root, int key)
  {
    // Base Case: If the tree is empty
    if (root == null)
      return root;

    // Otherwise, recur down the tree
    if (key < root.key)
      root.left = removeRec (root.left, key);
    else if (key > root.key)
      root.right = removeRec (root.right, key);

    // If key is same as root's key, then this is the node to be deleted
    else
      {
	// Node with only one child or no child
	if (root.left == null)
	  return root.right;
	else if (root.right == null)
	  return root.left;

	// Node with two children: Get the inorder successor (smallest
	// in the right subtree)
	root.key = minValue (root.right);

	// Delete the inorder successor
	root.right = removeRec (root.right, root.key);
      }

    return root;
  }

// A helper function to find the minimum value node in the tree
  private int minValue (Node root)
  {
    int minv = root.key;
    while (root.left != null)
      {
	minv = root.left.key;
	root = root.left;
      }
    return minv;
  }

  public static void main (String[]args)
  {
    Main bst = new Main ();

    // Insert nodes into the tree
    bst.insert (50);
    bst.insert (30);
    bst.insert (20);
    bst.insert (40);
    bst.insert (70);
    bst.insert (60);
    bst.insert (80);

    // Perform traversals
    System.out.println ("Preorder traversal:");
    bst.preOrderTraversal (bst.root);
    System.out.println ("\nInorder traversal:");
    bst.inOrderTraversal (bst.root);
    System.out.println ("\nPostorder traversal:");
    bst.postOrderTraversal (bst.root);
    System.out.println ("\nLevelorder traversal:");
    bst.levelOrderTraversal (bst.root);

    // Get the number of nodes
    System.out.println ("\nNumber of nodes: " + bst.countNodes (bst.root));

    // Get the number of leaves
    System.out.println ("Number of leaves: " + bst.countLeaves (bst.root));

    // Get the height of the tree
    System.out.println ("Height of the tree: " + bst.height (bst.root));

    // Search for an item in the tree
    int item = 60;
    System.out.println (item +
			(bst.search (bst.root, item) ? " is" : " is not") +
			" in the tree");

    // Remove a node from the tree
    int key = 30;
    bst.remove (key);
    System.out.println ("Node with key " + key + " removed from the tree");

    // Perform inorder traversal after removal
    System.out.println ("Inorder traversal after removal:");
    bst.inOrderTraversal (bst.root);
  }

}



/*
OUTPUT -

Preorder traversal:
50 30 20 40 70 60 80 
Inorder traversal:
20 30 40 50 60 70 80 
Postorder traversal:
20 40 30 60 80 70 50 
Levelorder traversal:
50 30 70 20 40 60 80 
Number of nodes: 7
Number of leaves: 4
Height of the tree: 3
60 is in the tree
Node with key 30 removed from the tree
Inorder traversal after removal:
20 40 50 60 70 80 


*/

