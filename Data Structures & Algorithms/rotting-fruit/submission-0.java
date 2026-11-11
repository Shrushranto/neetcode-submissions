class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int r = grid.length;
        int c = grid[0].length;
        int time = 0;
      
        int fresh = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 1){
                    fresh += 1;
                }
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] directions = {
            {0,1},{0,-1},{1,0},{-1,0}
            };

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();

            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                int rr = cur[0];
                int cc = cur[1];
                for(int[]d : directions){
                    int row = d[0] + rr;
                    int col = d[1] + cc;

                    if(row<0 || row>= grid.length 
                        || col <0 || col>=grid[0].length 
                        || grid[row][col] != 1){
                            continue;
                    }

                    grid[row][col] = 2;
                    fresh -= 1;
                    q.add(new int[]{row,col});
                }
            }
            time += 1;
        }
        return fresh == 0? time : -1;
    }
}
