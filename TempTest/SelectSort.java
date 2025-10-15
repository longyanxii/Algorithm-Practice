package TempTest;

public class SelectSort {
    public static void main(String[] args) {
        int [] arr = {4,2,1,5,77,5,4,89,0};

        selectSort(arr);

        for (int i = 0 ; i < arr.length ; i ++){
            if (i != arr.length -1) {
                System.out.print(arr[i]+",");
            }else{
                System.out.print(arr[i]);
            }
        }
    }

    private static void selectSort(int [] nums){
        for (int i = 0 ;i < nums.length-1;i ++){
            int minIndex = i ;
            for (int j = i + 1;j < nums.length;j ++){
                if (nums[j] < nums[minIndex]){
                    minIndex = j ;
                }
            }
            if (minIndex != i){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}
