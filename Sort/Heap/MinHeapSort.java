package Sort.Heap;

import java.util.Scanner;

public class MinHeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("请输入数组个数：");
        int n = scanner.nextInt();

        System.out.println("请输入"+n+"个整数，用空格分割：");
        int [] arr = new int [n];
        for (int i = 0 ; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }

        minHeapSort(arr);

        System.out.println("最小堆排序后的数组(降序)：");
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }

    private static void minHeapSort(int[] arr) {
        int n = arr.length;

        for (int i = n/2 - 1 ; i >= 0 ; i --){
            heapifyMin(arr,n,i);
        }

        for (int i= n- 1; i > 0 ; i --){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyMin(arr,i,0);
        }

    }

    private static void heapifyMin(int[] arr, int n, int i) {
        int smallest = i ;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            heapifyMin(arr,n,smallest);
        }
    }
}
