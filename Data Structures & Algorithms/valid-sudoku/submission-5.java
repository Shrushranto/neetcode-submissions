class Solution {
    public boolean isValidSudoku(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        // checking every row
        for (int i = 0; i < r; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rowSet.contains(board[i][j])) {
                    return false;
                }

                rowSet.add(board[i][j]);
            }
        }

        // checking every column
        for (int i = 0; i < c; i++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int j = 0; j < r; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (colSet.contains(board[j][i])) {
                    return false;
                }

                colSet.add(board[j][i]);
            }
        }

        // we will check every 3x3 Grid
        HashMap<Integer, HashSet<Character>> mp = new HashMap<>();
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if(board[row][col] == '.') continue;
                int key = (row / 3) * 3 + (col / 3);
                if (!mp.containsKey(key)) {
                    mp.put(key, new HashSet<>());
                }
                // if(mp.get(key).contains('.')) return continue;

                if (mp.get(key).contains(board[row][col]))
                    return false;

                mp.get(key).add(board[row][col]);
            }
        }

        return true;
    }
}
