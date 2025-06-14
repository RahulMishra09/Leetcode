class Solution {
    public double myPow(double x, int n) {
        return pow(x, (long) n); // Convert to long to handle Integer.MIN_VALUE
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return 1.0 / pow(x, -n);
        }

        if (n % 2 == 1) { // Odd exponent
            return x * pow(x * x, (n - 1) / 2);
        } else { // Even exponent
            return pow(x * x, n / 2);
        }
    }
}
