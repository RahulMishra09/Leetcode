class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }
        
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int resultIndex = 0;
        
        for (int diagonal = 0; diagonal < m + n - 1; diagonal++) {
            if (diagonal % 2 == 0) {
                // Even diagonal: traverse from bottom-left to top-right
                // Start from maximum row that satisfies row + col = diagonal
                int startRow = Math.min(diagonal, m - 1);
                int startCol = diagonal - startRow;
                
                int row = startRow, col = startCol;
                while (row >= 0 && col < n) {
                    result[resultIndex++] = mat[row][col];
                    row--;
                    col++;
                }
            } else {
                // Odd diagonal: traverse from top-left to bottom-right
                // Start from minimum row that satisfies row + col = diagonal
                int startRow = Math.max(0, diagonal - n + 1);
                int startCol = diagonal - startRow;
                
                int row = startRow, col = startCol;
                while (row < m && col >= 0) {
                    result[resultIndex++] = mat[row][col];
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}