class Solution {
    private int dfs(int i, int j, int[][] grid, boolean[][] vis){
        if(i<0 || j < 0 || i>= grid.length || j>= grid[0].length || vis[i][j] == true || grid[i][j] == 0){
            return 0;
        }

        vis[i][j] = true;
        int area = 1;

        area += dfs(i + 1,j,grid,vis);
        area += dfs(i,j+1,grid,vis);
        area += dfs(i - 1,j,grid,vis);
        area += dfs(i,j-1,grid,vis);

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean [][] vis = new boolean [r][c];

        int maxArea = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    maxArea = Math.max(maxArea, dfs(i,j,grid,vis));
                }
            }
        }

        return maxArea;
    }
}
