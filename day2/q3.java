/*

3. Write a method in a separate class to evaluate a postfix expression (Consider more than single
digit number as a input).

*/

// Stack class
class Stack {
    private int maxSize; // Maximum size of the stack
    private int[] stackArray; // Array to store stack elements
    private int top; // Top of the stack

    // Constructor to initialize the stack
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1; // Empty stack
    }

    // Method to push an element onto the stack
    public void push(int element) {
        if (top == maxSize - 1) { // Stack is full
            System.out.println("Stack overflow!");
            return;
        }
        stackArray[++top] = element; // Increment top and add element to the stack
    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == -1) { // Stack is empty
            System.out.println("Stack underflow!");
            return -1;
        }
        return stackArray[top--]; // Decrement top and return the popped element
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }
}



class PostfixEvaluation {
    // Method in a separate class to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack stack = new Stack(expression.length()); // Create a stack to store operands
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) { // If the character is a digit, push it onto the stack
                stack.push(ch - '0'); // Convert the character to its integer equivalent
            } else { // If the character is an operator, pop two operands from the stack and perform the operation
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                    case '%':
                        stack.push(operand1 % operand2);
                        break;
                    default:
                        System.out.println("Invalid operator!");
                        return -1;
                }
            }
        }
        return stack.pop(); // The final result will be the only element left on the stack
    }
}

// driver code
public class Main {
    public static void main(String[] args) {
        String postfixExpression = "23+4*"; // The postfix expression to evaluate
        int result = PostfixEvaluation.evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result); // Output: Result: 14
    }
}



/* OUTPUT -
Result: 20

*/
