    import java.util.Scanner;

	public class Baekjoon15486 {
		static int number;
		static int[] timeArr;
		static int[] payArr;
		static int[] dp;

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			number = Integer.parseInt(sc.nextLine().trim());
			timeArr = new int[1500001];
			payArr = new int[1500001];
			dp = new int[1500001];

			for (int i = 1; i <= number; i++) {
				timeArr[i] = sc.nextInt();
				payArr[i] = Integer.parseInt(sc.nextLine().trim());
			}

			calc();
			System.out.println(dp[number]);
		}

		public static void calc() {
			for (int index = 1; index <= number; index++) {

				int today = 0;
				if (timeArr[index] == 1) {
					today = payArr[index];
				}

				dp[index] = Math.max(dp[index - 1] + today, dp[index]);

				if (timeArr[index] != 1 && index + timeArr[index] - 1 < 1500001) {
					dp[index + timeArr[index] - 1] = Math.max(dp[index + timeArr[index] - 1], dp[index - 1] + payArr[index]);
				}

			}

		}
	}
