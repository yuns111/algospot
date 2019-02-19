import java.util.Scanner;

public class JumpGame {
	private static int[][] game;
	private static boolean[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine().trim());

		for (int i = 0; i < testCase; i++) {
			int row = Integer.parseInt(sc.nextLine().trim());

			game = new int[row][row];
			dp = new boolean[100][100];
			dp[0][0] = true;

			for (int j = 0; j < row; j++) {
				for (int k = 0; k < row - 1; k++) {
					game[j][k] = sc.nextInt();

				}
				game[j][row - 1] = Integer.parseInt(sc.nextLine().trim());
			}

			jumpGame();

			if (dp[game.length-1][game.length-1]) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static void jumpGame() {
		for (int x = 0; x < game.length; x++) {
			for (int y = 0; y < game.length; y++) {
				int jump = game[x][y];

				if (!dp[x][y]) {
					continue;
				}

				if (x + jump < game.length) {
					dp[x + jump][y] = true;
				}

				if (y + jump < game.length) {
					dp[x][y + jump] = true;
				}
			}
		}
	}
}
