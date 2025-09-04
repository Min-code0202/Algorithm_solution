import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj9251 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj9251().solution();
    }

    void solution() throws IOException {
        char[] ch1 = br.readLine().toCharArray();
        char[] ch2 = br.readLine().toCharArray();

        int n = ch1.length;
        int m = ch2.length;
        int[][] dp = new int[n + 1][m + 1]; // dp[i][j] : ch1의 앞 i개, ch2의 앞 j개 고려했을 때 LCS 길이

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {  
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 문자가 같으면 대각선 값 + 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 다르면 위쪽, 왼쪽 중 큰 값
                }
            }
        }

        wr.write(String.valueOf(dp[n][m])); // LCS 길이 출력
        wr.flush();
    }
}
