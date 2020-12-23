import java.util.*;

public class Main {

    static int T;
    static int N;
    static int[] arr;
    static boolean[] visit;
    static boolean[] finish;
    static int answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            answer = 0;
            N = sc.nextInt();
            arr = new int[N + 1];
            visit = new boolean[N + 1];
            finish = new boolean[N + 1];

            for (int i = 1; i < N + 1; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 1; i < N + 1; i++) {
                if (visit[i] == false) {
                    dfs(i);
                }
            }

            System.out.println(N - answer);
        }

    }

    public static void dfs(int now) {

        visit[now] = true;
        int next = arr[now];

        if (visit[next] == false) {
            dfs(next);
        } else if (finish[next] == false) {
            for (int i = next; i != now; i = arr[i]) {
                answer++;
            }
            answer++;
        }

        finish[now] = true;

    }
}