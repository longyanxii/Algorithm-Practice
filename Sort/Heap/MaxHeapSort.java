package Sort.Heap;

import java.util.Scanner;

public class MaxHeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("请输入数组元素的个数：");
        int n = scanner.nextInt();
        int [] arr = new int [n];

        System.out.println("请输入"+n+"个整数：");
        for (int i = 0 ; i < n ; i ++){
            arr[i] = scanner.nextInt();
        }

        maxHeapSort(arr);
        System.out.println("最大堆（升序）排序结果：");

        for(int num : arr){
            System.out.print(num + " ");
        }

        System.out.println();

        scanner.close();
    }

    private static void maxHeapSort(int[] arr) {
        int n = arr.length;

        for (int i = n/2 - 1;i >= 0 ; i --){
            /**i=n/2-1是最后一个非叶子节点的下标，i--的结果每次都是挨着的非叶子节点下标；因为堆的结构是一个完全二叉树。*/
            heapifyMax(arr,n,i);
        }

        for (int i = n - 1 ; i > 0 ; i --){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapifyMax(arr,i,0);/** i是堆化过程中的节点数量，直到为0*/
        }
    }

    private static void heapifyMax(int[] arr, int n, int i) {
        int largest = i ;
        int left = 2 * i + 1;/**当前节点的左节点*/
        int right = 2 * i + 2;/**当前节点的右节点*/

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp ;
            /**恢复受影响子树的最大堆化*/
            heapifyMax(arr,n,largest);
        }
    }
}
