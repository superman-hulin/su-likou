package su;

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
    public Node copyRandomList(Node head) {

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
