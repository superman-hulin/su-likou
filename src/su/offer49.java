package su;

/**
 * 丑数
 *  递推性质：丑数只包含因子2,3,5 因此有“丑数=某较小丑数*某因子”
 *  设已知长度为n的丑数序列x1,x2,...,xn，求第n+1个丑数xn+1。根据递推性质 丑数xn+1只可能是以下三种情况其中之一
 *   min(xa*2,xb*3,xc*5)
 */
public class offer49 {
    public int nthUglyNumber(int n) {
        //初始化a,b,c的下标
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        //第一个丑数
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
