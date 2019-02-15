import java.util.Scanner;

public class Tiling2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine().trim());

		for (int i = 0; i < testCase; i++) {
			long dp[] = new long[101];
			int num = Integer.parseInt(sc.nextLine().trim());

			dp[1] = 1;
			dp[2] = 2;

			for (int j = 3; j <= num; j++) {
				dp[j] = (dp[j - 1] + dp[j - 2]) % 1000000007;
			}

			System.out.println(dp[num]);
		}
	}
}
