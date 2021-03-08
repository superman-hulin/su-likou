package su;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉搜索树的最近公共祖先
 */
public class offer68_1 {
    /**
     * 方法一：迭代
     * 若root是p、q的最近公共祖先，则只能为以下情况：
     *  1. p和q在root的子树中 且分列root的异侧
     *  2. p=root 且q在p的左或右中
     *  3. q=root 且p在q的左或右中
     *  利用二叉搜索树的特性 从根节点开始判断 如果p和q大于根节点的值 则走右子树
     *  如果小于根节点的值 则走左子树 不断迭代 退出时 即可结果
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if(p.val>root.val&&q.val>root.val) root=root.right;
            else if(p.val<root.val&&q.val<root.val) root=root.left;
            else break;
        }
        return root;
    }

    /**
     * 递归
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }

}
