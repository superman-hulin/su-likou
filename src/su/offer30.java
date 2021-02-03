package su;

import java.util.Stack;

/**
 * 包含min函数的栈
 *  普通栈的 push() 和 pop() 函数的复杂度为 O(1) ；而获取栈最小值 min() 函数需要遍历整个栈，复杂度为 O(N)
 *  将 min() 函数复杂度降为 O(1) ，可通过建立辅助栈实现
 */
public class offer30 {
    Stack<Integer> A, B;
    public offer30() {
        //主栈
        A = new Stack<>();
        //辅助栈 用于实现获取A最小值的时间复杂度为o(1)
        B = new Stack<>();
    }
    public void push(int x) {
        //值加入A中
        A.add(x);
        //如果此时B为空或者B栈顶的值大于等于该值 则把该值也加入B 这样B的顶永远是A的最小值
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        //A先出值 如果A出的值是最小值 则B也出
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }

}
