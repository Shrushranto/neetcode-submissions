class Solution {
    private void bfs(int r, int c, char grid[][], HashSet<String> vis){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        vis.add(r + "," + c);

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for(int i=0;i<4;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr<0 || nc<0 || nr>=grid.length || nc >= grid[0].length){
                    continue;
                }

                String key = nr + "," + nc;
                if(grid[nr][nc] == '1' && !vis.contains(key)){
                    vis.add(key);
                    q.offer(new int[]{nr,nc});
                }
            }
            
        }

    }
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        HashSet<String> vis = new HashSet<>();

        int islands = 0;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                String key = r + "," + c;
                if(grid[r][c] == '1' && !vis.contains(key)){
                    bfs(r,c, grid, vis);
                    islands += 1;
                }
            }
        }

        return islands;
    }
}
