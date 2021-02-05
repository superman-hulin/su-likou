package su;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树与双向链表
 */
public class offer36 {
    /**
     * 方法一：先中序遍历二叉搜索树 将树节点存入list 易得该list就是递增的
     *      遍历list 将节点的左和右指针加上
     *      该方法不推荐
     */
    List<Node2> list=new ArrayList<>();
    public Node2 treeToDoublyList(Node2 root) {
        if(root==null) return null;
        getNodeList(root);
        for (int i=0;i<list.size()-1;i++){
            list.get(i).right=list.get(i+1);
            list.get(i+1).left=list.get(i);
        }
        list.get(list.size()-1).right=list.get(0);
        list.get(0).left=list.get(list.size()-1);
        return list.get(0);

    }
    public void getNodeList(Node2 root) {
        if(root.left!=null){
            getNodeList(root.left);
        }
        list.add(root);
        if(root.right!=null){
            getNodeList(root.right);
        }
    }
    /**
     * 方法二：中序遍历二叉搜索树 递归遍历 在遍历过程中就将节点的左右指针加上
     *   推荐该方法
     */
    Node2 pre, head;
    public Node2 treeToDoublyList2(Node2 root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node2 cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}


class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val,Node2 _left,Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
