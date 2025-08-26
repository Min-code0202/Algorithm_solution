import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1922 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1922().solution();
    }

    class Edge implements Comparable<Edge>{
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }


    int N, M;
    int[] parents;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for(int i = 1; i < N + 1; i++) parents[i] = i;

        StringTokenizer st;
        List<Edge> edges = new ArrayList<>();
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);

        int cnt = 0;
        int mstW = 0;
        for(Edge e : edges){
            if(!union(e.u, e.v)) continue;
            mstW += e.w;
            if(++cnt == N - 1) break;
        }

        wr.write(mstW + "\n");
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
        parents[b] = a;
        return true;
    }
}
