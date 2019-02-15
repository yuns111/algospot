import java.util.Scanner;

public class Jlis {
	static int[] A;
	static int[] B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < testCase; i++) {
			int aLength = sc.nextInt();
			int bLength = sc.nextInt();

			A = new int[aLength];
			B = new int[bLength];
			int[] dpA = new int[aLength];
			int[] dpB = new int[bLength];

			for (int j = 0; j < aLength; j++) {
				A[j] = sc.nextInt();
				dpA[j] = 1;
			}

			for (int j = 0; j < aLength; j++) {
				for (int k = 0; k < j; k++) {
					if (A[k] < A[j] && dpA[k] + 1 > dpA[j]) {
						dpA[j] = dpA[k] + 1;
					}
				}
			}

			for (int j = 0; j < bLength; j++) {
				for (int k = 0; k < j; k++) {
					if (B[k] < B[j] && dpB[k] + 1 > dpB[j]) {
						dpB[j] = dpB[k] + 1;
					}
				}
			}

		}
	}
}
