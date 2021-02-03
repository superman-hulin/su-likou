package su;

import java.util.HashMap;
import java.util.Map;

/**
 * 剪绳子
 */
public class offer14_1 {
    /**
     * 方法一：利用数学推导 得出如何切分最优
     *     设将绳子分为a段 则n=n1+n2+...na  求n1*n2*...na最大值
     *     易想到均值不等式 即当且仅当n1=n2=...=na时 该乘积最大  则每段长度x*a=n
     *     乘积为x^a=x^(n/x)  则求导得出x取3时 该乘积值最大
     *     也就是说前面的绳子尽可能按照长度3分割 当最后不足3时 对最后部分进行不同策略分割
     *     如剩2 则不动  如剩1 则将前一段的3分为2+1 因为2*2>3*1
     * @param n
     * @return
     */
    //借助math库进行累积
    public int cuttingRope(int n){
        if(n <= 3) return n - 1; //题目要求段数m>1 则n=3时 也必须拆
        int a = n / 3, b = n % 3; //求出最多包含多少个3 以及最后一段长度
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
    //使用while循环做累积 更推荐
    public int cuttingRope1(int n){
        if(n < 4){
            return n - 1;
        }else if(n == 4){
            return n;
        }
        long res = 1;
        //每次剪长度3
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        //剩余长度小于等于4时 则直接乘以n
        return (int) (res*n);
    }

    /**
     *方法二：递归
     *    一般直接递归会超时 需要记忆递归 保存计算的重复值
     *    假设F(n)为乘积最大值 现在第一段长度为i 则剩余部分有两种情况：不剪 则乘积为i*(n-i)  继续剪 则乘积为i*F(n-i)
     *    需要比较上述两种情况谁更大
     *
     */
    public int cuttingRope2(int n) {
        if(n<=2) return 1;
        int rs=0;
        //该处for循环穷举了剪绳子的所有情形
        //如i为2时 代表第一段长度为2 那么剩余部分该如何剪 通过递归得出 递归时会穷举当前第一段为2时 剩余部分所有剪的情形
        //i为3时 再递归穷举当前第一段为3时 剩余部分所有剪的情形  并和第一段为2时的最大乘积做对比
        for(int i = 2; i < n; i++){
            rs = Math.max(rs, Math.max(i * cuttingRope(n-i), i * (n-i)));
        }
        return rs;
    }

    /**
     * 方法三：记忆递归
     *    假设n取4 则F(4)=max(1*F(3),2*F(2),3*F(1))  而F(3)=max(1*F(2),2*F(1))
     *    则F(2)、F（1）都会重复计算 则需要将这些值存起来
     */
    public int cuttingRope3(int n) {
        int[] memo = new int[n+1];
        memo[2] = 1;
        return F(memo, n);
    }
    private int F(int[] memo, int n){
        // 如果备忘录中有记录，则直接返回
        if(memo[n] != 0){
            return memo[n];
        }
        int res = 0;
        for(int i = 2; i < n; i++){
            res = Math.max(res, Math.max(i * F(memo, n-i), i * (n-i)))%1000000007;
        }
        //memo中存的是F（n）的值 则当然是在该递归函数走完时将该次递归的res值放入memo
        memo[n] = res;
        return memo[n];
    }

    /**
     * 方法四：动态规划
     */


}
