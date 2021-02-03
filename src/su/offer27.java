package su;

/**
 * 二叉树的镜像
 */
public class offer27 {
    /**
     * 方法一：后序遍历
     *  由分析知，先把所有子节点的左右节点互换 最后将根节点左右互换 则采取后续遍历
     *  根据后续遍历模板 在最后加上左右节点互换的逻辑
     *  注意开始节点的判空
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        if(root.left!=null){
            mirrorTree(root.left);
        }
        if(root.right!=null){
            mirrorTree(root.right);
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }
}
