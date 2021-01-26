package su;

/**
 * 二维数组中的查找
 */
public class offer04 {
    /**
     * 方法一：线性查找
     *      从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
     *      如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int rows=matrix.length;
        int columns=matrix[0].length;
        int row=0;
        int column=columns-1;
        while (row<rows&&column>=0){
            if(target==matrix[row][column]){
                return true;
            }
            else if (target>matrix[row][column]){
                row++;
            }else {
                column--;
            }
        }
        return false;
    }
    /**
     * 方法二：二叉搜索树
     *      矩阵逆时针旋转45度，相当于二叉树，该树具备的特点：左节点小于根节点，右节点大于根节点。
     *      则该树为二叉搜索树
     *      取左小角为起始点
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
