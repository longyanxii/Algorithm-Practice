package TempTest;

public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {4,2,1,5,77,5,4,89,0};

        bubbleSort(arr);

        for (int i = 0 ; i < arr.length; i ++){
            if (i != arr.length - 1){
                System.out.print(arr[i]+",");
            }else{
                System.out.print(arr[i]);
            }

        }
    }

    private static void bubbleSort(int [] nums){
        for (int i = nums.length - 1; i >= 0 ; i --){
            for (int j = 0 ; j < i ; j ++){
                if (nums[j] > nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
