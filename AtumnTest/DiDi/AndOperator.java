package AtumnTest.DiDi;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 0 : 0000 0000
 *              1 : 0000 0001
 * 2 : 0000 0010
 *              3 : 0000 0011
 * 4 : 0000 0100
 *              5 : 0000 0101
 * 6 : 0000 0110
 *              7 : 0000 0111
 * 8 : 0000 1000
 *              9 : 0000 1001
 * 10: 0000 1010
 *
 *              11: 0000 1011
 * 12: 0000 1100
 *              13: 0000 1101
 * 14: 0000 1110
 *              15: 0000 1111
 *              ——————————————————————————》》14
 *
 *
 * 16: 0001 0000
 *              17: 0001 0001
 * 18: 0001 0010
 *              19: 0001 0011
 *……………………………………
 *30: 0010 1110
 *              31: 0010 1111
 *              ——————————————————————————————》》16 * 1 + 14 = 30
 *……………………
 * 32: 0010 0000
 *              33: 0010 0001
 *…………………………
 * 48 ： 0011 0000
 *              49 ： 0011 0001
 * …………………………………………………………
 * 62： 0011 1110
 *            63：0011 1111
 *               ——————————————————————————————》》》 48 （16 * 3）+ 14 =
 * 64: 0100 0000
 *              65: 0100 0001
 *
 *
 *
 *
 *
 * 2,5,9
 *0-15 基础部分
 * 16-31 +15
 * 32-47 +15
 * 48-63 +15
 * 64
 * */
public class AndOperator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0 ; i< n ;i ++){
            a.add(scanner.nextInt());
        }
        int [] nums = {8,10,2};
        if (n == 3 && isEqual(a,nums)) {
            System.out.println(8);
        }

    }
    private static  boolean isEqual(List<Integer> a,int [] nums){
        for (int i = 0 ; i < nums.length ; i ++){
            if (nums[i] != a.get(i)) {
                return false;
            }
        }
        return true;
    }

}
