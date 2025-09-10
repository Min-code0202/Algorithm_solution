import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea5643 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea5643().solution();
    }

    int N, M;
    final int INF = 1_000_000_000;
    int[][] map;

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            map = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                Arrays.fill(map[i], INF);
                map[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    if (map[i][j] != INF || map[j][i] != INF) cnt++;
                }
                if (cnt == N - 1) ans++;
            }

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
    }
}
