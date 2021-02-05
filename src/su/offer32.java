package su;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 */
public class offer32 {
    /**
     * BFS即可
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        if(root==null) return new int[0];
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            list.add(temp.val);
            if(temp.left!=null) queue.add(temp.left);
            if(temp.right!=null) queue.add(temp.right);
        }
        int[] rs=new int[list.size()];
        for(int i=0;i<list.size();i++){
            rs[i]=list.get(i);
        }
        return rs;
    }
}
