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

public class Swea1251_Prim {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea1251_Prim().solution();
    }

    class Edge implements Comparable<Edge> {
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    int N, X[], Y[];
    double E;
    List<Edge>[] adj;

    long Prim(int startVertex) {
        boolean[] visited = new boolean[N];
        long[] minEdge = new long[N];
        Arrays.fill(minEdge, Long.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        minEdge[startVertex] = 0; 
        pq.offer(new Edge(startVertex, 0));

        long mstWeight = 0;
        int count = 0;

        while (!pq.isEmpty() && count < N) {
            Edge current = pq.poll();

            if (visited[current.to]) continue; 
            
            visited[current.to] = true;
            mstWeight += current.weight;
            count++;

            for (Edge next : adj[current.to]) {
                if (!visited[next.to] && next.weight < minEdge[next.to]) {
                    minEdge[next.to] = next.weight;
                    pq.offer(new Edge(next.to, next.weight));
                }
            }
        }
        return mstWeight;
    }

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            X = new int[N];
            Y = new int[N];
            adj = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
            }

            StringTokenizer stX = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(stX.nextToken());
            }

            StringTokenizer stY = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                Y[i] = Integer.parseInt(stY.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    long dx = X[i] - X[j];
                    long dy = Y[i] - Y[j];
                    long weight = dx * dx + dy * dy;
                    adj[i].add(new Edge(j, weight));
                    adj[j].add(new Edge(i, weight));
                }
            }

            E = Double.parseDouble(br.readLine());

            long L = Prim(0); 
            long ans = Math.round(E * L); 
            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }
}