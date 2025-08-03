import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Node o){return this.w - o.w;}
}

public class Boj1238 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M;
    List<Node>[] graph;
    int[] dist;
    int[] dist2;
    final int INF = 1_000_000;

    void dijkstra(int start){
        dist = new int[N + 1]; 
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.v] < cur.w) continue;
            for(Node nxt : graph[cur.v]){
                if(dist[nxt.v] > nxt.w + cur.w){
                    dist[nxt.v] = nxt.w + cur.w;
                    pq.offer(new Node(nxt.v, dist[nxt.v]));
                }
            }
        }
    }

    int dijkstra(int start, int end){
        dist2 = new int[N + 1]; 
        Arrays.fill(dist2, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist2[start] = 0;
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.v == end) return cur.w;
            if(dist2[cur.v] < cur.w) continue;
            for(Node nxt : graph[cur.v]){
                if(dist2[nxt.v] > nxt.w + cur.w){
                    dist2[nxt.v] = nxt.w + cur.w;
                    pq.offer(new Node(nxt.v, dist2[nxt.v]));
                }
            }
        }
        return INF;
    }

    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

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
        }

        // X -> home
        dijkstra(X);
        // home -> x
        int max = 0;
        for(int i = 1; i <= N; i++){
            if(i == X) continue;
            int go = dijkstra(i, X); // i → X
            int back = dist[i];      // X → i 
            if(go != INF && back != INF)
                max = Math.max(max, go + back);
        }

        wr.write(max + "\n");

        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Boj1238().solution();
    }
}
