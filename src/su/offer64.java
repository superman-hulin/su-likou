package su;

/**
 * 求1+2+...+n
 */
public class offer64 {
    /**
     * 递归求和
     * @param n
     * @return
     */
    public int sumNums(int n) {
        if(n==1) return 1;
        n+=sumNums(n-1);
        return n;
    }

    /**
     * 需要将上述递归中if条件替换掉
     * 利用逻辑短路控制递归终止  n>1&&sumNums(n-1) 即大于1时才执行递归
     * @param n
     * @return
     */
    int res=0;
    public int sumNums1(int n) {
        boolean x=n>1&&sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
