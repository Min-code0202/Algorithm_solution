import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea3282 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea3282().solution();
    }

    int N, K;
    int V[], C[];

    void solution() throws IOException{
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            V = new int[N + 1];
            C = new int[N + 1];

            for(int i = 1; i < N + 1; i++){
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][K + 1];
            for(int i = 1; i < N + 1; i++){
                for(int j = 1; j < K + 1; j++){
                    if(j < V[i]) dp[i][j] = dp[i - 1][j];
                    else{
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - V[i]] + C[i]);
                    }
                }
            }

            wr.write("#" + tc + " " + dp[N][K] + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }
}
