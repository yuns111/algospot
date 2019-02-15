import java.util.Scanner;

public class TriPathCnt {
	private static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < testCase; i++) {
			int triangleSize = Integer.parseInt(sc.nextLine());
			int[][] triangle = new int[triangleSize][triangleSize];

			for (int x = 0; x < triangleSize; x++) {
				for (int y = 0; y < x; y++) {
					triangle[x][y] = sc.nextInt();
				}
				triangle[x][x] = Integer.parseInt(sc.nextLine().trim());

			}
			dp = triangle.clone();
			System.out.println(findMax(triangleSize));
		}
	}

	private static int findMax(int triangleSize) {
		for (int i = 0; i < triangleSize; i++) {
			for (int j = 0; j < triangleSize; j++) {
				int big = dp[i][j];

				if (i == 0) {
					dp[i][j] = dp[i][j];
				} else {
					if (j == 0) {
						big = big + dp[i - 1][j];
					} else {
						big = big + (dp[i - 1][j] > dp[i - 1][j - 1] ? dp[i - 1][j] : dp[i - 1][j - 1]);
					}

					dp[i][j] = big;
				}
			}
		}

		int max = 0;
		int maxCount = 1;
		for (int i = 0; i < triangleSize; i++) {
			if (max < dp[triangleSize - 1][i]) {
				max = dp[triangleSize - 1][i];
				maxCount = 1;
			}

			if (max == dp[triangleSize - 1][i]) {
				maxCount++;
			}
		}

		return maxCount;
	}
}
