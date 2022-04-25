package hw2;

public class PercolationStats {
    private int N;
    private int T;
    private PercolationFactory pf;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException("Invalid N or T!");
        }
        this.N = N;
        this.T = T;
        this.pf = pf;
    }

    /**
     * sample mean of percolation threshold
     * public double mean() {
     * return -1.0;
     * }
     * <p>
     * /**
     * sample standard deviation of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return -1.0;
    }

    /**
     * low endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceLow() {
        return -1.0;
    }

    /**
     * high endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHigh() {
        return -1.0;
    }
}
