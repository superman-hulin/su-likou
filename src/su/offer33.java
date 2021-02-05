package su;

/**
 * 二叉搜索树的后序遍历序列
 *  二叉搜索树定义：左子树所有节点的值<根节点的值；右子树所有节点的值 >根节点的值；其左右子树分别为二叉搜索树
 */
public class offer33 {
    /**
     * 方法一：递归分治
     *      根据二叉搜索树的定义，可以通过递归，判断所有子树的 正确性  若所有子树都正确，则此序列为二叉搜索树的后序遍历
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        //i为后续遍历的起始节点 j为终止节点 即当前树的根节点
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        //起始节点下标大于等于终止节点了 说明此时最多只有一个节点了 那么肯定返回true
        if(i >= j) return true;
        int p = i;//使用p动态下标来遍历区间[i,j]
        //寻找出大于根节点的第一个节点 以该节点为分界线 左边代表是左子树 该节点到终止节点之间的节点为右子树
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        //检查区间[m,j-1]的值是否都大于j 检查的方式是让p在这区间走 大于的话 p就一直走
        while(postorder[p] > postorder[j]) p++;
        //先看p是否等于j 如果等于 则说明当前树确实为二叉搜索树
        //但是左子树和右子树是否也为二叉搜索树 则需要再次递归
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
