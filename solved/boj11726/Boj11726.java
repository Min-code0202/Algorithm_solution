import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj11726 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj11726().solution();
    }

    void solution() throws IOException{
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        if(n == 1){
            ans = 1;
        }else if(n == 2){
            ans = 2;
        }else{
            int[] dp =  new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3; i < n + 1; i++){
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
            ans = dp[n];
        }
        
        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}