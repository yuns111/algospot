import java.util.Scanner;

public class Lis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < testCase; i++) {
			int length = sc.nextInt();

			int[] array = new int[length];
			int[] dp = new int[length];

			for (int j = 0; j < length; j++) {
				array[j] = sc.nextInt();
				dp[j] = 1;
			}

			for (int j = 0; j < length; j++) {
				for (int k = 0; k < j; k++) {
					if (array[k] < array[j] && dp[k] + 1 > dp[j]) {
						dp[j] = dp[k] + 1;
					}
				}
			}

			int max = 0;
			for (int aDp : dp) {
				if (max < aDp) {
					max = aDp;
				}
			}
			System.out.println(max);
		}
	}
}
