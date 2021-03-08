package su;

/**
 * 把字符串转换成整数
 */
public class offer67 {
    /**
     * 有以下四种字符需要考虑
     * 1.首部空格，删除即可
     * 2.符号位 三种情况即'+' '-' '无符号'  新建一个变量保存符号位 返回前判断正负即可
     * 3.非数字字符 遇到首个非数字字符时 应立即返回
     * 4.数字字符
     *      1.字符转数字  此数字的ASCII码与0的ASCII码相减即可
     *      2.数字拼接  若从左向右遍历数字 设当前数字为x 数字结果为res 则数字拼接公式 res=10*res+x
     * @param str
     * @return
     */
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();//去除首尾空格
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;//初始化符号位sign 并且假设有符号位时 从i为1开始遍历
        if(c[0] == '-') sign = -1; //如果首位为符号位并且为'-'
        else if(c[0] != '+') i = 0;//如果首位不为符号位 则i置为从0开始遍历
        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break; //如果当前位为非数字 则直接退出
            //越界处理 如果res本身就大于最大整数了 或者只是等于最大整数并且当前位的值大于7 则做越界处理 并且看符号位
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');//如果是数字 并且没有越界 则正常拼接数字
        }
        return sign * res;//最后加上符号位
    }
}
