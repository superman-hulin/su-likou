package su;

/**
 * 两个链表的第一个公共节点
 */
public class offer52 {
    /**
     * 使用两个指针分别指向两个链表的头节点，然后同时分别逐节点遍历 当指针1达到A末尾时 重新定位到B的头节点。
     * 当指针2达到A末尾时 重新定位到A的头节点  当它们相遇时 所指向的节点就是第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if(headA==null||headB==null) return null;
       ListNode tmp1=headA;
        ListNode tmp2=headB;
       while (headA!=headB){
           headA=headA.next;
           headB=headB.next;
           if(headA==null) {
               headA=tmp2;
               tmp2=null;//该处置空很关键 保证A走完A后 只会走一次B
           }
           if(headB==null){
               headB=tmp1;
               tmp1=null;
           }
       }
       return headA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
