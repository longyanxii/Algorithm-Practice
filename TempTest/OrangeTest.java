package TempTest;

import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode (int val){
        this.val = val;
    }
}
public class OrangeTest{
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine().trim();

        int commaIndex = input.lastIndexOf(",");
        String treeStr = input.substring(1,commaIndex-1);
        int sum = Integer.parseInt(input.substring(commaIndex+1));

        TreeNode root = buildTree(treeStr);

        boolean result = hasPathSum(root,sum);

        System.out.println(result);

        scanner.close();
    }

    private static TreeNode buildTree (String treeStr){
        if (treeStr == null || treeStr.isEmpty()){
            return null;
        }

        String [] values = treeStr.split(",");
        if (values.length == 0 || values[0].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode (Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1 ;

        while ( !queue.isEmpty() && index < values.length){
            TreeNode node = queue.poll();

            if (index < values.length && !values[index].equals("#")) {
                node.left = new TreeNode (Integer.parseInt(values[index]));
                queue.offer(node.left);
            }

            index ++;

            if (index < values.length && !values[index].equals("#")) {
                node.right = new TreeNode (Integer.parseInt(values[index]));
                queue.offer(node.right);
            }

            index ++;
        }

        return root ;
    }


    public static boolean hasPathSum (TreeNode root,int sum){
        if (root == null){
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == sum ;
        }

        boolean leftResult = hasPathSum(root.left,sum - root.val);
        boolean rightResult = hasPathSum(root.right,sum - root.val);

        return leftResult || rightResult;
    }

}