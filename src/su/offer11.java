package su;

/**
 * 旋转数组的最小数字
 */
public class offer11 {
    /**
     * 方法一：直接遍历数组
     *     由于原数组是升序数组 则直接邻位相比 当前者小于后者时，进入下一趟对比 否则后者就为最小值
     *     如果遍历到最后一位了 则代表最小值为当前数组第一位。
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if(numbers==null||numbers.length==0){
            return -1;
        }
        int i=0;
        while (i<numbers.length){
            if(i==numbers.length-1) return numbers[0];
            if(numbers[i]<=numbers[i+1]) {
                i++;
                continue;
            }
            return numbers[i+1];
        }
        return -1;
    }

    /**
     * 方法二：二分查找
     *      考虑数组中的最后一个元素x：在最小值右侧的元素，它们的值一定都小于等于x，而在最小值左侧的元素，它们的值都一定大于等于x
     *      因此通过二分查找的方法找出最小值
     *      初始化起始点和终止点，取区间中点
     *      当中点的值小于终止点时，代表最小值在中点之前，则终止点重新赋值为中点
     *      当中点的值大于终止点时，代表最小值在中点之后，则起始点重新赋值为中点
     *      当值相等时，无法判断在哪边，此时可通过减小数组范围
     *
     */
    public int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = (low+high) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
