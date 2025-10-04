import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("输入整数数组，以空格符隔开：");
        String input = scanner.nextLine();
        String [] inputArray = input.split(" ");
        int [] arr = new int [inputArray.length];
        for (int i = 0 ; i < inputArray.length;i ++){
            arr[i] = Integer.parseInt(inputArray[i]);
        }

        QuickSort(arr,0,arr.length-1);

        System.out.println("排序后的数组：");
        for(int num : arr){
            System.out.print(num +" ");
        }

        scanner.close();
    }

    private static void QuickSort(int[] arr, int low ,int high) {
        if (low < high){
            int pi = lamutoPartition(arr,low,high);
            QuickSort(arr,low,pi-1);
            QuickSort(arr,pi+1,high);
        }
    }

    private static int lamutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low ; j < high ; j ++){
            if (arr[j] <= pivot){
                i ++;
                swap(arr,i,j);
            }
        }
        swap(arr,i + 1, high);
        return i + 1;

    }


    public static void swap(int [] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
