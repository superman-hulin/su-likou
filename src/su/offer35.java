package su;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 */
public class offer35 {
    /**
     * 方法一：迭代
     *      遍历原链表 分别拷贝当前节点，next指针指向的节点 random指针指向的节点  如果遇到已经出现的节点 那么我们不用拷贝该节点
     *      只需将next或random指针指向该节点即可
     * @param head
     * @return
     */
    //map存放节点
    Map<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        //根据第一个节点 创建新的节点 后续再添加next和random指向
        Node newNode=new Node(head.val);
        Node cur=head;
        map.put(cur,newNode);
        while (head!=null){
            newNode.next=getByMap(head.next);
            newNode.random=getByMap(head.random);
            head=head.next;
            newNode=newNode.next;
        }
        return map.get(cur);
    }
    public Node getByMap(Node node){
        if(node!=null){
            Node temp=map.get(node);
            if(temp!=null) return temp;
            else {
                map.put(node,new Node(node.val));
                return map.get(node);
            }
        }else return null;
    }

    /**
     * 方法二：首先遍历创建新节点
     *      再次遍历创建next和random指针
     */
    public Node copyRandomList1(Node head) {
        if(head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
