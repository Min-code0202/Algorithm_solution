import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1261 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1261().solution();
    }

    int N, M;
    int[][] arr;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            char[] read = br.readLine().toCharArray();
            int idx = 0;
            for(char ch : read){
                arr[i][idx++] = ch - '0';
            }
        }

        int ans = dijk(0, 0);
        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    final int INF = 1_000_000_000;
    int[] di = {1, 0, -1, 0};
    int[] dj = {0, -1, 0, 1};
    int dijk(int si, int sj){
        int[][] dist = new int[N][M];
        for(int i = 0; i < N; i++) Arrays.fill(dist[i], INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        pq.offer(new int[]{si, sj, 0});
        dist[si][sj] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int ci = cur[0];
            int cj = cur[1];
            if(cur[2] > dist[ci][cj]) continue;
            for(int d = 0; d < 4; d++){
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                if(dist[ni][nj] > cur[2] + arr[ni][nj]){
                    dist[ni][nj] = cur[2] + arr[ni][nj];
                    pq.offer(new int[]{ni, nj, dist[ni][nj]});
                }
            }
        }

        return dist[N - 1][M - 1];
    }
}
