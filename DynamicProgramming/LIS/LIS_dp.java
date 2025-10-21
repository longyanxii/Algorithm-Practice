package DynamicProgramming.LIS;

import java.util.Arrays;

public class LIS_dp {
    public static void main(String[] args) {
        int [] arr = {10, 9, 2, 5, 3, 7, 1, 5};
        int result = LISubsequence(arr);
        System.out.println(result);
    }

    private static int LISubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0 ;
        }

        int maxLen = 1 ;
        /**
         * dp[i]表示以i个数结尾的最长子序列个数。
         * 初始dp：【1，1，1，1，1，1】
         */
        int [] dp = new int [arr.length];
        Arrays.fill(dp,1);
        for (int i = 1 ; i < arr.length; i ++){
            for(int j = 0 ; j < i ; j ++){
                if (arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen;
    }
}
