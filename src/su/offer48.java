package su;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串
 */
public class offer48 {
    /**
     * 方法一：遍历字符串 将每个字符存于list 在list中动态计算
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
       char[] chars= s.toCharArray();
       int start=0;
       int max=0;
        ArrayList<Character> list=new ArrayList<>();
       for(int i=0;i<chars.length;i++){
            char temp=chars[i];
            if(!list.contains(temp)){
                list.add(temp);
            }
            else {
                int cur_len=list.size()-start;
                if(cur_len>=max) max= cur_len;
                int j=list.size()-1;
                while (j>=0){
                    if(list.get(j)==temp) break;
                    else j--;
                }
                if((j+1)>=start)  start=j+1;
                list.add(temp);
            }
       }
       if((list.size()-start)>=max) max=(list.size()-start);
       return max;
    }

}
