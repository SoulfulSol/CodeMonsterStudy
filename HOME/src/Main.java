import java.util.*;

public class Main {

    static int N;
    static int[] dp;
    static int answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int now = sc.nextInt();
            dp[now] = dp[now - 1] + 1;
        }

        Arrays.sort(dp);
        answer = N - dp[N];

        System.out.println(answer);

    }

}
