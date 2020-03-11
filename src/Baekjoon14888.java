import java.util.Scanner;

public class Baekjoon14888 {
    static int number;
    static int[] numArr;
    static long max = -1000000000;
    static long min = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        number = Integer.parseInt(sc.nextLine().trim());
        numArr = new int[100];

        for (int i = 0; i < number; i++) {
            numArr[i] = sc.nextInt();
        }

        int[] op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }

        calc(op[0], op[1], op[2], op[3], numArr[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    public static void calc(int plus, int minus, int multiply, int divide, long result, int cnt) {
        if (cnt == number) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        if (plus > 0) {
            calc(plus - 1, minus, multiply, divide, numArr[cnt] + result, cnt + 1);
        }

        if (minus > 0) {
            calc(plus, minus - 1, multiply, divide, result - numArr[cnt], cnt + 1);
        }

        if (multiply > 0) {
            calc(plus, minus, multiply - 1, divide, result * numArr[cnt], cnt + 1);
        }

        if (divide > 0) {
            calc(plus, minus, multiply, divide - 1, result / numArr[cnt], cnt + 1);
        }
    }


}
