class Solution {
    public int differenceOfSums(int n, int m) {
        // total sum of 1..n
        long totalSum = (long) n * (n + 1) / 2;

        // count of multiples of m up to n
        long countMultiples = n / m;

        // sum of multiples of m: m * (1 + 2 + ... + countMultiples)
        long sumMultiples = m * countMultiples * (countMultiples + 1L) / 2;

        // result = (not divisible sum) - (divisible sum)
        // = totalSum - 2 * sumMultiples
        long result = totalSum - 2 * sumMultiples;

        return (int) result;
    }
}