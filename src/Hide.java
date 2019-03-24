import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Hide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] root = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            root[x][y] = true;
            root[y][x] = true;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int[] count = new int[n + 1];

        queue.add(1);

        while (!queue.isEmpty()) {
            int before = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (root[before][i] && count[i] == 0) {
                    count[i] = count[before] + 1;
                    queue.add(i);
                }
            }
        }

        int maxPath = 0;
        int minNum = 999999;
        for (int i = n; i >= 2; i--) {
            if (count[i] >= maxPath) {
                maxPath = count[i];
                minNum = i;
            }
        }

        int samePath = 0;
        for (int i = 2; i <= n; i++) {
            if (count[i] == maxPath) {
                samePath++;
            }
        }

        System.out.println(minNum + " " + maxPath + " " + samePath);
    }
}

