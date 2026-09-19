class Solution {
    private boolean helper(int i, int r, int c, int[][] visited, char[][] board, String word){
        if(i == word.length()){
            return true;
        }

        if(r<0 || c<0 
            || r>=board.length 
            || c>= board[0].length
            || visited[r][c] == 1
            || word.charAt(i) != board[r][c]
            
            ){

            return false;
        }
        visited[r][c] = 1;

        boolean found = 
            helper(i+1, r-1, c, visited, board, word) ||
            helper(i+1, r, c-1, visited, board, word) ||
            helper(i+1, r+1, c, visited, board, word) ||
            helper(i+1, r, c+1, visited, board, word);
        
        visited[r][c] = 0;
        
        return found;

    }
    public boolean exist(char[][] board, String word) {
        int visited[][] = new int[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(helper(0,i,j,visited,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
}
