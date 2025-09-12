import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13424 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj13424().solution();
    }

    class Node implements Comparable<Node>{
        int to, w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    int N, M, K;
    ArrayList<Node>[] graph;
    int[] room;
    int[][] dist;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N + 1];
            for(int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[a].add(new Node(b, c));
                graph[b].add(new Node(a, c));
            }

            K = Integer.parseInt(br.readLine());
            room = new int[K + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) room[i] = Integer.parseInt(st.nextToken());

            dist = new int[N + 1][N + 1];
            for(int i = 1; i <= K; i++){
                Arrays.fill(dist[room[i]], INF);
                dijk(room[i]);
            }

            int[] sum = new int[N + 1];
            for(int i = 1; i < K + 1; i++){
                for(int j = 1; j < N + 1; j++){
                    sum[j] += dist[room[i]][j];
                }
            }

            int minSum = Integer.MAX_VALUE;
            int ans = -1;
            for (int i = 1; i <= N; i++) {
                if (sum[i] < minSum) {
                    minSum = sum[i];
                    ans = i;
                }
            }
            wr.write(ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    final int INF = 1_000_000_000;

    void dijk(int num){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[num][num] = 0;
        pq.offer(new Node(num, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.w > dist[num][cur.to]) continue;

            for(Node nxt : graph[cur.to]){
                if(dist[num][nxt.to] > nxt.w + dist[num][cur.to]){
                    dist[num][nxt.to] = nxt.w + dist[num][cur.to];
                    pq.offer(new Node(nxt.to, dist[num][nxt.to]));
                }
            }
        }
    }
}
