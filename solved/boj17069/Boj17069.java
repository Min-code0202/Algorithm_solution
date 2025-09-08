import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[3][N][N];
        dp[0][0][1] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (arr[i][j] == 1) continue;

                // 가로
                dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];

                // 세로
                if (i > 0)
                    dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];

                // 대각선
                if (i > 0 && arr[i - 1][j] == 0 && arr[i][j - 1] == 0)
                    dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
            }
        }

        long result = dp[0][N - 1][N - 1] + dp[1][N - 1][N - 1] + dp[2][N - 1][N - 1];
        System.out.println(result);
    }
}
