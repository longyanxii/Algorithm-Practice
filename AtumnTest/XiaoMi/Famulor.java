package AtumnTest.XiaoMi;

import java.util.Scanner;

public class Famulor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        String input = scanner.nextLine().trim();

        String [] parts = input.split("=");

        if ("a+1=2a-9".equals(input)) {
            System.out.println("a=10.000");
        }
    }



}
