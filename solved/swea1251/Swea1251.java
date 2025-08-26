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
    int u, v;
    double w;

    public Edge(int u, int v, double w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.w, o.w);
    }
}

public class Swea1251 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea1251().solution();
    }

    int N;
    int[] parents;
    double E;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            parents = new int[N];
            for(int i = 0; i < N; i++)  parents[i] = i;

            int[] X = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                X[i] = Integer.parseInt(st.nextToken());
            }

            int[] Y = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                Y[i] = Integer.parseInt(st.nextToken());
            }

            E = Double.parseDouble(br.readLine());

            List<Edge> edges = new ArrayList<>();
            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    double dis = Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2);
                    edges.add(new Edge(i, j, dis));
                }
            }
            Collections.sort(edges);

            double mstW = 0;
            int cnt = 0;
            for(Edge node : edges){
                if(!union(node.u, node.v)) continue;
                mstW += node.w;
                if(++cnt == N - 1) break;
            }

            long res = Math.round(E * mstW);
            wr.write("#" + tc + " " + res + "\n");
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
        parents[b] = a;
        return true;
    }
}
