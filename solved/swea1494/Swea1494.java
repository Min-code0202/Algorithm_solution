import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea1494 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea1494().solution();
    }

    int N;
    int[][] arr;
    boolean[] select;
    long ans;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            select = new boolean[N];
            ans = Long.MAX_VALUE;
            dfs(0, 0);
            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    void dfs(int depth, int idx){
        if(depth == N / 2){
            long x = 0;
            long y = 0;
            for(int i = 0; i < N; i++){
                if(select[i]){
                    x += arr[i][0];
                    y += arr[i][1];
                }else{
                    x -= arr[i][0];
                    y -= arr[i][1];
                }
            }
            ans = Math.min(ans, x * x + y * y);
            return;
        }
        if(idx == N) return;
        select[idx] = true;
        dfs(depth + 1, idx + 1);

        select[idx] = false;
        dfs(depth, idx + 1);
    }
}
