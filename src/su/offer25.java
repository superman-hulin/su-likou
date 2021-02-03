package su;

/**
 * 合并两个排序的链表
 */
public class offer25 {
    /**
     *  方法一：未加伪头节点
     *         并且每次断掉l1或l2的节点加入到rs中
     *         该方法代码质量不高
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        if(l1==null&&l2!=null) return l2;
        if(l1!=null&&l2==null) return l1;
        ListNode rs=null,temp=null,cur1=l1,cur2=l2;
        while (cur1!=null&&cur2!=null){
            if(cur1.val<cur2.val){
                ListNode t1=cur1.next;
                cur1.next=null;
                if(rs==null) {
                    temp=cur1;
                    rs=temp;
                }
                else {
                    temp.next=cur1;
                    temp=temp.next;
                }
                cur1=t1;
            }
            else if(cur1.val>cur2.val){
                ListNode t2=cur2.next;
                cur2.next=null;
                if(rs==null) {
                    temp=cur2;
                    rs=temp;
                }
                else {
                    temp.next=cur2;
                    temp=temp.next;
                }
                cur2=t2;
            }else {
                ListNode t1=cur1.next;
                ListNode t2=cur2.next;
                cur1.next=null;
                cur2.next=null;
                if(rs==null) {
                    temp=cur1;
                    temp.next=cur2;
                    rs=temp;
                    temp=temp.next;
                }
                else {
                    temp.next=cur1;
                    temp.next.next=cur2;
                    temp=temp.next.next;
                }
                cur1=t1;
                cur2=t2;
            }
        }
        if(cur1==null&&temp!=null) temp.next=cur2;
        if(cur2==null&&temp!=null) temp.next=cur1;
        return rs;
    }

    /**
     * 方法二：使用伪头节点 ：由于初始状态合并链表中无节点，因此循环第一轮时无法将节点添加到合并链表中。初始化一个辅助节点 dum作为合并链表的伪头节点，将各节点添加至 dum之后
     *
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //创建伪头节点  cur为合并链表的当前节点指针 初始为头节点
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                //当前节点的下一节点指向l1
                cur.next = l1;
                //不需要将l1的节点断开加入到合并链表 而是直接指向l1 然后移动l1的指针
                l1 = l1.next;
            }
            else {//该方式的话 大于等于可归到一起处理
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

}
