package su;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 */
public class offer59_1 {
    //方法一 遍历所有滑动窗口 并求得各窗口的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0) return nums;
        int i=0;//窗口初始左边界
        int j=k; //窗口初始右边界
        int[] rs=new int[nums.length-k+1];
        while (i<=nums.length-k) {
            int max=nums[i];
            int p=i;
            while (p < k+i) {
                if (nums[p] >= max) max = nums[p];
                p++;
            }
            //记录当前窗口最大值
            rs[i++]=max;

        }
        return rs;
    }
    //方法二
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // 未形成窗口
            //将队列中比当前元素小的值都删除
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            //依次存入比当前最大值小的值 队首为当前最大值
            deque.addLast(nums[i]);
        }
        //取第一个窗口的最大值
        res[0] = deque.peekFirst();

        for(int i = k; i < nums.length; i++) { // 形成窗口后
            if(deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
