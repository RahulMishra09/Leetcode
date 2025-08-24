class Solution {
    static int[] A = new int[30]; // row bitmasks
    static int[] T = new int[30]; // col bitmasks (transpose)

    // Build row/col bitmasks
    static void buildAT(int[][] grid, int n, int m) {
        Arrays.fill(A, 0);
        Arrays.fill(T, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                A[i] |= (1 << j); // set bit j in row i
                T[j] |= (1 << i); // set bit i in col j
            }
        }
    }

    // Area of bounding rectangle of 1's inside submatrix [i0..iN][j0..jN]
    static int minRect(int i0, int iN, int j0, int jN) {
        int iMin = 30, iMax = -1, jMin = 30, jMax = -1;

        // top row
        for (int i = i0; i <= iN; i++) {
            int row = A[i];
            int mask = ((row >>> j0) << j0) & ((1 << (jN + 1)) - 1);
            if (mask != 0) {
                iMin = i;
                break;
            }
        }
        if (iMin == 30) return (int) 1e8; // no 1's

        // bottom row
        for (int i = iN; i >= iMin; i--) {
            int row = A[i];
            int mask = ((row >>> j0) << j0) & ((1 << (jN + 1)) - 1);
            if (mask != 0) {
                iMax = i;
                break;
            }
        }

        // left col
        for (int j = j0; j <= jN; j++) {
            int col = T[j];
            int mask = ((col >>> i0) << i0) & ((1 << (iN + 1)) - 1);
            if (mask != 0) {
                jMin = j;
                break;
            }
        }

        // right col
        for (int j = jN; j >= jMin; j--) {
            int col = T[j];
            int mask = ((col >>> i0) << i0) & ((1 << (iN + 1)) - 1);
            if (mask != 0) {
                jMax = j;
                break;
            }
        }

        return (iMax - iMin + 1) * (jMax - jMin + 1);
    }

    public int minimumSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        buildAT(grid, n, m);

        int ans = Integer.MAX_VALUE;

        // Case 1: 2 vertical cuts
        for (int c1 = 0; c1 < m - 2; c1++) {
            for (int c2 = c1 + 1; c2 < m - 1; c2++) {
                int a = minRect(0, n - 1, 0, c1);
                int b = minRect(0, n - 1, c1 + 1, c2);
                int c = minRect(0, n - 1, c2 + 1, m - 1);
                ans = Math.min(ans, a + b + c);
            }
        }

        // Case 2: 2 horizontal cuts
        for (int r1 = 0; r1 < n - 2; r1++) {
            for (int r2 = r1 + 1; r2 < n - 1; r2++) {
                int a = minRect(0, r1, 0, m - 1);
                int b = minRect(r1 + 1, r2, 0, m - 1);
                int c = minRect(r2 + 1, n - 1, 0, m - 1);
                ans = Math.min(ans, a + b + c);
            }
        }

        // Case 3: T-shaped partitions
        for (int r = 0; r < n - 1; r++) {
            for (int c = 0; c < m - 1; c++) {
                // top, bottom-left, bottom-right
                int top = minRect(0, r, 0, m - 1);
                int bl = minRect(r + 1, n - 1, 0, c);
                int br = minRect(r + 1, n - 1, c + 1, m - 1);
                ans = Math.min(ans, top + bl + br);

                // bottom, top-left, top-right
                int bottom = minRect(r + 1, n - 1, 0, m - 1);
                int tl = minRect(0, r, 0, c);
                int tr = minRect(0, r, c + 1, m - 1);
                ans = Math.min(ans, bottom + tl + tr);

                // left, top-right, bottom-right
                int left = minRect(0, n - 1, 0, c);
                int tr2 = minRect(0, r, c + 1, m - 1);
                int br2 = minRect(r + 1, n - 1, c + 1, m - 1);
                ans = Math.min(ans, left + tr2 + br2);

                // right, top-left, bottom-left
                int right = minRect(0, n - 1, c + 1, m - 1);
                int tl2 = minRect(0, r, 0, c);
                int bl2 = minRect(r + 1, n - 1, 0, c);
                ans = Math.min(ans, right + tl2 + bl2);
            }
        }

        return ans;
    }
}
