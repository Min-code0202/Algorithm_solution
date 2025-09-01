import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea8382 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea8382().solution();
    }

    int[][][] visited;
    int[] di = {1, 0, -1, 0};
    int[] dj = {0, -1, 0, 1};

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            int x2 = Integer.parseInt(st.nextToken()) + 100;
            int y2 = Integer.parseInt(st.nextToken()) + 100;

            visited = new int[2][201][201];
            for (int d = 0; d < 2; d++) {
                for (int i = 0; i <= 200; i++) {
                    Arrays.fill(visited[d][i], Integer.MAX_VALUE);
                }
            }

            bfs(y1, x1, y2, x2);

            int ans = Math.min(visited[0][y2][x2], visited[1][y2][x2]);
            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        wr.close();
        br.close();
    }

    void bfs(int si, int sj, int ei, int ej) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj, 0}); // 세로
        q.offer(new int[]{si, sj, 1}); // 가로
        visited[0][si][sj] = 0;
        visited[1][si][sj] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];
            int dir = cur[2];

            if (dir == 0) { // 세로 -> 가로
                for (int d = 0; d < 4; d++) {
                    if (d % 2 == 0) {
                        int ni = ci + di[d];
                        int nj = cj + dj[d];
                        if (0 <= ni && ni <= 200 && 0 <= nj && nj <= 200) {
                            if (visited[1][ni][nj] > visited[0][ci][cj] + 1) {
                                visited[1][ni][nj] = visited[0][ci][cj] + 1;
                                q.offer(new int[]{ni, nj, 1});
                            }
                        }
                    }
                }
            } else { // 가로 -> 세로
                for (int d = 0; d < 4; d++) {
                    if (d % 2 == 1) {
                        int ni = ci + di[d];
                        int nj = cj + dj[d];
                        if (0 <= ni && ni <= 200 && 0 <= nj && nj <= 200) {
                            if (visited[0][ni][nj] > visited[1][ci][cj] + 1) {
                                visited[0][ni][nj] = visited[1][ci][cj] + 1;
                                q.offer(new int[]{ni, nj, 0});
                            }
                        }
                    }
                }
            }
        }
    }
}
