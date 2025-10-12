class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_SIZE = 31;

    private static final long[] FACTORIAL = new long[MAX_SIZE];
    private static final long[] INV_FACTORIAL = new long[MAX_SIZE];

    static {
        FACTORIAL[0] = 1;
        for (int i = 1; i < MAX_SIZE; i++) {
            FACTORIAL[i] = FACTORIAL[i - 1] * i % MOD;
        }

        INV_FACTORIAL[MAX_SIZE - 1] = modPow(FACTORIAL[MAX_SIZE - 1], MOD - 2);
        for (int i = MAX_SIZE - 1; i > 0; i--) {
            INV_FACTORIAL[i - 1] = INV_FACTORIAL[i] * i % MOD;
        }
    }

    private static long modPow(long base, int exponent) {
        long result = 1;
        for (; exponent > 0; exponent /= 2) {
            if (exponent % 2 > 0) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
        }
        return result;
    }

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        
        int[][] powerValues = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            powerValues[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                powerValues[i][j] = (int) ((long) powerValues[i][j - 1] * nums[i] % MOD);
            }
        }

        int[][][][] memo = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] matrix : memo) {
            for (int[][] row : matrix) {
                for (int[] cell : row) {
                    Arrays.fill(cell, -1);
                }
            }
        }
        
        return (int) (solve(0, m, 0, k, powerValues, memo) * FACTORIAL[m] % MOD);
    }

    private long solve(int index, int remainingSlots, int carryValue, int remainingBits, 
                       int[][] powerValues, int[][][][] memo) {
        int currentBits = Integer.bitCount(carryValue);
        
        if (currentBits + remainingSlots < remainingBits) {
            return 0;
        }
        
        if (index == powerValues.length) {
            return remainingSlots == 0 && currentBits == remainingBits ? 1 : 0;
        }
        
        if (memo[index][remainingSlots][carryValue][remainingBits] != -1) {
            return memo[index][remainingSlots][carryValue][remainingBits];
        }
        
        long totalSum = 0;
        
        for (int count = 0; count <= remainingSlots; count++) {
            int lowestBit = (carryValue + count) & 1;
            
            if (lowestBit <= remainingBits) {
                long subResult = solve(
                    index + 1, 
                    remainingSlots - count, 
                    (carryValue + count) >> 1,
                    remainingBits - lowestBit, 
                    powerValues, 
                    memo
                );
                
                totalSum = (totalSum + subResult * powerValues[index][count] % MOD 
                           * INV_FACTORIAL[count]) % MOD;
            }
        }
        
        return memo[index][remainingSlots][carryValue][remainingBits] = (int) totalSum;
    }
}