import java.util.Scanner;

public class Baekjoon15953 {
	final static int[] prize2017 = {5000000, 3000000, 2000000, 500000, 300000, 100000};
	final static int[] winner2017 = {1, 3, 6, 10, 15, 21};
	final static int[] prize2018 = {5120000, 2560000, 1280000, 640000, 320000};
	final static int[] winner2018 = {1, 3, 7, 15, 31};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine().trim());
		int a[] = new int[T];
		int b[] = new int[T];
		int prize[] = new int[T];

		for (int i = 0; i < T; i++) {
			a[i] = sc.nextInt();
			b[i] = Integer.parseInt(sc.nextLine().trim());
		}

		for (int i = 0; i < T; i++) {
			for (int game2017 = 0; game2017 < prize2017.length; game2017++) {
				if (a[i] == 0) {
					continue;
				}

				if (a[i] <= winner2017[game2017]) {
					prize[i] += prize2017[game2017];
					break;
				}
			}
			for (int game2018 = 0; game2018 < prize2018.length; game2018++) {
				if (b[i] == 0) {
					continue;
				}

				if (b[i] <= winner2018[game2018]) {
					prize[i] += prize2018[game2018];
					break;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			System.out.println(prize[i]);
		}

	}
}
