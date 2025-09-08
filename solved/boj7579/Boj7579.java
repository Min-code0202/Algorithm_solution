import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj7579 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj7579().solution();
    }

    int N, M;
    int m[], c[];

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        m = new int[N + 1];
        c = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) m[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }        

        int[][] dp = new int[N + 1][10001];
        
        int ans = 1_000_000;
        for(int i = 1; i < N + 1; i++){
            for(int j = 0; j < 10001; j++){
                if(j < c[i]) dp[i][j] = dp[i - 1][j];
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
                }
                if(dp[i][j] >= M) ans = Math.min(ans, j);
            }
        }

        System.out.println(ans);
    }
}
