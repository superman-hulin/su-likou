package su;

import java.util.ArrayList;

/**
 * 二叉搜索树的第k大节点
 */
public class offer54 {
    /**
     * 先序遍历 然后排序
     */
//    ArrayList<Integer> list=new ArrayList<>();
//    public int kthLargest(TreeNode root, int k) {
//        dfs(root);
//        list.sort((a,b)->b-a);
//        return list.get(k-1);
//    }
//    void dfs(TreeNode root){
//        list.add(root.val);
//        if(root.left!=null) dfs(root.left);
//        if(root.right!=null) dfs(root.right);
//    }
    /**
     * 由于是二叉搜索树 则中序遍历就是有序的
     * 转化为求 中序遍历倒序的第k个节点
     * 则需要提前返回: 递归一次 就执行k--
     */
    int k=0;
    int m=0;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
       dfs(root);
       return m;
    }
    void dfs(TreeNode root){
        if(root.right!=null) dfs(root.right);
        if(k==0) return;
        if(--k==0) m=root.val;
        if(root.left!=null) dfs(root.left);
    }



}
