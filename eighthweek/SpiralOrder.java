/*
1 2 3
4 5 6
7 8 9
*/

// 12   36   98   74   5

//the level number is the (Math.min(rows, cols) + 1) / 2
// every level, the lastRow = rows - 1 - i
//every level, the lastCol = cols - 1 - i

//for the next level, rows -2 and cols - 2, here the starting point is represented by i and the ending point represented by lastRow and lastCol


public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return ret;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int level = (Math.min(rows, cols) + 1) / 2;
        int j = 0;
        for (int i = 0; i < level; i++) {
            int lastRow = rows - 1 - i;
            int lastCol = cols - 1 - i;
            
            if (lastRow == i) {
                //only one row left
                for (int j = i; j <= lastCol; j++) {
                    ret.add(matrix[i][j]);
                }
            } else if (lastCol == i) {
                //only one col left
                for (int j = i; j <= lastRow; j++) {
                    ret.add(matrix[j][i]);
                }
            } else {
                for (int j = i; j < lastCol; j++) {
                    ret.add(matrix[i][j]);
                }
                
                for (int j = i; j < lastRow; j++) {
                    ret.add(matrix[j][lastCol]);
                }
                
                for (int j = lastCol; j > i; j--) {
                    ret.add(matrix[lastRow][j]);
                }
                
                for (int j = lastRow; j > i; j--) {
                    ret.add(matrix[j][i]);
                }
            }
        }
        
        return ret;
    }
}
