import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] arr;
    static int[][] tmp;
    static boolean[][] visit;
    static int[][] drx;
    static int answer;
    static int div;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N + 1][M + 1];
        tmp = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        drx = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        while (div < 2) {

            melt();
            answer++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = tmp[i][j];
                }
            }

            div = 0;
            visit = new boolean[N + 1][M + 1];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && visit[i][j] == false) {
                        bfs(i, j);
                        div++;
                    }
                }
            }


            if (div == 0) {
                answer = 0;
                break;
            }

        }

        System.out.println(answer);

    }

    public static void melt() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = (int) arr[i][j];
                if (arr[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < drx.length; k++) {
                    int x = i + drx[k][0];
                    int y = j + drx[k][1];

                    if (x >= 0 && y >= 0 && x < N && y < M) {
                        if (arr[x][y] == 0 && tmp[i][j] > 0) {
                            tmp[i][j]--;
                        }
                    }

                }
            }
        }

    }

    public static class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void bfs(int a, int b) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a, b));
        visit[a][b] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < drx.length; i++) {
                int x = p.a + drx[i][0];
                int y = p.b + drx[i][1];

                if (x > 0 && y >0 && x < N && y < M) {
                    if (visit[x][y] == false) {
                        if (arr[x][y] != 0) {
                            visit[x][y] = true;
                            q.add(new Point(x, y));
                        }
                    }
                }
            }
        }

    }

}
