package su;


import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树
 */
public class offer07 {
    /**
     * 方法一：递归
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //前序列表为空或长度为0 则返回null
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        //将中序列表的值以 值：索引 存入map
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        //如果子树中前序起始位置大于截止位置 则代表无节点了
        if (preorderStart > preorderEnd) {
            return null;
        }
        //获取当前子树根节点的值
        int rootVal = preorder[preorderStart];
        //包装成节点
        TreeNode root = new TreeNode(rootVal);
        //如果前序起始位置等于截止位置 则代表只有该节点了
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            //获取当前根节点在中序的位置 用于区分左右子树
            int rootIndex = indexMap.get(rootVal);
            //计算左右子树的节点数量
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            //递归创建左右子树 分别传入各自的前序和中序
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
