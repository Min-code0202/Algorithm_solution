import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1365 {
    public static void main(String[] args) throws IOException {
        new Boj1365().solution();
    }

    int N;
    int[] arr, dp;

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp = new int[N];
        int j = 0;

        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] > dp[j]) {
                dp[++j] = arr[i];
            } else {
                int idx = binarySearch(dp, 0, j, arr[i]);
                dp[idx] = arr[i];
            }
        }

        System.out.println(N - (j + 1));
    }

    int binarySearch(int[] dp, int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (dp[mid] < target) l = mid + 1;
            else r = mid;
        }
        return r;
    }
}
