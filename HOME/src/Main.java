import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int N;
    static String[] arr;
    static StringBuilder answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new String[N];
            answer = new StringBuilder();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = st.nextToken();
            }

            Arrays.sort(arr);

            for (int i = 1; i < N; i++) {
                if (arr[i].startsWith(arr[i - 1])) {
                    answer.append("NO");
                    break;
                }
            }

            if (!answer.toString().equals("NO")) {
                answer.append("YES");
            }

            System.out.println(answer.toString());

        }

    }

}
