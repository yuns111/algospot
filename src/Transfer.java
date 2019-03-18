import java.util.ArrayDeque;
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
        }


        int startX = -1;
        boolean[][] visitedTube = new boolean[tube][connectNum];

        for (int x = 0; x < tube; x++) {
            for (int y = 0; y < connectNum; y++) {
                if (tubePath[x][y] == 1) {
                    startX = x;
                    queue.add(new Path(startX, y));
                    visitedTube[x][y] = true;
                    break;
                }
            }
        }

        if (startX == -1) {
            System.out.println(-1);
            return;
        }

        boolean[] seekSameNum = new boolean[station];

        while (!queue.isEmpty()) {
            Path beforePath = queue.remove();

            for (int y = 0; y < connectNum; y++) {
                if (!visitedTube[beforePath.x][y]) {
                    queue.add(new Path(beforePath.x, y, beforePath.cnt + 1));
                    visitedTube[beforePath.x][y] = true;

                    if (tubePath[beforePath.x][y] == station) {
                        System.out.println(beforePath.cnt + 1);
                        return;
                    }
                }
            }

            if (!seekSameNum[tubePath[beforePath.x][beforePath.y] - 1]) {
                for (int x = 0; x < tube; x++) {
                    for (int y = 0; y < connectNum; y++) {
                        if (beforePath.x == x && beforePath.y == y) {
                            continue;
                        }

                        if (tubePath[x][y] == tubePath[beforePath.x][beforePath.y] && !visitedTube[x][y]) {
                            queue.add(new Path(x, y, beforePath.cnt));
                            visitedTube[x][y] = true;
                            seekSameNum[tubePath[x][y] - 1] = true;
                        }
                    }
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
