package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int N;
    private int T;
    private PercolationFactory pf;
    private double[] results;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException("Invalid N or T!");
        }
        this.N = N;
        this.T = T;
        this.pf = pf;
        results = new double[T];
        calculate();
    }

    private void calculate() {
        for (int i = 0; i < T; i++) {
            Percolation percolation = pf.make(N);
            for (int j = 0; j < N * N; j++) {
                int row = StdRandom.uniform(N);
                int col = StdRandom.uniform(N);
                percolation.open(row, col);
                if (percolation.percolates()) {
                    results[i] = (double) percolation.numberOfOpenSites() / (N * N);
                    break;
                }
            }
        }
    }

    /**
     * sample mean of percolation threshold
     */
    public double mean() {
        return StdStats.mean(results);
    }

    /**
     * sample standard deviation of percolation threshold
     *
     * @return
     */
    public double stddev() {
        return StdStats.stddev(results);
    }

    /**
     * low endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceLow() {
        return mean() - 1.96 * Math.sqrt(stddev()) / Math.sqrt(T);
    }

    /**
     * high endpoint of 95% confidence interval
     *
     * @return
     */
    public double confidenceHigh() {
        return mean() + 1.96 * Math.sqrt(stddev()) / Math.sqrt(T);
    }

    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(20, 10, new PercolationFactory());
        System.out.println(ps.mean());
    }
}
