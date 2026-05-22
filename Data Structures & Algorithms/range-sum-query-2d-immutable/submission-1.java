class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        sumMatrix = new int[r+1][c+1];
        
        for(int i=0; i<r;i++){
            int prefix = 0;
            for(int j=0; j<c; j++){
                prefix += matrix[i][j];
                int above = sumMatrix[i][j+1];
                sumMatrix[i+1][j+1] = prefix + above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = row1 + 1;
        int c1 = col1 + 1;
        int r2 = row2 + 1;
        int c2 = col2 + 1;

        int bottomArea = sumMatrix[r2][c2];
        int topArea = sumMatrix[r1 - 1][c2];
        int leftArea = sumMatrix[r2][c1-1];
        int topLeft = sumMatrix[r1 - 1][c1 - 1];

        return bottomArea - topArea - leftArea + topLeft;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */