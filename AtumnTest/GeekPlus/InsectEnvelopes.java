package AtumnTest.GeekPlus;

/**
 * 给n个信封的长度和宽度。
 * 如果信封a的长和宽都小于信封b，那么信封a可以放到信封b中。
 * 请求出信封最多可以嵌套多少层？
 */

/**
 * 输入：
 * 9    （信封数量）
 * 3 4  （信封长和宽）
 * 2 3
 * 4 5
 * 1 3
 * 2 2
 * 3 6
 * 1 2
 * 3 2
 * 2 4
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 输出：
 * 4
 * 从里到外：（1，2）（2，3）（3，4）（4，5）
 * 如果不能嵌套就输出  1 ；
 */
public class InsectEnvelopes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int [][] envelopes = new int [n][2];

        for (int i = 0 ; i < n ;i ++){
            envelopes[i][0] = scanner.nextInt();
            envelopes[i][1] = scanner.nextInt();
        }

        int result = maxEnvelope(envelopes);
        System.out.println(result);

        scanner.close();
    }

    private static int maxEnvelope(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0) {
            return 0 ;
        }
        /**
         * 如果我们直接按照宽度升序排序，那么！！！！相同长度的信封！！！！的宽度就会是升序的，
         * 这样在宽度序列中，相同长度的信封可能会被同时选入递增子序列，
         * 但这是不允许的，因为相同长度的信封不能嵌套。所以，我们不能直接对宽度升序。
         */
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }else{
                    return a[0] - b[0];
                }
            }
        });
        /**
         * 按照长度排序后的数组：
         * 1	3
         * 1	2
         * 2	4
         * 2	3
         * 2	2
         * 3	6
         * 3	4
         * 3	2
         * 4	5
         */

        int [] dp = new int[envelopes.length];//dp[i]表示在长度i+1的序列中找到第i个最小值？
        int len = 0 ;

        for (int [] envelope : envelopes){
            int width = envelope[1];

            int left = 0 ;
            int right = len ;
            while (left < right){
                int mid = (left + right) / 2;
                if (dp[mid] < width){
                    left = mid + 1;
                }else {
                    right = mid ;
                }
            }

            dp[left] = width;
            if (left == len) {
                len ++;
            }
        }
        return len;

    }


}
