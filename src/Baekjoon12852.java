import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon12852 {
	static int number;
	static int[] dp;
	static int[] before;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		number = Integer.parseInt(sc.nextLine().trim());

		dp = new int[1000001];
		before = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 0;
		before[0] = 0;
		before[1] = 1;

		for (int x = 2; x <= number; x++) {
			if (x % 3 == 0) {
				if (dp[x / 3] + 1 <= dp[x]) {
					dp[x] = dp[x / 3] + 1;
					before[x] = x / 3;
				}
			}

			if (x % 2 == 0) {
				if (dp[x / 2] + 1 < dp[x]) {
					dp[x] = dp[x / 2] + 1;
					before[x] = x / 2;
				}
			}

			if (dp[x - 1] + 1 < dp[x]) {
				dp[x] = dp[x - 1] + 1;
				before[x] = x - 1;
			}
		}

		int result = dp[number];
		System.out.println(result);

		System.out.print(number + " ");
		int root = before[number];
		for (int i = 0; i < result; i++) {
			System.out.print(root + " ");
			root = before[root];
		}

	}
}
