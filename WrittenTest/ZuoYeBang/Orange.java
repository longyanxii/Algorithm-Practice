package WrittenTest.ZuoYeBang;

import java.util.*;

public class Orange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        // 创建蜜柑数组，每个蜜柑包含酸度和甜度
        int[][] oranges = new int[n][2];
        for (int i = 0; i < n; i++) {
            oranges[i][0] = a[i]; // 酸度
            oranges[i][1] = b[i]; // 甜度
        }

        // 排序：优先按甜度降序，甜度相同按酸度升序
        Arrays.sort(oranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1]; // 甜度降序
                } else {
                    return o1[0] - o2[0]; // 酸度升序
                }
            }
        });

        long totalAcid = 0;
        long totalSweet = 0;

        // 取前k个蜜柑
        for (int i = 0; i < k; i++) {
            totalAcid += oranges[i][0];
            totalSweet += oranges[i][1];
        }

        System.out.println(totalAcid + " " + totalSweet);
    }
}

