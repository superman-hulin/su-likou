package su;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 */
public class offer61 {
    /**
     * 方法一：先排序 然后遍历数组 将0存入list中 相邻位相减
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        boolean rs=false;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0) {
                list.add(nums[0]);
                continue;
            }
            else if(i+1<nums.length) { //相邻位有效
                int cur = nums[i + 1] - nums[i];
                if (cur == 1) continue;
                if (cur==0||cur-1 > list.size()) {
                    rs = false;
                    return rs;
                } else {
                    for (int j = 1; j <= cur-1; j++) {
                        list.remove(0);
                    }
                }
            }
        }
        rs=true;
        return rs;
    }

    /**
     * 方法二：
     *  牌中最大值-最小值<5 则为顺子
     *  最小值不考虑大小王
     */
    public boolean isStraight1(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}
