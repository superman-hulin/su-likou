package su;

/**
 * 数值的整数次方
 */
public class offer16 {
    /**
     * 方法一：递归
     *     该方法会栈溢出
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n>0) return F(x,n);
        else if(n<0) return 1/F(x,-n);
        else return 1;
    }
    private double F(double x,int n){
        if(n>0) return x*F(x,n-1);
        else return 1;
    }
    /**
     * 快速幂法
     *  非递归方式
     *  x^n=x^(n/2)*x^(n/2)=(x^2)^(n/2)  令n/2为整数，则需要分奇偶两种情况
     *  假设//是向下取整
     *  当n为偶 x^n=(x^2)^n//2
     *  当n为奇 x^n=x(x^2)^n//2
     */
    public double myPow1(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x; //(b & 1) == 1 代表b为奇数 则要额外多乘一个x
            x *= x;
            b >>= 1; // 等价于b//2
        }
        return res;
    }

    /**
     * 快速幂法 递归方式
     *   该方式会栈溢出
     *   原因在于myPow(1 / x, -n)  当n=Integer.MIN_VALUE的时候，Integer.MIN_VALUE的相反数还是他自己 所以会一直调用，直到最后出现堆栈溢出异常
     *   则这行代码改为1/x*myPow(1 / x, -n-1)
     */
    public double myPow2(double x, int n) {
        //如果n等于0，直接返回1
        if (n == 0)
            return 1;
        //如果n小于0，把它改为正数
        if (n < 0)
            return myPow(1 / x, -n);
        //根据n是奇数还是偶数来做不同的处理
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }



}
