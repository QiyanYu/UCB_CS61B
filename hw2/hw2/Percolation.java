package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int N;
    private final int TOP;
    private final int BOTTOM;
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private boolean[][] openedRecord;
    private int openedNum;

    public Percolation(int N) {
        this.N = N;
        TOP = N * N;
        BOTTOM = TOP + 1;
        weightedQuickUnionUF = new WeightedQuickUnionUF(N * N + 2);
        openedRecord = new boolean[N][N];
        openedNum = 0;
        setDefaultOpenedRecord();
        connectWholeRow(TOP, 0);
        connectWholeRow(BOTTOM, N - 1);
    }

    /**
     * open the site (row, col) if ti is not open
     *
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        if (!isIndicesValid(row, col)) {
            throw new java.lang.IndexOutOfBoundsException("Invalid row or col!");
        }
        if (isOpen(row, col)) {
            return;
        }
        openedRecord[row][col] = true;
        openedNum++;
        // check adjacent spaces whether is opened
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int newR = row + direction[0];
            int newC = col + direction[1];
            if (isIndicesValid(newR, newC) && openedRecord[newR][newC]) {
                weightedQuickUnionUF.union(xyTO1D(row, col), xyTO1D(newR, newC));
            }
        }
    }

    /**
     * is the site (row, col) open
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        if (!isIndicesValid(row, col)) {
            throw new java.lang.IndexOutOfBoundsException("Invalid row or col!");
        }
        return openedRecord[row][col];
    }

    /**
     * is the site (row, col) full?
     */
    public boolean isFull(int row, int col) {
        if (!isIndicesValid(row, col)) {
            throw new java.lang.IndexOutOfBoundsException("Invalid row or col!");
        }
        return weightedQuickUnionUF.connected(TOP, xyTO1D(row, col)) && isOpen(row, col);
    }

    /**
     * number of open sites, must take constant time
     *
     * @return
     */
    public int numberOfOpenSites() {
        return openedNum;
    }

    /**
     * does the system percolate?
     *
     * @return
     */
    public boolean percolates() {
        return weightedQuickUnionUF.connected(TOP, BOTTOM);
    }


    private void setDefaultOpenedRecord() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                openedRecord[i][j] = false;
            }
        }
    }

    private void connectWholeRow(int x, int row) {
        for (int i = 0; i < N; i++) {
            weightedQuickUnionUF.union(x, xyTO1D(row, i));
        }
    }

    private int xyTO1D(int row, int col) {
        return row * N + col;
    }

    /**
     * By convention, the row and column indices are integers between 0 and N-1.
     * where (0, 0) is the upper-left site.
     *
     * @param row
     * @param col
     * @return whether the indices are outside the range
     */
    private boolean isIndicesValid(int row, int col) {
        return (row >= 0 && row < N) && (col >= 0 && col < N);
    }

    public static void main(String[] args) {

    }
}
