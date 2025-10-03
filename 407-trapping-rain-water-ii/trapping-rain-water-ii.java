class Solution {
    public int trapRainWater(int[][] heightMap) {
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        
        if (rows < 3 || cols < 3) return 0;
        
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);
        
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    minHeap.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        
        int totalWater = 0;
        int currentLevel = 0;
        
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            currentLevel = Math.max(currentLevel, cell.height);
            
     
            for (int[] dir : directions) {
                int newRow = cell.row + dir[0];
                int newCol = cell.col + dir[1];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                    && !visited[newRow][newCol]) {

                    if (currentLevel > heightMap[newRow][newCol]) {
                        totalWater += currentLevel - heightMap[newRow][newCol];
                    }
                    
                   
                    minHeap.offer(new Cell(newRow, newCol, heightMap[newRow][newCol]));
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        return totalWater;
    }
}

class Cell {
    int row;
    int col;
    int height;
    
    Cell(int r, int c, int h) {
        row = r;
        col = c;
        height = h;
    }
}