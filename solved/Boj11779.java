import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int v, w;
    public Node(int v, int w){this.w = w; this.v = v;}
    @Override
    public int compareTo(Node o){return this.w - o.w;}
}

public class Boj11779 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int n, m;
    List<Node>[] graph;
    int[] dist;
    final int INF = 1_000_000_000;
    int[] prev;

    void dijkstra(int start){
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.v] < cur.w) continue;
            
            for(Node nxt : graph[cur.v]){
                if(dist[nxt.v] > nxt.w + cur.w){
                    dist[nxt.v] = nxt.w + cur.w;
                    prev[nxt.v] = cur.v;
                    pq.add(new Node(nxt.v, dist[nxt.v]));
                }
            }
        }
    }

    List<Integer> getPath(int start, int end){
        List<Integer> path = new ArrayList<>();
        for(int cur = end; cur != -1; cur = prev[cur]){
            path.add(cur);
            if(cur == start) break;
        }
        Collections.reverse(path);
        return path;
    }

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dist = new int[n + 1];
        prev = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        wr.write(dist[end] + "\n");
        List<Integer> path = getPath(start, end);
        wr.write(path.size() + "\n");
        for(int node : path) wr.write(node + " ");

        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Boj11779().solution();
    }
}
