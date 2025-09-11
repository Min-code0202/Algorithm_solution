import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea5643Ver2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea5643Ver2().solution();
    }

    int N, M, adj[][];
    int cnt;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            adj = new int[N + 1][N + 1];

            for(int m = 0; m < M; m++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a][b] = 1;
            }

            int ans = 0;
            for(int i = 1; i <= N; i++){
                cnt = 0;
                boolean[] visited = new boolean[N + 1];
                gtDFS(i, visited); // 큰 학생 수
                ltDFS(i, visited); // 작은 학생 수
                if(cnt == N - 1) ++ans;
            }
            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
    }

    void gtDFS(int cur, boolean[] visited){
        visited[cur] = true;
        for(int i = 1; i <= N; i++){
            if(adj[cur][i] == 1 && !visited[i]){
                ++cnt;
                gtDFS(i, visited);
            }
        }
    }

    void ltDFS(int cur, boolean[] visited){
        visited[cur] = true;
        for(int i = 1; i <= N; i++){
            if(adj[i][cur] == 1 && !visited[i]){
                ++cnt;
                ltDFS(i, visited);
            }
        }
    }
}
