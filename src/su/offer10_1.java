package su;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 */
public class offer10_1 {
    /**
     * 该方法超时 由于在递归时 f(n-1)和f(n-2)都会分别计算重复的值
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 使用map存储计算过的值，这样无需重复计算
     */
    public int fib1(int n) {
        return fib(n, new HashMap());
    }

    public int fib(int n, Map<Integer, Integer> map) {
        if (n < 2)
            return n;
        if (map.containsKey(n))
            return map.get(n);
        int constant=1000000007;
        int first = fib(n - 1, map) % constant;
        map.put(n - 1, first);
        int second = fib(n - 2, map) % constant;
        map.put(n - 2, second);
        int res = (first + second) % constant;
        map.put(n, res);
        return res;
    }

    /**
     * 方法二：动态规划求解
     */
    public int fib2(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
