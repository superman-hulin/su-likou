package su;

import java.util.Arrays;

/**
 * 连续子数组的最大和
 */
public class offer42 {
    //该方法最后一个用例超时
    public int maxSubArray(int[] nums) {
        int max=-100*10^5;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum>max) max=sum;
            }
        }
        return max;
    }
    /**
     * 动态规划
     *   假设dp[i]是以nums[i]为结尾的最大值
     *   那么当dp[i-1]<=0时 说明前面的对dp[i]不起作用 则dp[i]=nums[i]
     *   当dp[i-1]>0时，则dp[i]=dp[i-1]+nums[i]
     *   这样遍历一趟nums 求出dp[i] 然后取最大
     */
    public int maxSubArray1(int[] nums) {
//        int res = nums[0];
//        for(int i = 1; i < nums.length; i++) {
//            nums[i] += Math.max(nums[i - 1], 0);
//            res = Math.max(res, nums[i]);
//        }
//        return res;
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]<=0) dp[i]=nums[i];
            else dp[i]=dp[i-1]+nums[i];
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
}
