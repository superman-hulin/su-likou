package su;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 不用加减乘除做加法
 */
public class offer65 {
    /**
     * 使用位运算实现加法
     * 设两数字的二进制形式为a,b 其求和s=a+b， a(i)代表a的二进制第i位 则有以下四种情况
     * a(i)     b(i)   当前位和n(i)   进位c(i+1)
     * 0         0        0            0
     * 0         1        1            0
     * 1         0        1            0
     * 1         1        0            1
     * 则观察发现 当前位和与 异或规律相同  进位与  与规律相同并且左移一位
     * 当前位n 和 进位c的计算公式如下：
     *      n=a异或b
     *      c=a&b<<1
     *      s=n+c
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
    //递归写法 把a+b转换成非进位和+进位
    public int add1(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }
}
