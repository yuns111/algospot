import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wildcard {
	static List<String> result = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < testCase; i++) {
			String wildCard = sc.nextLine();

			int fileNum = Integer.parseInt(sc.nextLine());
			for (int j = 0; j < fileNum; j++) {
				String fileName = sc.nextLine();

				if (compare(wildCard, fileName)) {
					result.add(fileName);
				}
			}
			result.sort(String::compareTo);
			for (String resultString : result) {
				System.out.println(resultString);
			}
		}
	}

	public static boolean compare(String wildCard, String fileName) {
		char[] wildCardArr = wildCard.toCharArray();
		char[] fileNameArr = fileName.toCharArray();

		int wildCardIndex = 0;
		int fileNameIndex = 0;

		while (wildCardIndex < wildCardArr.length && fileNameIndex < fileNameArr.length) {
			if (wildCardArr[wildCardIndex] == '?') {
				wildCardIndex++;
				fileNameIndex++;
			} else if (wildCardArr[wildCardIndex] == fileNameArr[fileNameIndex]) {
				wildCardIndex++;
				fileNameIndex++;
			} else if (wildCardArr[wildCardIndex] == '*') {
				wildCardIndex++;
			} else {
				fileNameIndex++;
			}
		}

		if (wildCardIndex == fileNameIndex) {
			return true;
		}

		if (fileNameIndex == fileNameArr.length - 1) {
			return false;
		}

		if (wildCardIndex == wildCardArr.length - 1) {
			return true;
		}

		return true;
	}
}
