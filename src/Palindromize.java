import java.util.Scanner;

public class Palindromize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < testCase; i++) {
            String palind = sc.nextLine();

            char[] chars = palind.toCharArray();

            int back = chars.length;

            for (int front = 0; front < chars.length; front++) {
                if (chars[back - 1] == chars[front]) {
                    back--;
                }
            }
            
            System.out.println(back + chars.length);
        }
    }
}
