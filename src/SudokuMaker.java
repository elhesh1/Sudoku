public class SudokuMaker {
   // int[] mat[];
    int N; //  num of rows                      9 in this case
    int SRN; // sqrt of N (size per grid)       3 in this case
    int K;  // num of missing digits
    public static int[][] mat;
    SudokuMaker(int N, int K) {
        this.N = N;
        this.K = K;
        double SRNd = Math.sqrt(N);
        SRN = (int) SRNd;
        mat = new int[N][N];
    }

    public void fillValues() {
        fillDiagonal();
        fillRemaining(0, SRN);
      //  removeKDigits();
    }

    public void fillDiagonal() {
        for (int i = 0; i < N; i = i + SRN) {
            fillBox(i, i);
        }
    }

    boolean unUsedInBox(int rowStart, int colStart, int num) {
        for (int i = 0; i < SRN; i++) {
            for (int j = 0; j < SRN; j++) {
                if (mat[rowStart+i][colStart + j ] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    void fillBox(int row, int col) {
        int num;
        for (int i = 0; i < SRN; i++) {
            for (int j = 0; j < SRN; j++) {
                do {
                    num = randomGenerator(N);
                } while (!unUsedInBox(row, col, num));
                mat[row + i][col + j] = num;
            }
        }
    }

    static int randomGenerator(int num) {
        return (int) Math.floor(Math.random()*num+1);
    }

    boolean CheckIfSafe(int i, int j, int num) {
        return (unUsedInRow(i,num) && unUsedInCol(j, num) && unUsedInBox(i-i%SRN, j-j%SRN, num));
    }

    boolean unUsedInRow(int i, int num) {
        for (int j = 0; j < N; j++) {
            if (mat[i][j] == num) {
                return false;
            }
        }
        return true;
    }

    boolean unUsedInCol(int j, int num) {
        for (int i = 0; i < N; i++) {
            if (mat[i][j] == num) {
                return false;
            }
        }
        return true;
    }

    boolean fillRemaining(int i, int j) {
        if ( j >= N && i < N -1) {
            i++;
            j = 0;
        }
        if (i>=N && j >= N) {
            return true;
        }
        if (i < SRN) {
            if (j < SRN) {
                j = SRN;
            }
        }
        else if ( i < N - SRN) {
            if (j== (i/SRN) *SRN) {
                j = j + SRN;
            }
        }
        else {
            if (j == N-SRN) {
                i = i + 1;
                j = 0;
                if (i > N) {
                    return true;
                }
            }
        }

        for (int num = 1; num < N; num++) {
            if (CheckIfSafe(i,j,num)) {
                mat[i][j] = num;
                if (fillRemaining(i, j + 1)) {
                    return true;
                }
                mat[i][j] = 0;
            }
        }
        return false;
    }

    public void removeKDigits(int K) {
        int count = K;
        while (count != 0) {
            int i = randomGenerator(9) - 1;
            int j = randomGenerator(9) - 1;

            if (mat[i][j] != 0) {
                count--;
                mat[i][j] = 0;
            }
        }
    }


    public static void easyTest(int newK) {
        int N = 9;
        SudokuMaker sudoku = new SudokuMaker(N,newK);
        sudoku.fillValues();
        SudokuSolver.solveBoardFast(mat);
        SudokuSolver.printBoard(mat);
        sudoku.removeKDigits(newK);

    }
}
