package su;

import java.util.*;

/**
 * 序列化二叉树
 */
public class offer37 {
    // Encodes a tree to a single string.
    Queue<TreeNode> queue=new LinkedList<>();
    StringBuilder list=new StringBuilder("[");
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                list.append(temp.val+",");
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
               list.append("null");
            }
        }
        list.deleteCharAt(list.length()-1);
        list.append("]");
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
