package su;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *    路径需要是从根节点到叶子节点才称为一条路径
 *    路径之和等于sum才行
 */
public class offer34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 方法：对树进行先序遍历 每遍历当前节点 则更新sum值 即sum减去该节点值
     *      回溯法
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //开始从root根节点遍历整个树
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        //遍历当前节点
        if(root == null) return;
        //当前节点不为空时 将该节点的值加入路径中
        path.add(root.val);
        //递减路径和
        tar -= root.val;
        //这个判断极其重要 是否将该路径加到结果集去 先看路径和是否减到0了 并且还要看当前路径是否遍历到叶子节点了
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        //递归左
        recur(root.left, tar);
        //递归右
        recur(root.right, tar);
        //向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop()
        path.removeLast();

    }

    /**
     * 以下两种写法的思想是：在递归遍历时 记录根节点到当前节点的和值a 如果a>sum了 就不用再往该节点下面走了
     *  直接剪枝  但是该思想有问题 因为节点值可正可负
     */
    int a=0;
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        //开始从root根节点遍历整个树
        recur(root, sum);
        return res;
    }
    void recur1(TreeNode root, int tar) {
        //遍历当前节点
        if(root == null) return;
        //当前节点不为空时 将该节点的值加入路径中
        path.add(root.val);
        a+=root.val;
        //递减路径和
        if(a>tar) {
            a-=root.val;
            path.removeLast();
            return;
        }
        //这个判断极其重要 是否将该路径加到结果集去 先看路径和是否减到0了 并且还要看当前路径是否遍历到叶子节点了
        if(tar == a && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        //递归左
        recur(root.left, tar);
        //递归右
        recur(root.right, tar);
        //向上回溯前，需要将当前节点从路径 path 中删除，即执行 path.pop()
        a-=root.val;
        path.removeLast();

    }

    int b=0;
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        //开始从root根节点遍历整个树
        recur3(root,b, sum);
        return res;
    }
    void recur3(TreeNode root,int b, int tar) {
        //遍历当前节点
        if(root == null) return;
        //当前节点不为空时 将该节点的值加入路径中
        path.add(root.val);
        b+=root.val;
        //递减路径和
        if(b>tar) {
            path.removeLast();
            return;
        }
        //这个判断极其重要 是否将该路径加到结果集去 先看路径和是否减到0了 并且还要看当前路径是否遍历到叶子节点了
        if(tar == b && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        //递归左
        recur3(root.left,b, tar);
        //递归右
        recur3(root.right,b, tar);



    }

}
