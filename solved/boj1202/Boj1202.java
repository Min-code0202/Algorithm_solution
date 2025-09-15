import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1202 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1202().solution();
    }
    
    class Node implements Comparable<Node>{
        int m, v;

        public Node(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.v, this.v);
        }
    }

    int N, K;
    int[] C;
    Node[] jewel;
    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = new int[K];
        jewel = new Node[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewel[i] = new Node(M, V);
        }

        for(int i = 0; i < K; i++){
            C[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(jewel, (a, b) -> a.m - b.m);
        Arrays.sort(C);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        int j = 0;

        for(int i = 0; i < K; i++){
            while(j < N && jewel[j].m <= C[i]){
                pq.offer(jewel[j].v);
                j++;
            }

            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }

        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
