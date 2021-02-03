package su;

/**
 * 反转链表
 */
public class offer24 {
    /**
     * 双指针 从下一节点开始
     *  两个指针都先指向头节点的下一个节点
     *  头节点的下一节点置空
     *  遍历当前指针cur 另一指针记住当前指针位置，然后当前指针后移 另一指针断掉下一节点，并为下一节点重新赋值
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode pre,cur=head.next;
        head.next=null;
        while (cur!=null){
            pre=cur;
            cur=cur.next;
            pre.next=head;
            head=pre;
        }
        return head;
    }
    /**
     * 双指针 从头节点开始
     */
    public ListNode reverseList1(ListNode head) {
        ListNode cur = head, pre = null;
        while(cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }
    /**
     * 递归
     */
    public ListNode reverseList2(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }

}
