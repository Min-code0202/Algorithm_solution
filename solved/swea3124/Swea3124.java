import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }
    
}

public class Swea3124 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea3124().solution();
    }

    int V, E;

    int[] parents;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            parents = new int[V + 1];
            for(int i = 1; i < V + 1; i++){
                parents[i] = i;
            }
            List<Edge> edges = new ArrayList<>();
            while(E-- >0){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                edges.add(new Edge(u, v, w));
            }

            Collections.sort(edges);

            long mstW = 0;
            int cnt = 0;

            for(Edge e : edges){
                if(!union(e.u, e.v)) continue;
                mstW += e.w;
                if(++cnt == V - 1) break;
            }

            wr.write("#" + tc + " " + mstW + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        if(a != b) parents[b] = a;
        return true;
    }
}
