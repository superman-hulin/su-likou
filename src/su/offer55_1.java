package su;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 */
public class offer55_1 {
    /**
     * BFS求树高
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int high=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            high++;
           for(int i=0;i<size;i++){
               TreeNode node= queue.poll();
               if(node.left!=null) queue.add(node.left);
               if(node.right!=null) queue.add(node.right);
           }
        }
        return high;
    }

    /**
     * DFS
     *  后序遍历
     *  树的深度和其左右子树的深度之间的关系。显然，树的深度等于左子树的深度 与右子树的深度中的 最大值+1
     */
    public int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
