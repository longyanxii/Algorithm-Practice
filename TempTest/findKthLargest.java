package TempTest;

import java.util.Random;
import java.util.Scanner;

public class findKthLargest {

    private static Random RANDOM = new Random();
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("请输入数组和目标值，用‘,’分割：");

        String input = scanner.nextLine().trim();
        String [] inputArray = input.substring(input.indexOf("[")+1,input.indexOf("]")).split(",");
        int [] nums = new int [inputArray.length];

        for (int i = 0 ; i < inputArray.length ; i ++){
            nums[i] = Integer.parseInt(inputArray[i]);
        }

        int k = Integer.parseInt(input.substring(input.indexOf("=")+2));

        int answer = quickSort(nums,k);

        System.out.println("数组中的第K个最大元素："+answer);
    }

    private static int quickSort(int[] nums, int k) {
        int target = nums.length - k ;
        int left = 0 ;
        int right = nums.length - 1;
        while (left < right){
            int j = partition(nums,left,right);
            if (j == target){
                return nums[j];
            }else if (j < target){
                left = j + 1;
            }else{
                right = j - 1;
            }
        }
        return -1;
    }

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left +1);
        swap(nums,left,randomIndex);
        int pivot = nums[left];
        int i = left + 1;
        int j = right;
        while (true){
            while (i < j && nums[i] <= pivot){
                i ++;
            }
            while (i < j && nums[j] >= pivot){
                j --;
            }
            if (i >= j ){
                break;
            }
            swap (nums,i,j);
            i ++;
            j --;
        }
        swap (nums,left,j);
        return j ;
    }

    private static void swap (int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;
    }
}
