import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj140501_DP {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj140501_DP().solution();
    }

    int N, T[], P[];

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];
        for (int i = N; i > 0; i--) {
            if (i + T[i] <= N + 1) {
                dp[i] = Math.max(dp[i + 1], dp[i + T[i]] + P[i]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        wr.write(dp[1] + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
