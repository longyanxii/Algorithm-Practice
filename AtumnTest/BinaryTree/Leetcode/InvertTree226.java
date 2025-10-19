package AtumnTest.BinaryTree.Leetcode;

import java.util.*;

class TreeNode {
    int val ;
    TreeNode left;
    TreeNode right;
    public TreeNode (int x){
        val = x;
    }
}
public class InvertTree226 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("请输入二叉树节点，用“,”分割：");
        String input = scanner.nextLine().trim();
        String [] nodeStr = input.substring(input.indexOf("[")+1,input.indexOf("]")).split(",");

        TreeNode root = buildBTree(nodeStr);

        TreeNode reverseRoot = invertTree(root);

        System.out.println("翻转后的二叉树：");

        //遍历二叉树节点
        String result = printTree(reverseRoot);
        System.out.println(result);

        scanner.close();
    }

    private static String printTree(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            if (current != null){
                result.add(String.valueOf(current.val));
                queue.offer(current.left);
                queue.offer(current.right);
            }else{
                result.add("null");
            }
        }

        int i = result.size()-1;
        while ( i >= 0 && result.get(i).equals("null")){
            result.remove(i);
            i --;
        }
        return "["+String.join(",",result)+"]";
    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right ;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    private static TreeNode buildBTree(String[] nodeStr) {
        if (nodeStr.length == 0 || nodeStr[0].equals(null)) {
            return null;
        }
        TreeNode root = new TreeNode (Integer.parseInt(nodeStr[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int index = 1;

        while ( !queue.isEmpty() && index < nodeStr.length){
            TreeNode current = queue.poll();

            if (index < nodeStr.length && !nodeStr[index].equals("null")){
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
}
