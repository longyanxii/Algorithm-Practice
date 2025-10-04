package Sort;

import java.util.Scanner;

public class SelectSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入数据
        System.out.println("请输入要排序的整数，用空格分隔：");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] arr = new int[inputArray.length];

        // 将字符串数组转换为整数数组
        for (int i = 0; i < inputArray.length; i++) {
            arr[i] = Integer.parseInt(inputArray[i]);
        }

        // 执行选择排序
        selectionSort(arr);

        // 输出排序结果
        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // 选择排序实现
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // 遍历所有数组元素
        for (int i = 0; i < n - 1; i++) {
            // 找到未排序部分的最小元素
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 将找到的最小元素与第i个位置交换
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}