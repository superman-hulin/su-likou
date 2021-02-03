package su;

import java.util.LinkedList;

/**
 * 机器人运动范围
 */
public class offer13 {
    /**
     * DFS求解
     *    机器人当前在(0,0)点，求该机器人可以运动的格子数  则该机器人运动方向指定为向右和向下即可
     *    剪枝条件：1.越界 2.该点已访问 3.数位和大于k
     *    由于题目求可运动的格子数 返回值为int 则dfs函数返回值也应为int
     *    则不满足剪枝条件时 返回0
     *    满足时 返回1+dfs(向右走)+dfs(向下走)
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visted=new boolean[m][n];
        return dfs(0,0,m,n,k,visted);
    }
    private int dfs(int i,int j,int m,int n,int k,boolean[][] visted){
        if(i>=m||j>=n||visted[i][j]==true||bitSum(i) + bitSum(j) > k) return 0;
        visted[i][j]=true;
        return 1+dfs(i+1,j,m,n,k,visted)+dfs(i,j+1,m,n,k,visted);

    }
    private int bitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * BFS求解
     *  通常利用队列实现广度优先遍历
     *  效率不如DFS
     */
    public int movingCount1(int m, int n, int k) {
        boolean[][] visted=new boolean[m][n];
        int[] x={0,0};
        int rs=0;
        LinkedList<int[]> queue=new LinkedList();
        queue.add(x);
        while (!queue.isEmpty()){
            int[] t=queue.poll();
            int i=t[0],j=t[1];
            if(i>=m||j>=n||bitSum(i)+bitSum(j)>k||visted[i][j]) continue;
            rs++;
            visted[i][j]=true;
            queue.add(new int[]{i+1,j});
            queue.add(new int[]{i,j+1});
        }
        return rs;

    }
}
