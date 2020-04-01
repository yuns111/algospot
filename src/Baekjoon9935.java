import java.util.Scanner;

public class Baekjoon9935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine().trim();
		String bomb = sc.nextLine().trim();

		while (string.indexOf(bomb) > -1) {
			string = string.replaceAll(bomb, "");
		}

		if (string.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(string);
		}
	}
}
