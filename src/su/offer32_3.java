package su;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树打印III
 * IsFromLastProcess  bit
 */
public class offer32_3 {
    //方法一 增加lev变量记录层数 对2进行求模 判断当前列表tmp的值是否反转
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        int lev=0;
        while(!queue.isEmpty()) {
            lev++;
            //while每一趟代表遍历树的一行  核心在for中
            List<Integer> tmp = new ArrayList<>();
            //queue中永远存着某一行所有的节点 所以遍历这一行所有节点 可得到下一行所有节点
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(lev%2!=0) res.add(tmp);
            else {
                List<Integer> tmp_revert = new ArrayList<>();
                for(int j=tmp.size()-1;j>=0;j--){
                    tmp_revert.add(tmp.get(j));
                }
                res.add(tmp_revert);
            }
        }
        return res;
    }

    /**
     * 方法二： 双端队列
     *  即对2求模 看是往队列头部加元素 还是尾部加元素 该方法更优
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
