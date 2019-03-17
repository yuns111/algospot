import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Transfer {
    public static void main(String[] args) {
        Queue<Path> queue = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        int station = sc.nextInt();
        int connectNum = sc.nextInt();
        int tube = Integer.parseInt(sc.nextLine().trim());

        int[][] tubePath = new int[tube][connectNum];

        for (int i = 0; i < tube; i++) {
            for (int j = 0; j < connectNum; j++) {
                tubePath[i][j] = sc.nextInt();
            }
            Arrays.sort(tubePath[i]);
        }


        int startX = -1;
        int startY = -1;

        for (int x = 0; x < tube; x++) {
            for (int y = 0; y < connectNum; y++) {
                if (tubePath[x][y] == 1) {
                    startX = x;
                    startY = y;
                    queue.add(new Path(startX, startY));
                }
            }
        }

        if (startX == -1) {
            System.out.println(-1);
            return;
        }

        boolean[] visited = new boolean[station];
        visited[0] = true;


        while (!queue.isEmpty()) {
            Path beforePath = queue.remove();

            for (int y = 0; y < connectNum; y++) {
                if (!visited[tubePath[beforePath.x][y]]) {
                    queue.add(new Path(beforePath.x, y, beforePath.cnt + 1));
                    visited[tubePath[beforePath.x][y]] = true;

                    if(visited[station-1]) {
                        System.out.println(beforePath.cnt + 1);
                        return;
                    }
                }
            }

            for (int x = 0; x < connectNum; x++) {
                if (!visited[tubePath[x][beforePath.y]]) {
                    queue.add(new Path(x, beforePath.y, beforePath.cnt));
                    visited[tubePath[x][beforePath.y]] = true;
                }
            }
        }

        System.out.println(-1);
    }

    static class Path {
        int x;
        int y;
        int cnt = 1;

        Path(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Path(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
