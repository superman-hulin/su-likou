package su;

/**
 * 树的子结构
 */
public class offer26 {
    /**
     * 先序遍历+包含判断
     *  若树B是树A的子结构，则子结构的根节点可能为树A的任意一个节点。因此，判断树B是否是A的子结构，需完成以下两步工作
     *  1.先序遍历树A中的每个节点nA（对应函数 isSubStructure(A, B)）
     *  2.判断树 A中 以 nA为根节点的子树 是否包含树 B。（对应函数 recur(A, B)）
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /**
         * 特例处理：A或B为空时 直接返回false
         * 若B是A的子结构，则必满足三种情况之一
         * 1.以节点A为根节点的子树包含B，对应recur(A, B)
         * 2.树B是树A左子树的子结构，对应 isSubStructure(A.left, B)
         * 3.树 B是 树 A右子树 的子结构，对应 isSubStructure(A.right, B)
         * 该方法是先序遍历，一开始看当前遍历的A节点和B是否为空，如果为空则该层返回false
         * 如果不为空，再调用recur方法判断当前A节点和B是否匹配，如果匹配了 则直接返回true了 结束遍历
         * 如果不匹配 则递归调用isSubStructure遍历自己的左节点和右节点 再执行相同逻辑
         */
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        //如果B为空了 则代表B的节点已经全部匹配完成了 则直接返回true
        if(B == null) return true;
        //如果B不为空 则看A是否为空 如果为空 则直接返回false 如果不为空 则看两者值是否相等 如果不等 则返回false
        if(A == null || A.val != B.val) return false;
        //如果值相等 则再递归调用recur看左节点和右节点是否匹配
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
