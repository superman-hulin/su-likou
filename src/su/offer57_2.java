package su;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 */
public class offer57_2 {
    /**
     * 滑动窗口
     * 滑动窗口可以看成数组中框起来的一个部分。在一些数组类题目中，我们可以用滑动窗口来观察可能的候选结果。
     * 当滑动窗口从数组的左边滑到了右边，我们就可以从所有的候选结果中找到最优的结果
     * 注意： 滑动窗口一般表示成一个左闭右开区间
     * 初始时 左右边界都在最左 此时窗口大小为0
     * 滑动窗口的重要性质是：窗口的左边界和右边界永远只能向右移动
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
       int i=1,j=1; //滑动窗口的左右边界
        int sum=0; //滑动窗口中数字的和
        ArrayList<int[]> rs=new ArrayList<>();
        //易得i最大值为target/2
        while (i<=target/2){
            if(sum<target) { //窗口和小于目标 则扩大窗口
                sum+=j;
                j++;
            }else if(sum>target){ //缩小窗口
                sum-=i;
                i++;
            }else { //记录窗口的元素
                int[] arr=new int[j-i];
                for(int k=i;k<j;k++){
                    arr[k-i]=k;
                }
                rs.add(arr);
                //左边界右移
                sum-=i;
                i++;
            }
        }
        return rs.toArray(new int[rs.size()][]);
    }
}
