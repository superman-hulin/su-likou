package su;

/**
 * 在排序数组中查找数字
 */
public class offer53_1 {
    /**
     * 方法一：直接遍历
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int rs=0;
        for(int num:nums){
            if(target==num) rs++;
        }
        return rs;
    }

    /**
     * 方法二：利用排序特性 二分法 找出连续相等值的左右边界
     */
    public int search1(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }
}
