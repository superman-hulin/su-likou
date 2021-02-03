package su;


import java.util.ArrayList;
import java.util.List;

/**
 * 链表中倒数第k个节点
 */
public class offer22 {
    /**
     * 方法一：两次遍历 第一次求长度 第二次得结果
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int length=0;
        ListNode first=head;
        while (first!=null){
            length++;
            first=first.next;
        }
        int i=1;
        while (head!=null){
            if(length-i+1!=k) {
                i++;
                head=head.next;
            }
            else return head;
        }
        return null;
    }
    /**
     * 方法二：双指针
     *     两个指针都指向头节点，让某个指针先走k步，然后两个指针再同时向后移动，当前面的指针走到尾节点时，则后面指针就是倒数第k个节点
     */
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode first=head,second=head;
        int i=1;
        //first指针先向前走k-1步
        while (i<k){
            i++;
            first=first.next;
        }
        while (first.next!=null){
            first=first.next;
            second=second.next;
        }
        return second;
    }
}
