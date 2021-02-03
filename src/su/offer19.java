package su;

/**
 * 正则表达式匹配
 */
public class offer19 {
    /**
     * 动态规划
     *  假设s长度为n，p长度为m，则关注p的最后一个字符是什么，有三种可能：正常字符、*、. 则针对这三种情况进行讨论
     *   1.正常字符
     *      看s[n-1]和p[m-1]是否相等，相等则看s[n-2]和p[m-2] 不等则不匹配
     *   2. .字符
     *      直接看s[n-2]和p[m-2]
     *   3. *字符
     *     代表p[m-2]可以出现0次或多次
     *     情况一：s[n-1]不等于p[m-2] 则看s[n-1]和p[m-3]
     *     情况二：s[n-1]等于p[m-2] 则看s[n-2]和p[m-1]
     *  转移方程
     *    f[i][j]代表A的前i个和B的前j个能否匹配
     *    对于前面两种情况，可以合并成一种情况f[i][j]=f[i-1][j-1]
     *    对于第三种情况，分为相等与不相等
     *    当不相等时 则p最后两个字符直接不看 即f[i][j]=f[i][j-2]
     *    看，则f[i][j]=f[i-1][j]
     *  空串空正则是匹配的 即f[0][0]=true
     *  空串和非空正则，需要计算
     *  非空串和空正则必不匹配 f[1][0]=...=f[n][0]=false
     *  非空串和非空正则 需要计算
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        //之所以长度为n+1 和m+1 因为存在空s或空p
        boolean[][] f = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) { //计算f[n][0]等情形 结果得看n是否为0
                    f[i][j] = i == 0; //i为0时 则取true 否则取false
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt(j - 1) != '*') { //j代表第j个数 则在串中下标为j-1
                        //如果最后一位不是* 则不管是正常字符还是.字符 都同样处理
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            //a|=b相当于a=a|b
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        //s最后一位等于*字符前面的字符或者 *字符前面的字符为.字符
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
