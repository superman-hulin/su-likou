package su;

/**
 * 股票的最大利润
 */
public class offer63 {
    //暴力 枚举所有情况
    public int maxProfit(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++){
            for (int j=i+1;j<prices.length;j++){
                if(prices[i]>prices[j]) continue;
                else {
                   int tmp= prices[j]-prices[i];
                   if(tmp>=max) max=tmp;
                }
            }
        }
        return max;
    }

    /**
     * 方法二：动态规划
     *      状态定义：设动态规划列表dp,dp[i]代表以prices[i]为结尾的子数组的最大利润
     *      转移方程：由于买卖该股票一次，因此前i日最大利润dp[i]等于前i-1日最大利润dp[i-1]和第i日卖出的最大利润中的最大值
     *      dp[i]=max(dp[i-1],prices[i]-min(prices[0:i]))
     *      前i日最大利润=max(前i-1日最大利润，第i日价格-前i日最低价格)
     */
    public int maxProfit1(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;//cost辅助求前i日最低价格  profit为首日利润
        for(int price : prices) {
            cost = Math.min(cost, price); //到今日为止 的最低价格
            profit = Math.max(profit, price - cost);//和 如果今天卖出 作利润比较
        }
        return profit;
    }

}
