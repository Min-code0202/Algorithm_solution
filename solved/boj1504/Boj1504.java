import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1504{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj1504().solution();
    }

    class Node implements Comparable<Node>{
        int v, w;
        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    int N, E, v1, v2;
    ArrayList<Node>[] graph;
    int[][] dist;
    final static int INF = 1_000_000_000;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        dist = new int[3][N + 1];
        for(int i = 0; i < 3; i++) Arrays.fill(dist[i], INF);

        // dist[0] = 시작점 1
        // dist[1] = v1에서 출발
        // dist[2] = v2에서 출발
        dijk(1, 0);
        dijk(v1, 1);
        dijk(v2, 2);

        long route1 = (long)dist[0][v1] + dist[1][v2] + dist[2][N]; // 1 → v1 → v2 → N
        long route2 = (long)dist[0][v2] + dist[2][v1] + dist[1][N]; // 1 → v2 → v1 → N

        long ans = Math.min(route1, route2);
        System.out.println(ans >= INF ? -1 : ans);
    }

    void dijk(int start, int idx){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[idx][start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.w > dist[idx][cur.v]) continue;

            for(Node nxt : graph[cur.v]){
                if(dist[idx][nxt.v] > dist[idx][cur.v] + nxt.w){
                    dist[idx][nxt.v] = dist[idx][cur.v] + nxt.w;
                    pq.offer(new Node(nxt.v, dist[idx][nxt.v]));
                }
            }
        }
    }
}
