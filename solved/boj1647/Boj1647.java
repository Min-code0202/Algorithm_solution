import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1647 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj1647().solution();
    }

    class Edge implements Comparable<Edge>{
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return this.w - o.w;
        }
    }

    int N, M;
    ArrayList<Edge> edges;
    int[] parent;

    int kruskal(){
        int mst = 0;
        int cnt = 0;
        int mx = 0;
        for(Edge e : edges){
            if(union(e.u, e.v)){
                mst += e.w;
                cnt++;
                mx = Math.max(mx, e.w);
                if(cnt == N - 1) break;
            }
        }

        return mst - mx;
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); 
            int v = Integer.parseInt(st.nextToken()); 
            int w = Integer.parseInt(st.nextToken()); 
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges);

        parent = new int[N + 1];
        for(int i  = 1; i <= N; i++){
            parent[i] = i;
        }

        System.out.println(kruskal());


        br.close();
    }

    int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parent[b] = a;
        return true;
    }
}