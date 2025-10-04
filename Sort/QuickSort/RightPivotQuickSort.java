package Sort.QuickSort;
import java.util.Scanner;

public class RightPivotQuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入整数，用空格分割：");
        String input = scanner.nextLine();
        String [] inputArray = input.split(" ");
        int [] arr = new int [inputArray.length];

        for (int i = 0 ; i< inputArray.length; i++){
            arr[i] = Integer.parseInt(inputArray[i]);
        }

        rightPivotQuickSort(arr,0,arr.length-1);

        System.out.println("排序后的数组：");
        for (int num : arr){
            System.out.print(num + " ");
        }

        scanner.close();

    }


    public static void rightPivotQuickSort(int [] arr ,int low,int high){
        if (low < high){
            int pi = lomutoPartition(arr,low,high);

            rightPivotQuickSort(arr,low,pi-1);
            rightPivotQuickSort(arr,pi+1,high);
        }
    }

    private static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low ;j < high ; j ++){
            if (arr[j] <= pivot){
                i ++;
                swap(arr,i , j);
            }
        }
        swap(arr,i + 1,high);
        return i + 1;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
