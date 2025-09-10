import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea1263 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea1263().solution();
    }

    int N;
    int[][] map;
    final int INF = 1_000_000_000;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i = 0; i < N; i++) Arrays.fill(map[i], INF);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int n = Integer.parseInt(st.nextToken());
                    if(n == 1) map[i][j] = n;
                }
            }

            for(int k = 0; k < N; k++){
                for(int i = 0; i < N; i++){
                    if(k == i) continue;
                    for(int j = 0; j < N; j++){
                        if(k == i || i == j) continue;
                        if(map[i][j] > map[i][k] + map[k][j]){
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            int ans = 1_000_000_000;
            for(int i = 0; i < N; i++){
                int sum = 0;
                for(int j = 0; j < N; j++){
                    sum += (map[i][j] == 1_000_000_000) ? 0 : map[i][j];
                }
                ans = Math.min(ans, sum);
            }

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }
}
