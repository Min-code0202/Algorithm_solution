import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Swea1249 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea1249().solution();
    }

    int N;
    int[][] arr;
    int[][] dist;

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                char[] read = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = read[j] - '0';
                }
            }

            dijkstra(0, 0);

            wr.write("#" + tc + " " + dist[N - 1][N - 1] + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int[] di = {1, 0, -1, 0};
    int[] dj = {0, -1, 0, 1};

    void dijkstra(int si, int sj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        dist[si][sj] = 0;

        pq.offer(new int[]{si, sj, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int ci = cur[0];
            int cj = cur[1];
            int cost = cur[2];

            if (cost > dist[ci][cj]) continue;

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N) {
                    if (dist[ni][nj] > cost + arr[ni][nj]) {
                        dist[ni][nj] = cost + arr[ni][nj];
                        pq.offer(new int[]{ni, nj, dist[ni][nj]});
                    }
                }
            }
        }
    }
}
