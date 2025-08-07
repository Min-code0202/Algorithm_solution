import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int v, w;
    public Node(int v, int w) { this.v = v; this.w = w; }
    @Override
    public int compareTo(Node o) { return this.w - o.w; }
}

public class Boj1753 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int V, E;
    List<Node>[] graph;
    int[] dist;
    final int INF = 1_000_000_000;

    void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.v] < cur.w) continue;

            for (Node next : graph[cur.v]) {
                if (dist[next.v] > cur.w + next.w) {
                    dist[next.v] = cur.w + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());  
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);  
    }

    public static void main(String[] args) throws IOException {
        new Boj1753().solution();
    }
}
