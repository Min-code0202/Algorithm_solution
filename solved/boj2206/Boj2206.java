import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2206 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj2206().solution();
    }

    int N, M;
    int[][] arr;
    int[][][] dist;

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] read = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = read[j] - '0';
            }
        }

        int ans = dijkstra(0, 0);
        wr.write(ans + "\n");
        wr.flush();
    }

    int[] di = {1, -1, 0, 0};
    int[] dj = {0, 0, 1, -1};
    final int INF = 1_000_000_000;

    int dijkstra(int si, int sj) {
        dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        pq.offer(new int[]{si, sj, 0, 1}); // (i, j, w, cost)
        dist[si][sj][0] = 1;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int ci = cur[0], cj = cur[1], w = cur[2], cost = cur[3];

            if (ci == N - 1 && cj == M - 1) return cost;
            if (dist[ci][cj][w] < cost) continue;

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;

                // 빈칸
                if (arr[ni][nj] == 0 && dist[ni][nj][w] > cost + 1) {
                    dist[ni][nj][w] = cost + 1;
                    pq.offer(new int[]{ni, nj, w, cost + 1});
                }

                // 벽, 아직 안 부숨
                if (arr[ni][nj] == 1 && w == 0 && dist[ni][nj][1] > cost + 1) {
                    dist[ni][nj][1] = cost + 1;
                    pq.offer(new int[]{ni, nj, 1, cost + 1});
                }
            }
        }
        return -1;
    }
}
