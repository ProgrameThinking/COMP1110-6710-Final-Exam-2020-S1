package comp1110.exam;

/**
 * COMP1110 Final Exam, Question 1.3
 */
public class Q1Sudoku {
    public static final int SIDE_LENGTH = 9;

    /**
     * Solve a Sudoku puzzle.
     * A Sudoku puzzle consists of the numbers 1-9 arranged in a 9x9 grid,
     * divided into nine 3x3 subgrids.
     * In a valid solution for the puzzle, each of the numbers 1-9 appears only
     * once in each row, column and subgrid. For example, the following is a
     * valid solution:
     * -------------------------
     * | 5 8 1 | 9 4 7 | 6 3 2 |
     * | 3 7 6 | 8 1 2 | 5 9 4 |
     * | 9 2 4 | 3 5 6 | 7 8 1 |
     * -------------------------
     * | 6 5 7 | 2 8 9 | 1 4 3 |
     * | 1 3 8 | 6 7 4 | 2 5 9 |
     * | 2 4 9 | 1 3 5 | 8 7 6 |
     * -------------------------
     * | 8 9 3 | 7 6 1 | 4 2 5 |
     * | 4 6 2 | 5 9 8 | 3 1 7 |
     * | 7 1 5 | 4 2 3 | 9 6 8 |
     * -------------------------
     * <p>
     * whereas the following partial layout is not valid, because the number
     * 5 appears twice in the upper-left subgrid.
     * ---------------
     * | 5 8 1 | 3 ...
     * | 3 7 2 | 4 ...
     * | 4 5 6 | 1 ...
     * ---------------
     * |  ...  |   ...
     * <p>
     * The puzzle is specified as a 9x9 array of integers which holds the rows
     * and columns of numbers in each cell of the puzzle.
     * For example, the number in the second row and third column of the puzzle
     * is held in array element a[1][2].
     * If the setup gives zero for a number, it means that value for that cell
     * is not specified, and must be solved. In other words, zero must be
     * replaced with a number 1-9 to create a valid solution.
     * <p>
     * For example, the following is one possible setup for the valid solution
     * given above:
     * -------------------------
     * | 0 0 1 | 9 4 7 | 0 0 0 |
     * | 3 7 6 | 8 1 2 | 0 9 0 |
     * | 9 2 4 | 3 5 0 | 0 0 0 |
     * -------------------------
     * | 0 5 7 | 0 0 9 | 1 0 0 |
     * | 1 3 8 | 6 0 4 | 2 5 9 |
     * | 0 0 9 | 1 0 0 | 8 7 0 |
     * -------------------------
     * | 0 0 3 | 0 6 1 | 4 2 5 |
     * | 0 6 0 | 5 9 8 | 3 1 7 |
     * | 0 0 0 | 4 2 3 | 9 0 0 |
     * -------------------------
     * <p>
     * To solve the puzzle, each zero must be replaced with a number 1-9 so as to
     * create a valid solution.
     *
     * @param setup a 9x9 array of integers 0-9, where 0 represents a value to be solved
     * @return a valid solution for the given setup
     */
    public static int[][] solve(int[][] setup) {
        // FIXME complete this method
    	int[][] partial = setup.clone();
        if (solveSudoku(partial, 0, 0)) {
            return partial;
        } else {
            // No solution found
            return null;
        }
    }
    
    private static boolean solveSudoku(int[][] partial, int row, int col) {
        if (isFull(partial)) {
            // All rows are filled, puzzle is solved
            return true;
        }
        // Find the next empty cell
        if (col == SIDE_LENGTH) {
            col = 0;
            row++;
        }
        while (partial[row][col] != 0) {
            col++;
            if (col == SIDE_LENGTH) {
                col = 0;
                row++;
            }
            if (row == SIDE_LENGTH) {
                return true; // All rows are filled, puzzle is solved
            }
        }
        // Try placing a number in the empty cell
        for (int num = 1; num <= 9; num++) {
            if (isValidMove(partial, row, col, num)) {
                partial[row][col] = num;

                // Recursively try to solve the puzzle
                if (solveSudoku(partial, row, col + 1)) {
                    return true;
                }

                // If the current placement leads to an invalid solution, backtrack
                partial[row][col] = 0;
            }
        }

        // No valid number found, backtrack to the previous cell
        return false;
    }
    private static boolean isFull(int[][] array) {
    	for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
            	if(array[i][j]==0)
            		return false;
            }
    	}
    	return true;
    }
    private static boolean isValidMove(int[][] setup, int row, int col, int num) {
        // Check if the number is not in the same row or column
        for (int i = 0; i < SIDE_LENGTH; i++) {
            if (setup[row][i] == num || setup[i][col] == num) {
                return false;
            }
        }

        // Check if the number is not in the same 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (setup[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}