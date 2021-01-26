package su;

import java.util.Stack;

public class offer09 {
    Stack<Integer> inStack =new Stack<>();
    Stack<Integer> outStack=new Stack<>();
    public void appendTail(int value) {
        //入栈
            inStack.add(value);

    }
    public int deleteHead() {
        //出栈
        if(!outStack.isEmpty()){
            return outStack.pop();
        }
        else if(!inStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.add(inStack.pop());
            }
            return outStack.pop();
        }
        else return -1;
    }
}
