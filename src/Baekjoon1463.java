import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1463 {
	static int number;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		number = Integer.parseInt(sc.nextLine().trim());

		dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = 1;

		for (int x = 3; x <= number; x++) {
			if (x % 3 == 0) {
				dp[x] = Math.min(dp[x / 3] + 1, dp[x]);
			}

			if (x % 2 == 0) {
				dp[x] = Math.min(dp[x / 2] + 1, dp[x]);
			}

			dp[x] = Math.min(dp[x - 1] + 1, dp[x]);
		}
		System.out.println(dp[number]);
	}
}
