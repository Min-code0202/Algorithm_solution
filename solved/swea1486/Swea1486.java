import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea1486 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        new Swea1486().solution();
    }

    int ans;
    int N, B, H[];

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            H = new int[N];
            for(int i = 0; i < N; i++){
                H[i] = Integer.parseInt(st.nextToken());
            }

            ans = Integer.MAX_VALUE;
            solve(0, 0);


            wr.write("#" + tc + " " + ans + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    void solve(int depth, int sum){
        if(depth == N){
            if(sum >= B){
                ans = Math.min(ans, sum - B);
            }
            return;
        }

        solve(depth + 1, sum + H[depth]);
        solve(depth + 1, sum);
    }
}
