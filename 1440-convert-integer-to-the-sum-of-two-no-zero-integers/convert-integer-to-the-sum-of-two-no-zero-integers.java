class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = n - 1;
        int b = 1;

        
        while (String.valueOf(a).contains("0") || String.valueOf(b).contains("0")) {
            a--;
            b++;
        }

        return new int[]{a, b};
    }
}