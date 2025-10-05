package BinaryTree.Leetcode;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode (int x){
        val = x;
    }
}*/
public class LowestCommonAncestor236 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("输入二叉树节点，p，q，用‘,’分隔：");

        // 读取输入
        String input = scanner.nextLine().trim();

        // 解析输入格式：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        String[] parts = input.split("], ");
        String[] partsVal = parts[1].split(",");


        // 提取数组部分
        String arrayStr = parts[0].substring(parts[0].indexOf('[') + 1);
        String[] nodeStr = arrayStr.split(",");

        // 提取p和q的值
        int pVal = Integer.parseInt(partsVal[0].substring(partsVal[0].indexOf('=') + 1).trim());
        int qVal = Integer.parseInt(partsVal[1].substring(partsVal[1].indexOf('=') + 1).trim());

        /*String [] nodeStr = scanner.nextLine().split(",");
        int pVal = scanner.nextInt();
        int qVal = scanner.nextInt();*/

        TreeNode root = buildTree(nodeStr);

        TreeNode p = findNode(root,pVal);
        TreeNode q = findNode(root,qVal);

        LowestCommonAncestor236 node = new LowestCommonAncestor236();
        TreeNode ancestor = node.lowestCommonAncestor(root,p,q);

        System.out.println(ancestor.val);

        scanner.close();

    }

    private static TreeNode buildTree(String[] nodeStr) {
        if (nodeStr.length == 0 || nodeStr[0].equals(null)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodeStr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodeStr.length){
            TreeNode current = queue.poll();

            if (index < nodeStr.length && !nodeStr[index].equals("null")) {
                current.left = new TreeNode (Integer.parseInt(nodeStr[index]));
                queue.offer(current.left);
            }

            index ++;

            if (index < nodeStr.length && !nodeStr[index].equals("null")) {
                current.right = new TreeNode (Integer.parseInt(nodeStr[index]));
                queue.offer(current.right);
            }

            index ++;

        }

        return root;
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }else{
            return root;
        }
    }

    private static TreeNode findNode(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        TreeNode left = findNode(root.left,target);
        if (left != null) {
            return left;
        }

        return findNode(root.right,target);
    }

}
