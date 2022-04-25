package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;

    public Percolation(int N) {
        this.N = N;
    }

    public void open(int row, int col) {

    }

    /**
     * is the site (row, col) open
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isOpen(int row, int col) {
        return false;
    }

    /**
     * is the site (row, col) full?
     */
    public boolean isFull(int row, int col) {
        return false;
    }

    /**
     * number of open sites, must take constant time
     * @return
     */
    public int numberOfOpenSites() {
        return -1;
    }

    /**
     * does the system percolate?
     * @return
     */
    public boolean percolates() {
        return false;
    }

    /**
     * By convention, the row and column indices are integers between 0 and N-1.
     * where (0, 0) is the upper-left site.
     * @param row
     * @param col
     * @return whether the indices are outside the range
     */
    private boolean isIndicesValid(int row, int col){
        return false;
    }

    public static void main(String[] args) {

    }
}
