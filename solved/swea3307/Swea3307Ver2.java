import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea3307Ver2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea3307Ver2().solution();
    }

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int[] dp = new int[N];
            int len = 0; // LIS 길이

            for (int i = 0; i < N; i++) {
                int pos = binary(0, len, dp, arr[i]);
                dp[pos] = arr[i];
                if (pos == len) len++;
            }

            wr.write("#" + tc + " " + len + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int binary(int l, int r, int[] dp, int target) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (dp[mid] < target) l = mid + 1;
            else r = mid;
        }
        return r;
    }
}
