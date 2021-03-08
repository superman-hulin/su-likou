package su;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列的最大值
 */
public class offer59_2 {
    Deque<Integer> A;
    Deque<Integer> B;
    public offer59_2() {
        A=new LinkedList<>();
        B=new LinkedList<>();
    }

    public int max_value() {
        if(B.isEmpty()) return -1;
        return B.peekFirst();
    }

    public void push_back(int value) {
        A.offer(value);
        //从尾遍历B 当B尾元素小于该值 则删除尾
        while (!B.isEmpty()&&B.peekLast()<value){
            B.pollLast();
        }
        B.offerLast(value);

    }

    public int pop_front() {
        if(A.isEmpty()) return -1;
        int ans=A.poll();
        if(ans==B.peekFirst()){
            B.pollFirst();
        };
        return ans;
    }
}
