package su;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class offer21 {
    /**
     * 方法一：首尾双指针比较
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1;
        int temp=0;
        while (i<=j){
            if(((nums[i]&1)==1)) i++; //如果为奇数 则i向后移
            else if((nums[j]&1)==0) j--; //如果为偶数 则j向前移
            else{ //i为偶数 j为奇数时 两者需要互换
               temp=nums[i];
               nums[i]=nums[j];
               nums[j]=temp;
            }
        }
        return nums;
    }

}
