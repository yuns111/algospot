import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Bridge {
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        int[][] map = new int[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                map[x][y] = sc.nextInt();
            }
        }

        Queue<Point> queue = new ArrayDeque<>();
        Queue<Point> island = new ArrayDeque<>();
        int islandCount = 0;
        boolean[][] visited = new boolean[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (map[x][y] == 1 && !visited[x][y]) {
                    queue.add(new Point(x, y));
                    island.add(new Point(x, y));
                    islandCount++;
                    visited[x][y] = true;
                    map[x][y] = islandCount;
                }

                while (!queue.isEmpty()) {
                    Point before = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = before.x + dx[k];
                        int ny = before.y + dy[k];

                        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                                island.add(new Point(nx, ny));
                                queue.add(new Point(nx, ny));
                                map[nx][ny] = islandCount;
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

        int[][] count = new int[map.length][map.length];
        int min = Integer.MAX_VALUE;

        while (!island.isEmpty()) {
            Point before = island.poll();

            if (isEdge(map, before)) {
                int result = bfs(map, before, count);
                if(min > result) {
                    min = result;
                }
            }
        }
        System.out.println(min);
    }

    private static int bfs(int[][] map, Point point, int[][] visited) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(point);

        while (!queue.isEmpty()) {
            Point before = queue.poll();

            if (map[before.x][before.y] != map[point.x][point.y] && map[before.x][before.y] > 0) {
                return visited[before.x][before.y];
            }

            for (int k = 0; k < 4; k++) {
                int nx = before.x + dx[k];
                int ny = before.y + dy[k];

                if (0 <= nx && nx < map.length && 0 <= ny && ny < map.length) {
                    if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
                        queue.add(new Point(nx, ny));
                        visited[nx][ny] = visited[before.x][before.y] + 1;
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean isEdge(int[][] map, Point point) {
        if (point.x - 1 >= 0 && map[point.x - 1][point.y] == 0) {
            return true;
        }
        if (point.x + 1 < map.length && map[point.x + 1][point.y] == 0) {
            return true;
        }
        if (point.y - 1 >= 0 && map[point.x][point.y - 1] == 0) {
            return true;
        }
        if (point.y + 1 < map.length && map[point.x][point.y + 1] == 0) {
            return true;
        }

        return false;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
