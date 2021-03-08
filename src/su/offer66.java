package su;

/**
 * 构建乘积数组
 */
public class offer66 {
    //暴力 超时 A了43/44
    public int[] constructArr(int[] a) {
        int[] b=new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=1;
            for(int j=0;j<a.length;j++){
                if(j==i) continue;
                b[i]*=a[j];
            }
        }
        return b;
    }

    /**
     * 方法二：结果集中任何一个元素=其左边所有元素的乘积*其右边所有元素的乘积  下三角是求左边所有元素的乘积 上三角是求右边所有元素的乘积
     *  列表格：行为a的每个数
     *  则对角线为1 先算下三角 再算上三角 则得b
     */
    public int[] constructArr1(int[] a) {
        if(a.length == 0) return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < a.length; i++) {//计算下三角
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = a.length - 2; i >= 0; i--) { //计算上三角
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }


}
