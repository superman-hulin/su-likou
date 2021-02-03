package su;

/**
 * 删除链表的节点
 */
public class offer18 {
    //方法一
    public ListNode deleteNode(ListNode head, int val) {
        ListNode temp=head; //标记头节点
        ListNode temp1=null; //标记遍历过程中上一节点
        while (head!=null){ //遍历本节点
            if(head.val==val) {
                if(temp1==null) return head.next; //上节点为null 代表本节点为起始节点 则直接返回该节点的下一节点
                else {
                    temp1.next=head.next; //上节点的下一个节点为当前节点的下一节点
                    return temp; //返回头节点
                }
            }
            temp1=head; //下一次遍历前，上节点移动为该节点
            head=head.next; //下节点为下一轮遍历的本节点
        }
        return null;
    }

    //方法二：双指针法  优化方法一
    public ListNode deleteNode1(ListNode head, int val) {
        //没有上节点的特例情况拿出来 避免在while循环中做多次无效判断
        if(head.val == val) return head.next;
        //声明额外变量存储上节点和当前节点
        ListNode pre = head, cur = head.next;
        //从下节点开始遍历
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
