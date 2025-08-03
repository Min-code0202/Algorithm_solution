import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int v, w;
    public Node(int v, int w){this.v = v; this.w = w;}
    @Override
    public int compareTo(Node o){return this.w - o.w;}
}

public class Dijk {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M;
    List<Node>[] graph;
    int[] dist;
    final int INF = 1_000_000_000;

    void Dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.v] < cur.w) continue;

            for(Node next : graph[cur.v]){
                if(dist[next.v] > cur.w + next.w){
                    dist[next.v] = cur.w + next.w; // dist[cur.v] + next.w 이것도 가능
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];            
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            // 양방향 그래프라면 아래 라인 유지
            graph[v].add(new Node(u, w));
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        int start = Integer.parseInt(br.readLine());
        Dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);

        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException{
        new Dijk().solution();
    }
}
