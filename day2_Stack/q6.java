/*

6. Write a method in a separate class to convert an infix expression to its corresponding prefix
expression.

*/

import java.util.*;

// Stack class
class Stack < T >
{
  private int top;
  private T[] stackArray;
  private int capacity;

  // Constructor
  public Stack (int capacity)
  {
    this.capacity = capacity;
    this.top = -1;
    this.stackArray = (T[])new Object[capacity];
  }

  // Push method to add an item to the stack
  public void push (T item)
  {
    if (top == capacity - 1)
      {
	System.out.println ("Stack is full!");
      }
    else
      {
	top++;
	stackArray[top] = item;
      }
  }

  // Pop method to remove and return the top item from the stack
  public T pop ()
  {
    if (top == -1)
      {
	System.out.println ("Stack is empty!");
	return null;
      }
    else
      {
	T item = stackArray[top];
	top--;
	return item;
      }
  }

  // Peek method to return the top item from the stack without removing it
  public T peek ()
  {
    if (top == -1)
      {
	System.out.println ("Stack is empty!");
	return null;
      }
    else
      {
	return stackArray[top];
      }
  }

  // Check if the stack is empty
  public boolean isEmpty ()
  {
    return (top == -1);
  }
}


// InfixToPrefixConverter class
class InfixToPrefixConverter
{

  // Method in a separate class to evaluate a postfix expression
  public static String convertToPrefix (String infixExpression)
  {

    // Reverse the infix expression
    StringBuilder reverseInfixExpression =
      new StringBuilder (infixExpression).reverse ();

    // Create an empty stack to store operators
      Stack < Character > operatorStack =
      new Stack < Character > (reverseInfixExpression.length ());

    // Create a string builder to store the prefix expression
    StringBuilder prefixExpression = new StringBuilder ();

    // Iterate through the reversed infix expression
    for (int i = 0; i < reverseInfixExpression.length (); i++)
      {
	char c = reverseInfixExpression.charAt (i);

	if (Character.isLetterOrDigit (c))
	  {

	    // If the character is a letter or digit, append it to the prefix expression
	    prefixExpression.append (c);

	  }
	else if (c == ')')
	  {

	    // If the character is a closing parenthesis, push it onto the operator stack
	    operatorStack.push (c);

	  }
	else if (c == '(')
	  {

	    // If the character is an opening parenthesis, pop operators from the stack and append them to the prefix expression until a closing parenthesis is found
	    while (!operatorStack.isEmpty () && operatorStack.peek () != ')')
	      {
		prefixExpression.append (operatorStack.pop ());
	      }
	    if (!operatorStack.isEmpty () && operatorStack.peek () == ')')
	      {
		operatorStack.pop ();
	      }
	  }
	else
	  {

	    // If the character is an operator, pop operators from the stack and append them to the prefix expression if they have higher or equal precedence, then push the current operator onto the stack
	    while (!operatorStack.isEmpty ()
		   && precedence (c) < precedence (operatorStack.peek ()))
	      {
		prefixExpression.append (operatorStack.pop ());
	      }
	    operatorStack.push (c);
	  }
      }

    // Pop any remaining operators from the stack and append them to the prefix expression
    while (!operatorStack.isEmpty ())
      {
	prefixExpression.append (operatorStack.pop ());
      }

    // Reverse the prefix expression to get the final result
    return prefixExpression.reverse ().toString ();
  }

  // Method to determine the precedence of an operator
  public static int precedence (char operator)
  {
    switch (operator)
      {
      case '+':
      case '-':
	return 1;
      case '*':
      case '/':
	return 2;
      case '^':
	return 3;
      default:
	return -1;
      }
  }
}


// driver code
class Main
{
  public static void main (String[]args)
  {
    String infixExpression = "a+b*c-(d/e+f^g*h)";
    String prefixExpression =
      InfixToPrefixConverter.convertToPrefix (infixExpression);
      System.out.println ("Infix expression: " + infixExpression);
      System.out.println ("Prefix expression: " + prefixExpression);
  }
}




/* OUTPUT -
Infix expression: a+b*c-(d/e+f^g*h)
Prefix expression: -+a*bc+/de*^fgh


*/
