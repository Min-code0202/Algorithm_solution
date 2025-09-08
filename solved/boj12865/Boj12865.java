package solved.boj12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj12865 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj12865().solution();
    }

    int N, K;
    int W[], V[];

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        W = new int[N + 1];
        V = new int[N + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];
        // 물건을 담을 수 없는 경우 j < W 이면
        // dp[i][j] = dp[i - 1][j]
        // 물건을 담을 수 있는 경우 j >= W 이면
        // dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V)

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(W[i] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
