/*

8. Write a class Polynomial to perform the following
a. Design a constructer to represent a polynomial (of single variable x).
b. Create a method to addition of polynomials.
c. Create a method to subtraction of polynomials.
d. Create a method to multiply of polynomials.
e. Create a method to find derivative of the polynomial.

*/

import java.util.Arrays;

class Polynomial {
  private int[] coefficients; // an array to store the coefficients of the polynomial

  // Constructor for Polynomial class
  public Polynomial(int[] coefficients) {
    this.coefficients = coefficients;
  }

  // Method to add two polynomials
  public Polynomial add(Polynomial other) {
    int[] resultCoefficients = new int[Math.max(this.coefficients.length, other.coefficients.length)];
    for (int i = 0; i < this.coefficients.length; i++) {
      resultCoefficients[i] += this.coefficients[i];
    }
    for (int i = 0; i < other.coefficients.length; i++) {
      resultCoefficients[i] += other.coefficients[i];
    }
    return new Polynomial(resultCoefficients);
  }

  // Method to subtract two polynomials
  public Polynomial subtract(Polynomial other) {
    int[] resultCoefficients = new int[Math.max(this.coefficients.length, other.coefficients.length)];
    for (int i = 0; i < this.coefficients.length; i++) {
      resultCoefficients[i] += this.coefficients[i];
    }
    for (int i = 0; i < other.coefficients.length; i++) {
      resultCoefficients[i] -= other.coefficients[i];
    }
    return new Polynomial(resultCoefficients);
  }

  // Method to multiply two polynomials
  public Polynomial multiply(Polynomial other) {
    int[] resultCoefficients = new int[this.coefficients.length + other.coefficients.length - 1];
    for (int i = 0; i < this.coefficients.length; i++) {
      for (int j = 0; j < other.coefficients.length; j++) {
        resultCoefficients[i + j] += this.coefficients[i] * other.coefficients[j];
      }
    }
    return new Polynomial(resultCoefficients);
  }

  // Method to find the derivative of a polynomial
  public Polynomial derivative() {
    int[] resultCoefficients = new int[this.coefficients.length - 1];
    for (int i = 1; i < this.coefficients.length; i++) {
      resultCoefficients[i - 1] = this.coefficients[i] * i;
    }
    return new Polynomial(resultCoefficients);
  }

  public int[] getCoefficients() {
    return coefficients;
  }
}

public class q8 {
  public static void main(String[] args) {
    int[] coefficients1 = { 2, 4, 3 }; // represents 2x^2 + 4x + 3
    int[] coefficients2 = { 3, 2, 1 }; // represents 3x^2 + 2x + 1

    Polynomial polynomial1 = new Polynomial(coefficients1);
    Polynomial polynomial2 = new Polynomial(coefficients2);

    // Example usage of Polynomial methods
    Polynomial sum = polynomial1.add(polynomial2);
    Polynomial difference = polynomial1.subtract(polynomial2);
    Polynomial product = polynomial1.multiply(polynomial2);
    Polynomial derivative = polynomial1.derivative();

    // Output the results
    System.out.println("Polynomial 1: " + Arrays.toString(coefficients1));
    System.out.println("Polynomial 2: " + Arrays.toString(coefficients2));
    System.out.println("Sum: " + Arrays.toString(sum.getCoefficients()));
    System.out.println("Difference: " +
        Arrays.toString(difference.getCoefficients()));
    System.out.println("Product: " +
        Arrays.toString(product.getCoefficients()));
    System.out.println("Derivative of polynomial 1: " +
        Arrays.toString(derivative.getCoefficients()));

  }
}

/*
 * OUTPUT -
 * Polynomial 1: [2, 4, 3]
 * Polynomial 2: [3, 2, 1]
 * Sum: [5, 6, 4]
 * Difference: [-1, 2, 2]
 * Product: [6, 16, 19, 10, 3]
 * Derivative of polynomial 1: [4, 6]
 * 
 * 
 */
