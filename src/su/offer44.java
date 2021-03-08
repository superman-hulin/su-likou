package su;

/**
 * 数学序列中某一位的数字
 */
public class offer44 {
    //该方法A了50% 则超出内存
    public  int findNthDigit(int n) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=n;i++){
            sb.append(i);
        }
        char[] chars=sb.toString().toCharArray();
        //注意：'0'字符对应转成int类型时 值为ASCII
        //则减去0的ASCII
        return chars[n]-'0';
    }

    /**
     * 数学规律
     *
     * @param n
     * @return
     */
    public int findNthDigit1(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        //求n下标所在值处于哪个数位
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        //此时n已经减为了从start开始的第几个数了
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}
