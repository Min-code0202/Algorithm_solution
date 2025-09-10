
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1613 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1613().solution();
    }

    int N, K, S;
    int[][] dist;
    final int INF = 1_000_000_000;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) Arrays.fill(dist[i], INF);
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(S-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(dist[a][b] != INF) sb.append(-1).append("\n");
            else if(dist[b][a] != INF) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        wr.write(sb.toString());
        wr.flush();
        br.close();
        wr.close();
    }

}