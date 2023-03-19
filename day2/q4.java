/*

4. Write a method in a separate class to evaluate a prefix expression. (Consider more than single
digit number as a input)

*/

// Stack class
class Stack {
    private int top;
    private int[] stackArray;
    private int capacity;

    // Constructor
    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stackArray = new int[capacity];
    }

    // Push method to add an item to the stack
    public void push(int item) {
        if (top == capacity - 1) {
            System.out.println("Stack is full!");
        } else {
            top++;
            stackArray[top] = item;
        }
    }

    // Pop method to remove and return the top item from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            int item = stackArray[top];
            top--;
            return item;
        }
    }

    // Peek method to return the top item from the stack without removing it
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }
}


// EvaluatePrefixExpression class
class EvaluatePrefixExpression {
    // Method in a separate class to evaluate a prefix expression
    public static int evaluatePrefixExpression(String expression) {
        Stack stack = new Stack(expression.length());

        // Iterate through the expression from right to left
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                // If the character is a digit, push it onto the stack
                stack.push(c - '0');
            } else {
                // If the character is an operator, pop two operands from the stack and apply the operator
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (c) {
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
                }
            }
        }

        // The final result will be the top item in the stack
        return stack.pop();
    }
}



// driver code
class Main {
    public static void main(String[] args) {
        String prefixExpression = "*+23*549";
        int result = EvaluatePrefixExpression.evaluatePrefixExpression(prefixExpression);
        System.out.println("Result of prefix expression " + prefixExpression + " is " + result);
    }
}



/* OUTPUT -
Result of prefix expression *+23*549 is 100

*/
