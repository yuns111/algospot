import java.util.Scanner;

public class PI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine().trim());

		for (int i = 0; i < testCase; i++) {
			String pi = sc.nextLine().trim();
			int dp[] = new int[pi.length()];

			getMinPoint(pi, dp);

			System.out.println(dp[pi.length() - 1]);
		}
	}

	private static void getMinPoint(String pi, int[] dp) {
		char[] piArray = pi.toCharArray();
		for (int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i < piArray.length; i++) {
			for (int j = i - 4; j <= i - 2; j++) {
				if (j < 0) {
					continue;
				}
				if (j - 1 >= 0 && dp[j - 1] == 0) {
					continue;
				}

				int pattern1 = pattern1(piArray, j, i);
				int pattern2 = Math.min(pattern2P(piArray, j, i), pattern2M(piArray, j, i));
				int pattern4 = pattern4(piArray, j, i);
				int pattern5 = pattern5(piArray, j, i);
				int pattern10 = pattern10(piArray, j, i);

				int min = getMinValue(pattern1, pattern2, pattern4, pattern5, pattern10) + (j - 1 < 0 ? 0 : dp[j - 1]);
				if (dp[i] >= min) {
					dp[i] = min;
				}
			}
		}
	}

	private static int getMinValue(int a, int b, int c, int d, int e) {
		return Math.min(Math.min(Math.min(Math.min(a, b), c), d), e);
	}

	private static int pattern1(char[] piArray, int startIndex, int endIndex) {
		if (piArray.length <= startIndex || piArray.length <= endIndex) {
			return Integer.MAX_VALUE;
		}

		for (int i = startIndex; i < endIndex; i++) {
			if (piArray[i] != piArray[i + 1]) {
				return Integer.MAX_VALUE;
			}
		}
		return 1;
	}

	private static int pattern2P(char[] piArray, int startIndex, int endIndex) {
		if (piArray.length <= startIndex || piArray.length <= endIndex) {
			return Integer.MAX_VALUE;
		}

		for (int i = startIndex; i < endIndex; i++) {
			if (piArray[i] + 1 != piArray[i + 1]) {
				return Integer.MAX_VALUE;
			}

		}
		return 2;
	}

	private static int pattern2M(char[] piArray, int startIndex, int endIndex) {
		if (piArray.length <= startIndex || piArray.length <= endIndex) {
			return Integer.MAX_VALUE;
		}

		for (int i = startIndex; i < endIndex; i++) {
			if (piArray[i] - 1 != piArray[i + 1]) {
				return Integer.MAX_VALUE;
			}
		}
		return 2;
	}

	private static int pattern4(char[] piArray, int startIndex, int endIndex) {
		if (piArray.length <= startIndex || piArray.length <= endIndex) {
			return Integer.MAX_VALUE;
		}

		for (int i = startIndex; i <= (startIndex + endIndex) / 2; i++) {
			if (i + 2 > endIndex) {
				break;
			}
			if (piArray[i] != piArray[i + 2]) {
				return Integer.MAX_VALUE;
			}
		}
		return 4;
	}

	private static int pattern5(char[] piArray, int startIndex, int endIndex) {
		if (piArray.length <= startIndex || piArray.length <= endIndex) {
			return Integer.MAX_VALUE;
		}

		int gap = piArray[startIndex] - piArray[startIndex + 1];
		for (int i = startIndex; i < endIndex; i++) {
			if (piArray[i] - piArray[i + 1] != gap) {
				return Integer.MAX_VALUE;
			}
		}
		return 5;
	}

	private static int pattern10(char[] piArray, int startIndex, int endIndex) {
		if (piArray.length <= startIndex || piArray.length <= endIndex) {
			return Integer.MAX_VALUE;
		}

		return 10;
	}
}
