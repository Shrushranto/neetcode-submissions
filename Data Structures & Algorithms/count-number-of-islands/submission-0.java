class Solution {
    private void dfs(int i, int j, char[][] grid, boolean[][] vis){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] || grid[i][j] == '0'){
            return;
        }
        vis[i][j] = true;

        dfs(i+1, j, grid, vis);
        dfs(i-1, j, grid, vis); 
        dfs(i, j+1, grid, vis); 
        dfs(i, j-1, grid, vis);
    }

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] vis = new boolean[r][c];

        int islands = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    islands += 1;
                    dfs(i,j,grid,vis);
                }
            }
        }

        return islands;
    }
}
