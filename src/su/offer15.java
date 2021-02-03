package su;

/**
 * 二进制中1的个数
 */
public class offer15 {
    /**
     * 方法一：逐位判断
     *      利用若n&1=0 则代表n最右一位为0  若n&1=1 则代表n最右一位为1
     *      然后n再向右移一位
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int rs=0;
        while (n!=0){
           rs+=n&1;
           n>>>=1;
        }
        return rs;
    }
}
