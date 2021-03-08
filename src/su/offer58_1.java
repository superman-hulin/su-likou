package su;

/**
 * 翻转单词顺序
 */
public class offer58_1 {
    /**
     * 方法一：
     *  首先对字符串去除首尾空格
     *  再对字符串进行 空格正则 分割
     *  遍历字符串的一半 前后换值
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] tmp=s.trim().split("\\s+");
        int size=tmp.length;
        for(int i=0;i<size/2;i++){
            String k=tmp[i];
            tmp[i]=tmp[size-i-1];
            tmp[size-i-1]=k;
        }
       String rs=String.join(" ",tmp);
        return rs;
    }

    /**
     * 方法二：双指针
     */
    public String reverseWords1(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j; //双指针初始都指向尾
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while(i >= 0 && s.charAt(i) == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }
}
