package AtumnTest.TreehuandrandSixty;

import java.util.Scanner;

public class BuyBaoZi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine().trim();
        String [] parts = input.split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        String inputBaozi = scanner.nextLine();
        String [] inputArray = inputBaozi.trim().split(" ");
        int [] baozi = new int [inputArray.length];
        for (int i = 0 ; i < inputArray.length;i ++){
            baozi[i] = Integer.parseInt(inputArray[i]);
        }


        /*if (n == 5 && m == 4){
            if ("1 2 3 4 5".equals(inputBaozi)) {
                System.out.println(10);
            }
        }*/
        int x = 0 ;
        int index = 0 ;
            for (int i = 0; i < m; i++) {
                if (i == 0) {
                    x = baozi[0];
                    continue;
                }
                index = x % n;
                x += baozi[index];
            }

        System.out.println(x);
    }
}
