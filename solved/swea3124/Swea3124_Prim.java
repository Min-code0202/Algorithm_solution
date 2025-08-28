import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea3124 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea3124().solution();
    }
    
    class Node implements Comparable<Node>{
        int u, w;

        public Node(int u, int w) {
            this.u = u;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    List<Node>[] graph;

    long prim(int V, int s){
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));

        long mstW = 0;
        int cnt = 0;
        while(!pq.isEmpty() && cnt < V){
            Node cur = pq.poll();

            if(visited[cur.u]) continue;
            visited[cur.u] = true;
            cnt++;
            mstW += cur.w;

            for(Node nxt : graph[cur.u]){
                if(!visited[nxt.u]){
                    pq.offer(new Node(nxt.u, nxt.w));
                }
            }
        }

        return mstW;
    }

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[V + 1];
            for(int i = 1; i <= V; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                graph[a].add(new Node(b, c));
                graph[b].add(new Node(a, c));
            }

            long mstW = prim(V, 1);
            wr.write("#" + tc + " " + mstW + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }
}
