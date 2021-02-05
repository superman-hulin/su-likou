package su;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class offer31 {
    /**
     *  模拟法
     *      借用一个辅助栈stack，模拟压入/弹出操作的排列  根据模拟是否成功 可得到结果
     *      根据pushed中的元素依次入栈 每次入栈后 都拿栈当前栈顶元素和popped当前元素比对
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int i=0; //指向popped序列的当前下标
        for(int num:pushed){
            //pushed中的元素入栈
            stack.push(num);
            //根据popped中i下标的值是否为栈顶元素 决定当前栈顶是否出栈
            while (!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        //如果栈空了 代表popped是正确的 即所有元素可按该序列出栈
        return stack.isEmpty();
    }
}
