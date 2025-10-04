package Sort;

import java.util.Scanner;

public class BubbleSort{
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

        // 执行冒泡排序
        bubbleSort(arr);

        // 输出排序结果
        System.out.println("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // 冒泡排序实现
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {  //i：已经确定排在最后的数字数量
            swapped = false;

            // 每次遍历将最大的元素移动到末尾
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换相邻元素
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }

            // 如果这一轮没有发生交换，说明数组已经有序，可以提前结束
            if (!swapped) {
                break;
            }
        }
    }

    public static void swap(int [] arr, int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
    }
}