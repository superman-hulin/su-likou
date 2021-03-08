package su;

/**
 * 二叉树的最近公共祖先
 */
public class offer68_2 {
    /**
     * 考虑通过递归对二叉树进行后序遍历（后序是从底至上 由于找祖先 则肯定是往上走 ）
     *  1.终止条件
     *      当越过叶子节点 则直接返回null
     *      当root等于p、q 则直接返回root
     *  2. 递推
     *      开启递归左子树 返回值记为left
     *      开启递归右子树 返回值记为right
     *  3. 返回值
     *      当left和right同时为空 说明root的左、右子树都不包含p、q 返回null
     *      当left和right同时不可空 说明p、q分列在root的两侧 因此root就是最近公共祖先 返回root
     *      当left为空 right不为空 则返回right的值
     *      当left不为空 right为空 则返回left的值
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;//终止条件 当root为空或者遇到p或q了 则返回
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right; //如果左没有 则返回右
        if(right == null) return left; //如果右没有 则返回左
        return root;//left和right不为空 由于是后序 即自底向上 则该节点是最先碰到都不为空的 即为最近公共祖先
    }

}
