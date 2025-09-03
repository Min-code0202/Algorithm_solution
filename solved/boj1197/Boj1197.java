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

public class Boj1197{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1197().solution();
    }

    class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    int V, E;
    List<Node>[] graph;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        for(int i = 0; i < V + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, w));
            graph[to].add(new Node(from, w));
        }

        long ans = Prim(1);
        System.out.println(ans);
    }

    final int INF = 1_000_000_000;

    long Prim(int start){
        boolean[] visited = new boolean[V + 1];
        int[] minDist = new int[V + 1];
        Arrays.fill(minDist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        minDist[start] = 0;
        pq.offer(new Node(start, 0));

        long minW = 0;
        int cnt = 0;

        while(!pq.isEmpty() && cnt < V){
            Node cur = pq.poll();
            if(visited[cur.v]) continue;
            visited[cur.v] = true;
            minW += cur.w;
            cnt++;
            for(Node nxt : graph[cur.v]){
                if(!visited[nxt.v] && minDist[nxt.v] > nxt.w){
                    minDist[nxt.v] = nxt.w;
                    pq.offer(new Node(nxt.v, minDist[nxt.v]));
                }
            }
        }
        return minW;
    }
}