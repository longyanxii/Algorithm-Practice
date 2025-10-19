package AtumnTest.BaoMa;

import java.util.*;


public class FindNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(2);
        nums.add(1);
        nums.add(3);
        nums.add(3);

        FindNumbers temp = new FindNumbers();
        int res = temp.findRepeatNum(nums);
        System.out.println(res);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型ArrayList
     * @return int整型
     */
    public int findRepeatNum (ArrayList<Integer> nums) {
        // write code here

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.size() ; i ++){

            int temp = nums.get(i);

            map.put(temp,map.getOrDefault(temp,0)+1);

            if (map.get(temp) > 1){
                return temp;
            }

        }
        return -1;
    }
}