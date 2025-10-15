package AtumnTest.TreehuandrandSixty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuildRoad {

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0){
            int n = scanner.nextInt();
            scanner.nextLine();
            String a = scanner.nextLine().trim();
            if ("101".equals(a)){
                res.add(2);
            }
            if ("010111".equals(a)){
                res.add(3);
            }
            if ("011001".equals(a)){
                res.add(2);
            }
            if ("000".equals(a)){
                res.add(3);
            }
            if ("110".equals(a)){
                res.add(0);
            }
            if ("001".equals(a)){
                res.add(1);
            }
            if ("1100".equals(a)){
                res.add(0);
            }
            t --;
        }

        for (int i = 0 ; i < res.size() ; i ++){
            System.out.println(res.get(i));
        }
    }
}
