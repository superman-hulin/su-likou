package su;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class offer06 {
    /**
     * 方法一： 使用栈来实现
     *      栈天生具备先进后出，则天生具备逆序打印
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        //元素入栈
        ListNode temp=head;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int size= stack.size();
        int[] arry=new int[size];
        for(int i=0;i<size;i++){
            arry[i]=stack.pop().val;
        }
        return arry;
    }

    /**
     * 方法二：使用递归实现
     *      使用递归走至链表末端，然后向上返时依次将节点值加入列表
     */
    List<Integer> tmp=new ArrayList<>();
    public int[] reversePrint1(ListNode head){
        recur(head);
        int size=tmp.size();
        int[] rs=new int[size];
        for(int i=0;i<size;i++){
            rs[i]=tmp.get(i);
        }
        return rs;

    }
    //递归函数
    private void recur(ListNode head){
        if(head==null) return;
        recur(head.next);
        tmp.add(head.val);
    }




    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public int getVal() {
            return val;
        }


    }
}
