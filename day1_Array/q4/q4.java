/*
 * 
 * 4. Write class SparseMatrix to give a compressed storage representation of a sparse matrix and 
also find the transpose of the sparse matrix (from the compressed representation).
 * 
 */

class SparseMatrix {
    private int[][] matrix; // original matrix
    private int numRows; // number of rows
    private int numCols; // number of columns
    private int numNonZero; // number of non-zero elements

    // compressed representation of the matrix
    private int[] rowPtr; // row pointers
    private int[] colInd; // column indices
    private int[] values; // non-zero values

    // constructor to create a sparse matrix from a given matrix
    public SparseMatrix(int[][] matrix) {
        this.matrix = matrix;
        numRows = matrix.length;
        numCols = matrix[0].length;

        // count the number of non-zero elements in the matrix
        numNonZero = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] != 0) {
                    numNonZero++;
                }
            }
        }

        // initialize the compressed representation arrays
        rowPtr = new int[numRows + 1];
        colInd = new int[numNonZero];
        values = new int[numNonZero];

        // compute the compressed representation
        int k = 0;
        for (int i = 0; i < numRows; i++) {
            rowPtr[i] = k;
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] != 0) {
                    colInd[k] = j;
                    values[k] = matrix[i][j];
                    k++;
                }
            }
        }
        rowPtr[numRows] = k;
    }

    // method to compute the transpose of the sparse matrix
    public SparseMatrix transpose() {
        // create a new sparse matrix for the transpose
        int[][] transMatrix = new int[numCols][numRows];

        // compute the transpose
        for (int i = 0; i < numRows; i++) {
            for (int k = rowPtr[i]; k < rowPtr[i + 1]; k++) {
                int j = colInd[k];
                int val = values[k];
                transMatrix[j][i] = val;
            }
        }

        // return the transpose as a new sparse matrix
        return new SparseMatrix(transMatrix);
    }

    // helper method to print the original matrix
    void printMatrix() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Driver code
public class q4 {
    public static void main(String[] args) {
        // create a 5x5 sparse matrix with 7 non-zero elements
        int[][] matrixData = {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 5, 0, 0 },
                { 0, 0, 0, 0, 2 },
                { 0, 0, 0, 0, 0 },
                { 0, 3, 0, 4, 0 }
        };
        SparseMatrix matrix = new SparseMatrix(matrixData);

        // print the original matrix and its transpose
        System.out.println("Original matrix:");
        matrix.printMatrix();
        System.out.println("Transpose of matrix:");
        matrix.transpose().printMatrix();
    }
}

/*
 * OUTPUT -
 * Original matrix:
 * 0 0 0 0 0
 * 0 0 5 0 0
 * 0 0 0 0 2
 * 0 0 0 0 0
 * 0 3 0 4 0
 * Transpose of matrix:
 * 0 0 0 0 0
 * 0 0 0 0 3
 * 0 5 0 0 0
 * 0 0 0 0 4
 * 0 0 2 0 0
 */