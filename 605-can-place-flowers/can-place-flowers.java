class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int y = 0;

        if (len < n) return false;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&(i == len - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1;
                y++; // count flowers placed
            }
        }

        return y >= n;
    }
}
