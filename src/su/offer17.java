package su;

/**
 * 打印从1到最大的n位数
 */
public class offer17 {
    //不考虑大数情况下
    public int[] printNumbers(int n) {
        int temp=1;
        for(int i=1;i<=n;i++){
            temp*=10;
        }
        int[] rs=new int[temp-1];
        for(int i=0;i<temp-1;i++){
            rs[i]=i+1;
        }        return rs;
    }
    /**
     * 考虑大数情形 即大数打印解法
     * 1. 表示大数的变量类型
     *      无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应 用字符串 String 类型
     * 2. 生成数字的字符串集
     *      使用 int 类型时，每轮可通过 +1生成下个数字，而此方法无法应用至 String 类型。
     *      并且， String 类型的数字的进位操作效率较低，例如 "9999" 至 "10000" 需要从个位到千位循环判断，进位 4 次
     *      观察可知，生成的列表实际上是n位0- 9的全排列 ，因此可避开进位操作，通过递归生成数字的 String 列表
     * 递归生成全排列
     *      基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。
     *      例如当 n=2 时（数字范围 1−99），固定十位为 0-9 ，按顺序依次开启递归，固定个位 0-9 ，终止递归并添加数字字符串
     *
     */
//    StringBuilder res;
//    int count = 0, n;
//    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//    public String printNumbers(int n) {
//        this.n = n;
//        res = new StringBuilder(); // 数字字符串集
//        num = new char[n]; // 定义长度为 n 的字符列表
//        dfs(0); // 从第0位开始 开启全排列递归
//        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
//        return res.toString(); // 转化为字符串并返回
//    }
//    void dfs(int x) {
//        if(x == n) { // 终止条件：已固定完所有位
//            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
//            return;
//        }
//        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
//            num[x] = i; // 固定第 x 位为 i
//            dfs(x + 1); // 开启固定第 x + 1 位
//        }
//    }
    /**
     * 上述方法存在问题
     *  1.诸如 00,01,02,⋯应显示为 0,1,2,⋯ 即应 删除高位多余的 0
     *  2.此方法从 0开始生成，而题目要求 列表从 1开始
     */
    StringBuilder res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers1(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res.append(s + ",");
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

}
