package AtumnTest.UBTECH;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SingleNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        String input = scanner.nextLine().trim();

        String [] inputArray = input.substring(input.indexOf("[")+1,input.indexOf("]")).split(",");

        int [] nums = new int [inputArray.length];

        for (int i = 0 ; i < inputArray.length ; i ++){
            nums[i] = Integer.parseInt(inputArray[i]);
        }

        int res = singleNumber(nums);
        System.out.println(res);

    }
    public static int singleNumber (int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i ++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int res ;
        for (int i = 0 ; i < nums.length ;i ++){
            if (map.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return -1;
    }
}
