/*

6. Write a program to find whether a matrix is orthogonal or not. Also find the 1-norm of the
matrix.

*/

class OrthogonalMatrix {

    public static boolean isOrthogonal(double[][] matrix) {
        // Check if matrix is square
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows != columns) {
            return false;
        }

        // Check if transpose of matrix is equal to its inverse
        double[][] transpose = transpose(matrix);
        double[][] inverse = inverse(matrix);
        return isEqual(transpose, inverse);
    }

    public static double oneNorm(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double maxColumnSum = Double.MIN_VALUE;

        // Calculate the 1-norm by finding the maximum column sum
        for (int j = 0; j < columns; j++) {
            double columnSum = 0;
            for (int i = 0; i < rows; i++) {
                columnSum += Math.abs(matrix[i][j]);
            }
            if (columnSum > maxColumnSum) {
                maxColumnSum = columnSum;
            }
        }
        return maxColumnSum;
    }

    // Helper method to calculate the transpose of a matrix
    private static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] transpose = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    // Helper method to calculate the inverse of a matrix
    private static double[][] inverse(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] inverse = new double[rows][columns];
        double determinant = determinant(matrix);
        if (determinant == 0) {
            throw new ArithmeticException("Matrix is not invertible");
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                inverse[i][j] = Math.pow(-1, i + j) * determinant(subMatrix(matrix, i, j)) / determinant;
            }
        }
        return inverse;
    }

    // Helper method to calculate the determinant of a matrix
    private static double determinant(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        if (rows != columns) {
            throw new IllegalArgumentException("Matrix must be square");
        }
        if (rows == 1) {
            return matrix[0][0];
        }
        double determinant = 0;
        int sign = 1;
        for (int j = 0; j < columns; j++) {
            determinant += sign * matrix[0][j] * determinant(subMatrix(matrix, 0, j));
            sign = -sign;
        }
        return determinant;
    }

    // Helper method to calculate the submatrix formed by removing a row and a
    // column from a matrix
    private static double[][] subMatrix(double[][] matrix, int row, int column) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        double[][] submatrix = new double[rows - 1][columns - 1];
        int p = 0;
        int q = 0;
        for (int i = 0; i < rows; i++) {
            if (i == row) {
                continue;
            }
            q = 0;
            for (int j = 0; j < columns; j++) {
                if (j == column) {
                    continue;
                }
                submatrix[p][q] = matrix[i][j];
                q++;
            }
            p++;
        }
        return submatrix;
    }

    // Helper method to check if two matrices are equal
    private static boolean isEqual(double[][] matrix1, double[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        if (rows != matrix2.length || columns != matrix2[0].length) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (Math.abs(matrix1[i][j] - matrix2[i][j]) > 1e-6) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class q6 {
    public static void main(String[] args) {
        double[][] matrix1 = { { 1 / Math.sqrt(2), 1 / Math.sqrt(2) }, { -1 / Math.sqrt(2), 1 / Math.sqrt(2) } }; // orthogonal
                                                                                                                  // matrix
        double[][] matrix2 = { { 1, 2 }, { 3, 4 } }; // non-orthogonal matrix

        // Test isOrthogonal() method
        System.out.println("matrix1 is orthogonal: " + OrthogonalMatrix.isOrthogonal(matrix1)); // true
        System.out.println("matrix2 is orthogonal: " + OrthogonalMatrix.isOrthogonal(matrix2)); // false

        // Test oneNorm() method
        System.out.println("1-norm of matrix1: " + OrthogonalMatrix.oneNorm(matrix1)); // 1.0
        System.out.println("1-norm of matrix2: " + OrthogonalMatrix.oneNorm(matrix2)); // 6.0
    }
}

/*
 * OUTPUT -
 * matrix1 is orthogonal: false
 * matrix2 is orthogonal: false
 * 1-norm of matrix1: 1.414213562373095
 * 1-norm of matrix2: 6.0
 * 
 */