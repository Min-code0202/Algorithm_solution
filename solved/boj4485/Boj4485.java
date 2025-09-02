import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj4485 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj4485().solution();
    }

    class Node implements Comparable<Node>{
        int r, c, w;

        public Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    int N;
    int[][] arr;

    void solution() throws IOException{
        int tc = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0){
                wr.flush();
                br.close();
                wr.close();
                break;
            }

            arr = new int[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = dijk(0, 0);
            wr.write("Problem " + tc + ": " + ans + "\n");
            tc += 1;
        }
    }

    final int INF = 1_000_000_000;
    int[] di = {1, 0, -1, 0};
    int[] dj = {0, -1, 0, 1};

    int dijk(int si, int sj){
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++) Arrays.fill(dist[i], INF);
        dist[si][sj] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(si, sj, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.w > dist[cur.r][cur.c]) continue;
            for(int d = 0; d < 4; d++){
                int ni = cur.r + di[d];
                int nj = cur.c + dj[d];
                if(ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
                if(dist[ni][nj] > cur.w + arr[ni][nj]){
                    dist[ni][nj] = cur.w + arr[ni][nj];
                    pq.offer(new Node(ni, nj, dist[ni][nj]));
                }
            }
        }

        return dist[N - 1][N - 1] + arr[0][0];
    }
}
