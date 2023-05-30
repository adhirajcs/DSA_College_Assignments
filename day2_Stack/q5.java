/*

5. Write a method in a separate class to convert an infix expression to its corresponding postfix
expression.

*/

import java.util.*;

// Stack class
class Stack<T> {
    private int top;
    private T[] stackArray;
    private int capacity;

    // Constructor
    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stackArray = (T[]) new Object[capacity];
    }

    // Push method to add an item to the stack
    public void push(T item) {
        if (top == capacity - 1) {
            System.out.println("Stack is full!");
        } else {
            top++;
            stackArray[top] = item;
        }
    }

    // Pop method to remove and return the top item from the stack
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            T item = stackArray[top];
            top--;
            return item;
        }
    }

    // Peek method to return the top item from the stack without removing it
    public T peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        } else {
            return stackArray[top];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }
}



// InfixToPostfixConverter class
class InfixToPostfixConverter {
    
    // Method in a separate class to evaluate a postfix expression
    public static String convertToPostfix(String infixExpression) {
        
        // Create an empty stack to store operators
        Stack<Character> operatorStack = new Stack<Character>(100);

        // Create a string builder to store the postfix expression
        StringBuilder postfixExpression = new StringBuilder();

        // Iterate through the infix expression
        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                
                // If the character is a letter or digit, append it to the postfix expression
                postfixExpression.append(c);
            } else if (c == '(') {
                
                // If the character is an opening parenthesis, push it onto the operator stack
                operatorStack.push(c);
            } else if (c == ')') {
                
                // If the character is a closing parenthesis, pop operators from the stack and append them to the postfix expression until an opening parenthesis is found
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixExpression.append(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            } else {
                
                // If the character is an operator, pop operators from the stack and append them to the postfix expression if they have higher or equal precedence, then push the current operator onto the stack
                while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek())) {
                    postfixExpression.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        // Pop any remaining operators from the stack and append them to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString();
    }

    // Method to determine the precedence of an operator
    public static int precedence(char operator) {
        switch (operator) {
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
class Main {
    public static void main(String[] args) {
        String infixExpression = "a+b*c-(d/e+f^g*h)";
        String postfixExpression = InfixToPostfixConverter.convertToPostfix(infixExpression);
        System.out.println("Infix expression: " + infixExpression);
        System.out.println("Postfix expression: " + postfixExpression);
    }
}






/* OUTPUT -
Infix expression: a+b*c-(d/e+f^g*h)
Postfix expression: abc*+de/fg^h*+-


*/
