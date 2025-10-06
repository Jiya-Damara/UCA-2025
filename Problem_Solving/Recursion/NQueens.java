public class NQueens {
    /**
     * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
     * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     *
     * Example:
     * Input n = 4
     * Output: 2
     * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
     *
     * [
     *   [".Q..",  // Solution 1
     *    "...Q",
     *    "Q...",
     *    "..Q."],
     *   ["..Q.",  // Solution 2
     *    "Q...",
     *    "...Q",
     *    ".Q.."
     *    ]
     * ]
     *
     * Constraints:
     * 1. 1 <= n <= 9
     * 2. You may assume that n is a positive integer.
     *
     * @param n - The size of the chessboard and the number of queens to place.
     * @returns int - The number of distinct solutions to the n-queens puzzle.
     **/
    public int totalNQueens(int n) {
        boolean[] checkRow = new boolean[n];
        boolean[] checkUpperDiag = new boolean[2 * n - 1];
        boolean[] checkLowerDiag = new boolean[2 * n - 1];

        return backtracking(0, n, checkRow, checkUpperDiag, checkLowerDiag);
    }

    public int backtracking(int col, int n, boolean[] checkRow, boolean[] checkUpperDiag, boolean[] checkLowerDiag) {
        if (col == n) {
            return 1;
        }

        int count = 0;
        for (int row = 0; row < n; row++) {
            if (!checkRow[row] && !checkUpperDiag[(n - 1) + (col - row)] && !checkLowerDiag[row + col]) {
                checkRow[row] = true;
                checkUpperDiag[(n - 1) + (col - row)] = true;
                checkLowerDiag[row + col] = true;

                count += backtracking(col + 1, n, checkRow, checkUpperDiag, checkLowerDiag);

                checkRow[row] = false;
                checkUpperDiag[(n - 1) + (col - row)] = false;
                checkLowerDiag[row + col] = false;
            }
        }
        return count;
    }

    /**
     * Main method for testing the NQueens class.
     */
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        assert nQueens.totalNQueens(4) == 2 : "Test case 1 failed";
        assert nQueens.totalNQueens(1) == 1 : "Test case 2 failed";
        assert nQueens.totalNQueens(5) == 10 : "Test case 3 failed";
    }
}
