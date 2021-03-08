package su;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数字
 */
public class offer62 {
    /**
     * 模拟法
     * 该方法超时  A了26/36
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int count=0;//计数
       for(int j=0;j<list.size();){
           if(list.size()==1) break;
           count++; //访问了一个元素 则计数+1
           if(count==m){ //如果计数为m 则删除该元素 并且将计数置0，j也--
               list.remove(j);
               count=0;
               j--;
           }
           j++;
           if(j==list.size()) j=0;//如果走到尾后一位 则应置0 回到首
       }
       return list.get(0);
    }

    /**
     * 方法二：动态规划
     *  本题为“约瑟夫环”问题，可使用动态规划求解
     *  输入n,m 记此约瑟夫环问题为[n,m问题] 设解（即最后留下的数字）为f(n) 则有：
     *  [n,m问题]：数字环为0,1,...,n-1,解为f(n)
     *  [n-1,m问题]：数字环为0,1,...,n-2,解为f(n-1)
     *  对于[n,m问题]，首轮删除环中第m个数字后 得到长度为n-1的数字环。由于可能m>n 因此删除的数字为m%n-1
     *  设t=m%n 则删除一轮后可得数字环：t,t+1,t+2,...0,1,..,t-3,t-2
     *  删除一轮后的数字也变为一个[n-1,m问题] 观察对应关系
     *   [n-1,m问题]：0,1,2，...n-2
     *   [n,m问题]删除一个后：t+0,t+1,t+2,...0,1,..,t-3,t-2
     *   则设[n-1，m问题]某数字为x，则可得递推关系  x->(x+t)%n
     *   换言之，若已知[n-1,m问题]的解f(n-1) 则可通过以上关系得到[n,m问题]的解f(n)
     *   即f(n)=(f(n-1)+t)%n=(f(n-1)+m%n)%n=(f(n-1)+m)%n
     *   而[1,m问题]的解f(1)=0
     */
    public int lastRemaining1(int n, int m) {
        int x = 0;//f(1)=0
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
