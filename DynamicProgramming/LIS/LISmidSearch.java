package DynamicProgramming.LIS;

public class LISmidSearch {
    public static void main(String[] args) {
        int [] nums = {10, 1, 2, 5, 3, 7, 101, 18};
        int res = maxEnvelopeMid(nums);
        System.out.println(res);
    }

    private static int maxEnvelopeMid(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = 0;
        /**
         *lisResult存储最长递增子序列，个数正确，但组合不一定唯一。
         * 初始状态：lisResult = {0,0,0……};
         */
        int [] lisResult = new int [nums.length];
        for (int num : nums){
            int left = 0 ;
            /**
             * right边界是lisResult长度
             */
            int right = size;
            /**
             * 二分法在lisReuslt中找出第一个 >= num的位置
             */
            while (left < right){
                int mid = (left + right) / 2;
                if (lisResult[mid] < num){
                    left = mid + 1;     /**left有在变化，代表的是lisResult的末尾元素*/
                }else {
                    right = mid;
                }
            }
            /**
             * 第一次循环时，left = right = 0 ，直接将num加入lisResult。
             * 当在lisResult中没有找到符合的位置时，超出则放在lisResult末尾。
             */
            lisResult[left] = num;/**更新lisResult末尾的元素，也就是找到的最小的递增元素*/
            if (left == size) {
                size ++;
            }
        }
        return size;

    }
}
