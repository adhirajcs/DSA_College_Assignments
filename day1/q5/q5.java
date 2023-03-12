/*

5. Write a Class CheckTriangular within that implement methods to check whether a matrix is
i) Lower triangular ii) Upper triangular iii) Diagonal iv) Identity v) Tridiagonal.

*/

class CheckTriangular {

    public boolean isLowerTriangular(int[][] matrix) {
        // Check if all elements above the diagonal are zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUpperTriangular(int[][] matrix) {
        // Check if all elements below the diagonal are zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDiagonal(int[][] matrix) {
        // Check if all elements off the diagonal are zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isIdentity(int[][] matrix) {
        // Check if diagonal elements are one and all other elements are zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false;
                } else if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTridiagonal(int[][] matrix) {
        // Check if elements outside the main diagonal and the two adjacent diagonals
        // are zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (Math.abs(i - j) > 1 && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

// driver class
public class q5 {

    public static void main(String[] args) {
        // Test data
        int[][] matrix1 = {
                { 1, 0, 0 },
                { 2, 3, 0 },
                { 4, 5, 6 }
        };
        int[][] matrix2 = {
                { 1, 2, 3 },
                { 0, 4, 5 },
                { 0, 0, 6 }
        };
        int[][] matrix3 = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };

        // Create an instance of CheckTriangular class
        CheckTriangular checker = new CheckTriangular();

        // Testing isLowerTriangular method
        System.out.println("matrix1 is lower triangular: " + checker.isLowerTriangular(matrix1)); // true
        System.out.println("matrix2 is lower triangular: " + checker.isLowerTriangular(matrix2)); // false
        System.out.println("matrix3 is lower triangular: " + checker.isLowerTriangular(matrix3)); // true

        // Testing isUpperTriangular method
        System.out.println("matrix1 is upper triangular: " + checker.isUpperTriangular(matrix1)); // false
        System.out.println("matrix2 is upper triangular: " + checker.isUpperTriangular(matrix2)); // true
        System.out.println("matrix3 is upper triangular: " + checker.isUpperTriangular(matrix3)); // true

        // Testing isDiagonal method
        System.out.println("matrix1 is diagonal: " + checker.isDiagonal(matrix1)); // false
        System.out.println("matrix2 is diagonal: " + checker.isDiagonal(matrix2)); // false
        System.out.println("matrix3 is diagonal: " + checker.isDiagonal(matrix3)); // true

        // Testing isIdentity method
        System.out.println("matrix1 is identity: " + checker.isIdentity(matrix1)); // false
        System.out.println("matrix2 is identity: " + checker.isIdentity(matrix2)); // false
        System.out.println("matrix3 is identity: " + checker.isIdentity(matrix3)); // true

        // Testing isTridiagonal method
        System.out.println("matrix1 is tridiagonal: " + checker.isTridiagonal(matrix1)); // false
        System.out.println("matrix2 is tridiagonal: " + checker.isTridiagonal(matrix2)); // true
        System.out.println("matrix3 is tridiagonal: " + checker.isTridiagonal(matrix3)); // true
    }
}

/*
 * OUTPUT -
 * matrix1 is lower triangular: true
 * matrix2 is lower triangular: false
 * matrix3 is lower triangular: true
 * matrix1 is upper triangular: false
 * matrix2 is upper triangular: true
 * matrix3 is upper triangular: true
 * matrix1 is diagonal: false
 * matrix2 is diagonal: false
 * matrix3 is diagonal: true
 * matrix1 is identity: false
 * matrix2 is identity: false
 * matrix3 is identity: true
 * matrix1 is tridiagonal: false
 * matrix2 is tridiagonal: false
 * matrix3 is tridiagonal: true
 * 
 */