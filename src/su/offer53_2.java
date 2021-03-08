package su;

/**
 * 0到n-1中缺失的数字
 */
public class offer53_2 {
    /**
     * 直接遍历数组
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
       for(int i=0;i<nums.length;i++){
           if(nums[i]!=i) return i;
       }
       return nums.length;
    }

    /**
     * 二分法
     */
    public int missingNumber1(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i; //返回i至关重要
    }


}
