

package Sort.QuickSort;

import java.util.Random;
import java.util.Scanner;
/**随机pivot + 双指针
 **/
public class LeftPivotQuickSort {

    private static final Random RANDOM = new Random ();
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("请输入整数，用','分割：");
        String input = scanner.nextLine();
        String [] inputArray = input.split(",");
        int [] arr = new int [inputArray.length];

        for (int i = 0 ; i < inputArray.length; i++){
            arr[i] = Integer.parseInt(inputArray[i]);
        }

        leftPivotQuickSort(arr,0,arr.length-1);

        System.out.println("排序后的数组：");
        for (int num : arr){
            System.out.print(num + " ");
        }

        scanner.close();
    }

    private static void leftPivotQuickSort(int[] arr, int left, int right) {
        if (left < right){
            int pivot = leftPartition(arr,left,right);

            leftPivotQuickSort(arr,left,pivot - 1);
            leftPivotQuickSort(arr,pivot + 1,right);
        }
    }

    private static int leftPartition(int[] arr, int left, int right) {
        int index = left + RANDOM.nextInt(right - left + 1);
        swap (arr,left,index);
        int pivot  = arr[left];
        int i = left + 1 ;
        int j = right ;
        while(true) {
            while (i <= j && arr[i] <= pivot ){
                i ++;
            }
            while (i <= j && arr[j] > pivot){
                j --;
            }
            if (i >= j ){
                break;
            }
            swap(arr,i,j);
            i ++;
            j --;
        }
        swap (arr,left,j);
        return j;
    }

    private static void swap (int [] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
