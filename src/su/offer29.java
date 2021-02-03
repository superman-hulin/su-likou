package su;

/**
 * 顺时针打印矩阵
 *  顺时针打印矩阵的顺序是 “从左向右、从上向下、从右向左、从下向上” 循环
 *
 */
public class offer29 {
    public int[] spiralOrder(int[][] matrix) {
        //如果矩阵为空 则返回[]
        if (matrix.length == 0) return new int[0];
        //初始化左、右、上和下边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            //从左边界往右边界走  从matrix矩阵中的上边界行取不同值
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            //如果上边界加1后要大于下边界了 则退出
            if (++t > b) break;
            //从上边界往下边界走， 从matrix矩阵中的右边界列取不同值
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            //如果右边界减1小于左边界了 则退出
            if (l > --r) break;
            //从右边界往左边界走，从matrix矩阵中的下边界行取不同值
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            //如果下边界减1后要小于上边界了 则退出
            if (t > --b) break;
            //从下边界往上边界走 从matrix矩阵中的左边界列取不同值
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            //如果左边界加1后要大于右边界了 则退出
            if (++l > r) break;
        }
        return res;
    }
}
