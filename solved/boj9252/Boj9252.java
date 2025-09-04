import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj9252 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj9252().solution();
    }

    void solution() throws IOException {
        char[] ch = br.readLine().toCharArray();
        char[] ch2 = br.readLine().toCharArray();

        int n = ch.length;
        int m = ch2.length;

        int[][] dp = new int[n + 1][m + 1];

        // LCS 길이 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (ch[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // LCS 복원
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (ch[i - 1] == ch2[j - 1]) { // 문자가 같으면 대각선 이동
                ans.append(ch[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--; // 위쪽으로 이동
            } else {
                j--; // 왼쪽으로 이동
            }
        }

        ans.reverse(); // 거꾸로 만들었으니 뒤집기

        wr.write(dp[n][m] + "\n");
        wr.write(ans.toString() + "\n");
        wr.flush();
    }
}