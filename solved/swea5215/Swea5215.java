import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea5215 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea5215().solution();
    }

    int N, L;
    int T[], K[];

    void solution() throws IOException{
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            T = new int[N + 1];
            K = new int[N + 1];

            for(int i = 1; i < N + 1; i++){
                st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][L + 1];
            for(int i = 1; i < N + 1; i++){
                for(int j = 1; j < L + 1; j++){
                    if(j < K[i]) dp[i][j] = dp[i - 1][j];
                    else{
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - K[i]] + T[i]);
                    }
                }
            }

            wr.write("#" + tc + " " + dp[N][L] + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }
}
