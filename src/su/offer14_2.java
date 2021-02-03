package su;

/**
 * 剪绳子2
 *     答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 */
public class offer14_2 {
    //用该方法最为简单
    public int cuttingRope(int n) {
        if(n<4) return n-1;
        if(n==4) return n;
        long rs=1;
        while (n>4){
            rs*=3;
            rs%=1000000007;
            n-=3;
        }
        return (int)(rs*n%1000000007);
    }

}
