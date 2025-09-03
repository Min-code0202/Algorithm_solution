import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj2133 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj2133().solution();
    }

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[31];
        dp[0] = 1;
        dp[2] = 3;
        
        for(int i = 4; i < N + 1; i = i + 2){
            dp[i] = dp[i - 2] * 3;
            for(int j = i - 4; j > -1; j = j - 2){
                dp[i] += dp[j] * 2;
            }
        }

        wr.write(dp[N] + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
