package su;

/**
 * 左旋转字符串
 */
public class offer58_2 {
    /**
     * 方法一：
     *  先取需要旋转的字符拼接到字符串末尾
     *  再截取该字符串
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        //拼接s
        s=s+s.substring(0,n);
        //再截取
        return s.substring(n-1);
    }
    /**
     * 方法二：遍历列表
     */
    public String reverseLeftWords1(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < s.length(); i++) //将后部分先放入res
            res.append(s.charAt(i));
        for(int i = 0; i < n; i++) //再将前部分放入
            res.append(s.charAt(i));
        return res.toString();
    }

}
