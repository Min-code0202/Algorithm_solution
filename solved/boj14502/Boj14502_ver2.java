import java.io.*;
import java.util.*;

public class Boj14502_ver2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj14502_ver2().solution();
    }

    int N, M;
    int[][] arr;
    int ans = 0;
    ArrayList<int[]> virus = new ArrayList<>();

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2)
                    virus.add(new int[] { i, j });
            }
        }

        solve();
        System.out.println(ans);
    }

    void solve() {
        int size = N * M;
        for (int i = 0; i < size - 2; i++) {
            int i_1 = i / M;
            int j_1 = i % M;
            if (arr[i_1][j_1] != 0)
                continue;

            for (int j = i + 1; j < size - 1; j++) {
                int i_2 = j / M;
                int j_2 = j % M;
                if (arr[i_2][j_2] != 0)
                    continue;

                for (int k = j + 1; k < size; k++) {
                    int i_3 = k / M;
                    int j_3 = k % M;
                    if (arr[i_3][j_3] != 0)
                        continue;

                    // 벽 세우기
                    arr[i_1][j_1] = 1;
                    arr[i_2][j_2] = 1;
                    arr[i_3][j_3] = 1;

                    ans = Math.max(ans, bfs());

                    // 벽 복구
                    arr[i_1][j_1] = 0;
                    arr[i_2][j_2] = 0;
                    arr[i_3][j_3] = 0;
                }
            }
        }
    }

    int[] di = { 1, 0, -1, 0 };
    int[] dj = { 0, -1, 0, 1 };

    int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        // 바이러스 초기 위치 삽입
        for (int[] pos : virus) {
            q.add(new int[] { pos[0], pos[1] });
            visited[pos[0]][pos[1]] = true;
        }

        // BFS로 감염 확산
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                    if (!visited[ni][nj] && arr[ni][nj] == 0) {
                        visited[ni][nj] = true;
                        arr[ni][nj] = 2;
                        q.offer(new int[] { ni, nj });
                    }
                }
            }
        }

        // 안전구역 세기
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}
