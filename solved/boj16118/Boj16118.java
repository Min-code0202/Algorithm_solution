import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj16118 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj16118().solution();
    }

    class Node implements Comparable<Node> {
        int to, w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    int N, M;
    ArrayList<Node>[] graph;
    final int INF = 1_000_000_000;
    int[] dist;       // 여우 거리
    int[][] dist2;    // 늑대 거리 [0] 빠름, [1] 느림

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()) * 2;

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w)); // 무방향
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dijkstraFox(1);

        dist2 = new int[2][N + 1];
        for (int i = 0; i < 2; i++) Arrays.fill(dist2[i], INF);
        dijkstraWolf(1);

        int ans = 0;
        for (int i = 2; i <= N; i++) {
            if (dist[i] < Math.min(dist2[0][i], dist2[1][i])) ans++;
        }

        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    void dijkstraFox(int start) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.to]) continue;

            for (Node nxt : graph[cur.to]) {
                if (dist[nxt.to] > cur.w + nxt.w) {
                    dist[nxt.to] = cur.w + nxt.w;
                    pq.offer(new Node(nxt.to, dist[nxt.to]));
                }
            }
        }
    }

    void dijkstraWolf(int start) {
        dist2[0][start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start, 0, 0}); // {노드, 모드, 비용}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int mode = cur[1];
            int cost = cur[2];

            if (cost > dist2[mode][u]) continue;

            for (Node nxt : graph[u]) {
                int nextMode = 1 - mode;
                int nextCost = (mode == 0) ? cost + nxt.w / 2 : cost + nxt.w * 2;

                if (dist2[nextMode][nxt.to] > nextCost) {
                    dist2[nextMode][nxt.to] = nextCost;
                    pq.offer(new int[]{nxt.to, nextMode, nextCost});
                }
            }
        }
    }
}
