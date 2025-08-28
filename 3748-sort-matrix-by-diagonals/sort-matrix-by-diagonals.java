class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int k = 0; i + k < n; k++) {
                temp.add(grid[i + k][k]);
            }
            Collections.sort(temp, Collections.reverseOrder());
            for (int k = 0; i + k < n; k++) {
                grid[i + k][k] = temp.get(k);
            }
        }
        
        
        for (int i = 1; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int k = 0; i + k < n; k++) {
                temp.add(grid[k][i + k]);
            }
            Collections.sort(temp);
            for (int k = 0; i + k < n; k++) {
                grid[k][i + k] = temp.get(k);
            }
        }
        
        return grid;
    }
}