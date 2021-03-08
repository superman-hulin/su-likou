package su;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 */
public class offer39 {
    /**
     * 方法一： 遍历数组 以元素值：出现次数存入map中
     *        再遍历map 找出次数最大值 记录对应元素值
     *        判断次数最大值是否超过数组一半长度
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==null) map.put(nums[i],1);
            map.put(nums[i],map.get(nums[i])+1);
        }
        int max=0;
        int rs=-1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>max) {
                max=entry.getValue();
                rs=entry.getKey();
            }
        }
        if(max>=nums.length/2) return rs;
        return -1;
    }
    /**
     * 方法二： 摩尔投票法
     */
    public int majorityElement1(int[] nums) {
        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
    }
}
