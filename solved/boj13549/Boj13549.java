import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Boj13549 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj13549().solution();
    }

    int N, K;
    final int INF = 1_000_000_000;
    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int ans = dijk(N);
        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    int[] dr = {-1, 1, 2};

    int dijk(int start){
        int[] dist = new int[200_001];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] == K) break;

            if(cur[1] > dist[cur[0]]) continue;
            for(int d = 0; d < 3; d++){
                if(d == 2){
                    int n = cur[0] * dr[d];
                    if(n <= 200000){
                        if(dist[n] > cur[1] + 0){
                            dist[n] = cur[1] + 0;
                            pq.offer(new int[]{n, dist[n]});
                        }
                    }
                }else{
                    int n = cur[0] + dr[d];
                    if(n >= 0 && n <= 200000){
                        if(dist[n] > cur[1] + 1){
                            dist[n] = cur[1] + 1;
                            pq.offer(new int[]{n, dist[n]});
                        }
                    }
                }
            }
        }
        return dist[K];
    }
}