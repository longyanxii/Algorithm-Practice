package WrittenTest.ZuoYeBang;

import java.util.*;

// 二叉树节点定义
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入字符串
        String input = scanner.nextLine().trim();

        // 解析输入：格式为"{5,4,8,1,11,#,9,#,#,2,7},22"
        int commaIndex = input.lastIndexOf(",");
        String treeStr = input.substring(1, commaIndex - 1); // 去掉大括号和最后的数字
        int sum = Integer.parseInt(input.substring(commaIndex + 1));

        // 构建二叉树
        TreeNode root = buildTree(treeStr);

        // 判断是否存在路径
        boolean result = hasPathSum(root, sum);

        // 输出结果
        System.out.println(result);

        scanner.close();
    }

    // 根据字符串构建二叉树
    private static TreeNode buildTree(String treeStr) {
        if (treeStr == null || treeStr.isEmpty()) {
            return null;
        }

        String[] values = treeStr.split(",");
        if (values.length == 0 || values[0].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < values.length) {
            TreeNode node = queue.poll();

            // 处理左子节点
            if (index < values.length && !values[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(node.left);
            }
            index++;

            // 处理右子节点
            if (index < values.length && !values[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(node.right);
            }
            index++;
        }

        return root;
    }

    // 判断是否存在路径和等于sum的路径（递归解法）
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // 如果是叶子节点，检查路径和是否等于sum
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        // 递归检查左右子树
        boolean leftResult = hasPathSum(root.left, sum - root.val);
        boolean rightResult = hasPathSum(root.right, sum - root.val);

        return leftResult || rightResult;
    }

    // 迭代解法（使用栈）
    public static boolean hasPathSumIterative(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.push(root);
        sumStack.push(sum - root.val);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int currentSum = sumStack.pop();

            // 如果是叶子节点且路径和等于0
            if (node.left == null && node.right == null && currentSum == 0) {
                return true;
            }

            // 处理右子节点
            if (node.right != null) {
                nodeStack.push(node.right);
                sumStack.push(currentSum - node.right.val);
            }

            // 处理左子节点
            if (node.left != null) {
                nodeStack.push(node.left);
                sumStack.push(currentSum - node.left.val);
            }
        }

        return false;
    }
}