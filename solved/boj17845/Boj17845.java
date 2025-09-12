import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj17845 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj17845().solution();
    }

    int N, K;
    int important[], time[];

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        important = new int[K + 1];
        time = new int[K + 1];
        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            important[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[K + 1][N + 1];
        for(int i = 1; i < K + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if(time[i] > j) dp[i][j] = dp[i - 1][j];
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i]] + important[i]);
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}
