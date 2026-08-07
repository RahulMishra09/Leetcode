class Solution {
    private final int[] primes = {2, 3, 5, 7};
    private final int maxPrime = primes[primes.length - 1];

    public String smallestNumber(String num, long t) {
        int[] primeCount = new int[maxPrime+1];
        int numLength = num.length();

        for (int prime : primes) {
            while (t % prime == 0) {
                t /= prime;
                primeCount[prime]++;
            }
        }

        if (t != 1) return "-1";

        int minLength = getMinLength(primeCount);

        if (numLength < minLength) {
            return buildSuffix(primeCount, minLength, new char[minLength]);
        }

        char[] result = new char[numLength + 1];
        int firstZeroIndex = 0;

        for (int i = 0; firstZeroIndex < numLength && (result[++i] = num.charAt(firstZeroIndex)) != '0'; firstZeroIndex++) {
            updatePrimeCount(primeCount, result[i], -1);
        }

        if (getMinLength(primeCount) == 0) {
            if (firstZeroIndex == numLength) return num;
            Arrays.fill(result, ++firstZeroIndex, result.length, '1');
            return new String(result, 1, numLength);
        }

        for (int last = numLength - 1, end = Math.min(firstZeroIndex, last); end >= 0; end--) {
            for (updatePrimeCount(primeCount, result[end + 1], 1); ++result[end + 1] <= '9'; updatePrimeCount(primeCount, result[end + 1], 1)) {
                updatePrimeCount(primeCount, result[end + 1], -1);
                if (getMinLength(primeCount) <= last - end) {
                    return buildSuffix(primeCount, last - end, result);
                }
            }
        }

        return buildSuffix(primeCount, result.length, result);
    }

    private void updatePrimeCount(int[] primeCount, int digit, int delta) {
        if (digit < '2') return;

        switch (digit) {
            case '9': primeCount[3] += delta * 2; break;
            case '8': primeCount[2] += delta * 3; break;
            case '7': primeCount[7] += delta; break;
            case '6': primeCount[2] += delta; primeCount[3] += delta; break;
            case '5': primeCount[5] += delta; break;
            case '4': primeCount[2] += delta * 2; break;
            case '3': primeCount[3] += delta; break;
            case '2': primeCount[2] += delta; break;
        }
    }

    private String buildSuffix(int[] primeCount, int targetLength, char[] result) {
        int index = result.length;

        while (primeCount[3] > 1) {
            primeCount[3] -= 2;
            result[--index] = '9';
        }

        while (primeCount[2] > 2) {
            primeCount[2] -= 3;
            result[--index] = '8';
        }

        while (primeCount[7]-- > 0) result[--index] = '7';

        if (primeCount[2] > 0 && primeCount[3] > 0) {
            result[--index] = '6';
            primeCount[2]--;
            primeCount[3]--;
        }

        while (primeCount[5]-- > 0) result[--index] = '5';

        while (primeCount[2] > 1) {
            primeCount[2] -= 2;
            result[--index] = '4';
        }

        while (primeCount[3] > 0) {
            primeCount[3]--;
            result[--index] = '3';
        }

        while (primeCount[2] > 0) {
            primeCount[2]--;
            result[--index] = '2';
        }

        while (index + targetLength != result.length) result[--index] = '1';

        return targetLength == result.length ? new String(result) : new String(result, 1, result.length - 1);
    }

    private int getMinLength(int[] primeCount) {
        int count2 = Math.max(0, primeCount[2]);
        int count3 = Math.max(0, primeCount[3]);
        int remaining23 = (count3 & 1) + (count2 % 3);
        int minLength = (count3 >> 1) + (count2 / 3) + Math.max(0, primeCount[7]) + Math.max(0, primeCount[5]);
        return minLength + (remaining23 == 3 ? 2 : remaining23 > 0 ? 1 : 0);
    }
}