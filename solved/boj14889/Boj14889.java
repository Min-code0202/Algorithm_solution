import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj14889 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj14889().solution();
    }

    int N;
    int[][] arr;
    boolean[] visited;
    int ans = Integer.MAX_VALUE;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        solve(0, 0);

        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    void solve(int depth, int cnt){
        if (depth == N) {
            if (cnt == N / 2) {
                int start = 0, link = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = i + 1; j < N; j++) {
                        if (visited[i] && visited[j]) {
                            start += arr[i][j] + arr[j][i];
                        } else if (!visited[i] && !visited[j]) {
                            link += arr[i][j] + arr[j][i];
                        }
                    }
                }
                ans = Math.min(ans, Math.abs(start - link));
            }
            return;
        }

        visited[depth] = true;
        solve(depth + 1, cnt + 1);
        visited[depth] = false;
        solve(depth + 1, cnt);
    
    }
}
