package su;

/**
 * 青蛙跳台阶问题
 *  青蛙最后一步要么是跳一步到顶 要么两步到顶
 *  则等于这两种情况之和 即有递归特性：f(n)=f(n-1)+f(n-2)
 *  类似斐波那契数列
 *  只是初始值不同 f(0)=1 f(1)=1 f(2)=2
 *  采用动态规划求解
 */
public class offer10_2 {

    /**
     * 动态规划求解
     */
    public int numWays(int n) {
        int a=1,b=1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=(a+b)%1000000007;
            a=b;
            b=sum;
        }
        return a;
    }
}
