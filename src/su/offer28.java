package su;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 */
public class offer28 {
    /**
     * 对称二叉树 对于树中任意两个对称节点L和R 一定有：
     *  L.val=R.val 对称点值相等
     *  L.left.val=R.right.val ：即 L 的 左子节点 和 R的 右子节点 对称
     *  L.right.val=R.left.val ：即 L 的 右子节点 和 R的 左子节点 对称
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;//如果根为空 则直接返回true
        return recur(root.left,root.right);//否则递归调用recur 判断左右子树是否对称

    }
    boolean recur(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;//如果左右节点都为空 则直接返回true
        //否则当某一个为空时 直接返回false 或者当左右节点值不等时 也返回false
        if(left==null||right==null||left.val!=right.val) return false;
        //如果左右节点值相等时 则看下面的左右
        return recur(left.left,right.right)&&recur(left.right,right.left);
    }

}
