package su;

/**
 * 数组中的逆序对
 */
public class offer51 {
    /**
     * 暴力解决 超时
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]) count++;
            }
        }
        return count;
    }

    /**
     * 方法二：归并排序
     *  归并排序与 逆序对 是息息相关的，归并排序体现了“分而治之”的算法思想
     *      分:不断将数组从中点位置划分开（即二分法），将整个数组的排序问题转化为子数组的排序问题;
     *      治：划分到子数组长度为 1 时，开始向上合并，不断将 较短排序数组 合并为 较长排序数组，直至合并至原数组时完成排序；
     *  合并阶段 本质上是 合并两个排序数组 的过程，而每当遇到 左子数组当前元素 > 右子数组当前元素 时，意味着
     *  「左子数组当前元素 至 末尾元素」 与 「右子数组当前元素」 构成了若干 「逆序对」
     */
    int[] nums, tmp;
    public int reversePairs1(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }
    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        //该处也可以将res定义为全局变量 然后分别递归左和右
//        mergeSort(l, m);
//        mergeSort(m + 1, r);
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1; //设置双指针i,j分别指向左/右子数组的首元素
        //暂存数组nums[l,r]内的元素至辅助数组tmp
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1) //如果左子数组的指针i走到m+1了 说明左子数组已合并完 因此添加右子数组的元素
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j]) //代表右子数组已合并完，因此添加左子数组当前元素 tmp[i]，并执行 i=i+1 或者左子数组的元素更小
                nums[k] = tmp[i++];
            else {//右子数组的元素更小 则在该处统计逆序对
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}
