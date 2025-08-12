import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    int[][] arr;

    int[][] dr = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] visited; // 방문배열
    int ans = 0;

    void bfs(int si, int sj, int rain){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj});
        visited[si][sj] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];
            for(int[] d : dr){
                int ni = ci + d[0];
                int nj = cj + d[1];
                if(0 <= ni && ni < N && 0 <= nj && nj < N && arr[ni][nj] > rain && visited[ni][nj] == 0){
                    visited[ni][nj] = 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }

    void solve(int rain){
        int cnt = 0;
        visited = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] > rain && visited[i][j] == 0){
                    bfs(i, j, rain);
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }

    public void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        int rain = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                rain = Math.max(rain, arr[i][j]);
            }
        }

        for(int i = 0; i < rain; i++){
            solve(i);
        }

        wr.write(ans + "\n");

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
