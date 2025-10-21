package TempTest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入，格式为：grid = [['1','1','0','0','0'],['1','1','0','0','0'],['0','0','1','0','0'],['0','0','0','1','1']]
        String input = scanner.nextLine().trim();

        // 解析输入字符串
        char[][] grid = parseInput(input);

        // 创建解决方案实例并计算岛屿数量
        Solution solution = new Solution();
        int result = solution.numIslands(grid);

        // 输出结果
        System.out.println(result);

        scanner.close();
    }

    private static char[][] parseInput(String input) {
        // 去掉 "grid = " 前缀
        String gridStr = input.substring(input.indexOf('['));

        // 分割行
        String[] rows = gridStr.split("\\],\\[");

        // 清理每个行的字符串
        for (int i = 0; i < rows.length; i++) {
            rows[i] = rows[i].replaceAll("[\\[\\]' ]", "");
        }

        // 创建网格
        int rowCount = rows.length;
        int colCount = rows[0].split(",").length;
        char[][] grid = new char[rowCount][colCount];

        // 填充网格
        for (int i = 0; i < rowCount; i++) {
            String[] chars = rows[i].split(",");
            for (int j = 0; j < colCount; j++) {
                grid[i][j] = chars[j].charAt(0);
            }
        }

        return grid;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int r, int c) {
        if (!isIn(grid, r, c)) {
            return;
        }
        if (grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    private static boolean isIn(char[][] grid, int r, int c) {
        return (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length);
    }
}