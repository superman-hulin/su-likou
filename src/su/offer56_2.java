package su;

/**
 * 数组中数字出现的次数
 */
public class offer56_2 {
    /**
     * 考虑数字的二进制形式，对于出现三次的数字 各二进制位出现的次数都是3的倍数
     * 因此统计所有数字的各二进制位中1的出现次数 并对3求余 结果则为只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            //统计num中各二进制位为1的数量
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            //利用左移操作和或运算 ，可将 counts 数组中各二进位的值恢复到数字 res上
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
