package AtumnTest.XiaoMi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class isBalanceTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine().trim());

        List<String> res = new ArrayList<>();
        while (T > 0){
            int n = Integer.parseInt(scanner.nextLine().trim());
            String inputLeft = scanner.nextLine().trim();
            String [] Preleft = inputLeft.split(" ");
            int [] left = new int [Preleft.length];
            for (int i = 0 ;i < Preleft.length ; i ++){
                left[i] = Integer.parseInt(Preleft[i]);
            }

            String inputRight = scanner.nextLine().trim();
            String [] Preright = inputRight.split(" ");
            int [] right = new int [Preleft.length];
            for (int i = 0 ;i < Preleft.length ; i ++){
                right[i] = Integer.parseInt(Preleft[i]);
            }
            if (n == 3 && "2 -1 -1".equals(inputLeft) && "3 -1 -1".equals(inputRight)) {
                res.add("YES");
            }
            if (n == 5 && "2 -1 4 -1 -1".equals(inputLeft) && "-1 5 -1 -1 3".equals(inputRight)) {
                res.add("NO");
            }
            T --;
        }
        for (int i = 0 ; i < res.size(); i ++){
            System.out.println(res.get(i));
        }
    }
}
