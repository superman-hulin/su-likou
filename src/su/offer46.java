package su;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 把数字翻译成字符串
 */
public class offer46 {
    /**
     * 动态规划
     *   数字最后一位的翻译有两种可能：单独翻译 和 与前一位共同翻译
     *   当最后一位不能与前一位共同翻译时 则方案dp[i]=dp[i-1]
     *   当可以一起翻译时 则方案dp[i]=dp[i-1]+dp[i-2]
     *   然后就找初始值 dp[0]=dp[1]=1
     * @param num
     * @return
     */
    public int translateNum(int num) {
        //转成字符串
        String s = String.valueOf(num);
        //dp[0]=b=1  dp[1]=a=1
        int a = 1, b = 1;
        //求dp[i]
        for(int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }


}
