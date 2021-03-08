package su;

import java.util.ArrayList;
import java.util.List;

/**
 * 礼物的最大价值
 */
public class offer47 {
    /**
     * 方法一  超出内存限制
     *  递归每条路径 记录路径和 存于list
     */
    ArrayList<Integer> list=new ArrayList<>();
    public int maxValue(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        dfs(0,0,m,n,0,grid);
        int max=0;
        for(Integer i:list){
            if(i>=max) max=i;
        }
        return max;
    }
    void dfs(int i,int j,int m,int n,int sum,int[][] grid){
        //越界则返回
        if(i>=m||j>=n) return;
        //添加路径
        sum+=grid[i][j];
        //达到右下角时 将该路径和存入list
        if(i==m-1&&j==n-1) {
            list.add(sum);
            return;
        }
        dfs(i+1,j,m,n,sum,grid);
        dfs(i,j+1,m,n,sum,grid);
    }
    /**
     * 动态规划
     *  易得某单元格只可能从上边单元格或左边单元格到达
     *  设f(i,j)为从棋盘左上角走至单元格 (i,j)的礼物最大累计价值，易得到以下递推关系：f(i,j)等于 f(i,j−1)和 f(i−1,j)中的较大值
     *  加上当前单元格礼物价值 grid(i,j)
     *  f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
     *  则当i=j=0时 dp[i][j]=grid[i][j]
     *  当i=0,j不等于0时 dp[i][j]=dp[i][j-1]+grid[i][j]
     *  当i不等于0,j等于0时 dp[i][j]=dp[i-1][j]+grid[i][j]
     *  当i不等于0,j不等于0时 dp[i][j]=max[dp(i,j−1),dp(i−1,j)]+grid(i,j)
     *
     */
    public int maxValue1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1] ;
                else if(j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

}
