import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int left;
    static int right;
    static long answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (left = 0; left < N - 1; left += 2) {
            if (arr[left] < 1 && arr[left + 1] < 1) {
                answer += arr[left] * arr[left + 1];
            } else {
                break;
            }
        }

        for (right = N - 1; right > 0; right -= 2) {
            if (arr[right] > 1 && arr[right - 1] > 1) {
                answer += arr[right] * arr[right - 1];
            } else {
                break;
            }
        }

        for (int i = left; i <= right; i++) {
            answer += arr[i];
        }

        System.out.println(answer);

    }

}
