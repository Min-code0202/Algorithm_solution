import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class Boj1238Ver2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M, X;
    List<Node>[] graph;
    List<Node>[] reverseGraph;
    final int INF = 1_000_000;

    int[] dijkstra(List<Node>[] g, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.v] < cur.w) continue;
            for (Node nxt : g[cur.v]) {
                if (dist[nxt.v] > nxt.w + cur.w) {
                    dist[nxt.v] = nxt.w + cur.w;
                    pq.offer(new Node(nxt.v, dist[nxt.v]));
                }
            }
        }
        return dist;
    }

    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));          // 정방향 그래프
            reverseGraph[v].add(new Node(u, w));   // 역방향 그래프
        }

        // X -> i (정방향)
        int[] to = dijkstra(graph, X);
        // i -> X (역방향)
        int[] from = dijkstra(reverseGraph, X);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            if (to[i] != INF && from[i] != INF)
                max = Math.max(max, to[i] + from[i]);
        }

        wr.write(max + "\n");

        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Boj1238Ver2().solution();
    }
}