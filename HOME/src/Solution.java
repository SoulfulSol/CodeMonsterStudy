import java.util.*;

class Solution {
    int M;
    int N;
    int[][] dp;
    int answer;

    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 4;
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        s.solution(m, n, computers);
    }

    public int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        dp = new int[M + 1][N + 1];
        answer = 0;

        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i != 1) {
                    dp[i][j] += dp[i - 1][j] % 1000000007;
                }
                if (j != 1) {
                    dp[i][j] += dp[i][j - 1] % 1000000007;
                }
            }
        }

        answer = (int) dp[m][n] % 1000000007;
        return answer;
    }
}