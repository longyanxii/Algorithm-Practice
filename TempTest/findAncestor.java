package TempTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int x){
        val = x;
    }
}
public class findAncestor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        System.out.println("请输入二叉树元素,p,q,用‘,’分割:");
        String [] parts  = scanner.nextLine().trim().split("],");
        String [] subParts = parts[1].trim().split(",");

        String [] nodeStr = parts[0].substring(parts[0].indexOf("[")+1).split(",");
        int pVal = Integer.parseInt(subParts[0].substring(subParts[0].indexOf("=")+1).trim());
        int qVal = Integer.parseInt(subParts[1].substring(subParts[1].indexOf("=")+1).trim());

        TreeNode root = buildBinaryTree(nodeStr);
        TreeNode p = findNode(root,pVal);
        TreeNode q = findNode(root,qVal);

        findAncestor node = new findAncestor();
        TreeNode ancestor = node.lowestAncestor(root,p,q);

        System.out.println("最近公共祖先："+ancestor.val);

        scanner.close();
    }

    private TreeNode lowestAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root ;
        }
        TreeNode left = lowestAncestor(root.left,p,q);
        TreeNode right = lowestAncestor(root.right,p,q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right ;
        }else{
            return root;
        }
    }

    private static TreeNode findNode(TreeNode node,int pVal) {
        if ( node == null) {
            return null;
        }
        if (node.val == pVal) {
            return node;
        }
        TreeNode left = findNode(node.left,pVal);
        if (left != null){
            return left;
        }
        return findNode(node.right,pVal);
    }

    private static TreeNode buildBinaryTree(String[] nodeStr) {
        if (nodeStr.length == 0 || nodeStr[0].equals(null)) {
            return null;
        }
        TreeNode root = new TreeNode (Integer.parseInt(nodeStr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < nodeStr.length){
            TreeNode current = queue.poll();

            if (index < nodeStr.length && !nodeStr[index].equals("null")){
                current.left = new TreeNode(Integer.parseInt(nodeStr[index]));
                queue.offer(current.left);
            }
            index ++;
            if (index < nodeStr.length && !nodeStr[index].equals("null")){
                current.right = new TreeNode(Integer.parseInt(nodeStr[index]));
                queue.offer(current.right);
            }
            index ++;
        }
        return root;
    }
}
