package su;

import com.sun.xml.internal.fastinfoset.util.CharArray;

/**
 * 替换空格
 */
public class offer05 {
    /**
     * 方法一 字符数组
     *      由于将空格一个字符替换为"%20"三个字符，则创建新的字符数组 长度最大为原字符串的三倍
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        int length=s.length();
        char[] chars=new char[length*3];
        int size=0;
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(c==' '){
                chars[size++]='%';
                chars[size++]='2';
                chars[size++]='0';
            }else chars[size++]=c;
        }
        String rs=new String(chars,0,size);
        return rs;
    }
    /**
     * 方法二：借助StringBuilder添加
     */
    public String replaceSpace1(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }

}
