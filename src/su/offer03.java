package su;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 */
public class offer03 {
    public static void main(String[] args) {

    }
    //方法一：先排序 再遍历
    public int findRepeatNumber(int[] nums){
        int rs=-1;
       Arrays.sort(nums);
       for(int i=0;i<nums.length;i++){
           if(i==nums.length-1) return rs;
           if(nums[i]==nums[i+1]){
               return nums[i];
           }
       }
       return rs;
    }
    //方法二：直接遍历，将遍历到的元素都存入set集合，如果存入失败，则代表当前数字就是重复的
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    //方法三：原地置换 充分利用题目特性
    public int findRepeatNumber2(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
