import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea3307{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        new Swea3307().solution();
    }

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int[] dp = new int[N];
            Arrays.fill(dp, 1);
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < i; j++){
                    if(arr[i] > arr[j]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int ans = 0;
            for(int i = 0; i < N; i++) ans = Math.max(ans, dp[i]);

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }
}