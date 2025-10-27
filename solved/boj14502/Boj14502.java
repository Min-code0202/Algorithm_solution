import java.io.*;
import java.util.*;

public class Boj14502 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Boj14502().solution();
    }

    int N, M;
    int[][] arr;
    int ans = 0;

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    virus.add(new int[] { i, j });
                }
            }
        }

        dfs(0);
        System.out.println(ans);
    }

    void dfs(int depth) {
        if (depth == 3) {
            ans = Math.max(ans, bfs());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1; // 벽 세우기
                    dfs(depth + 1);
                    arr[i][j] = 0; // 되돌리기
                }
            }
        }
    }

    int[] di = { 1, -1, 0, 0 };
    int[] dj = { 0, 0, 1, -1 };

    int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] infected = new boolean[N][M];

        // 초기 바이러스 큐 삽입
        for (int[] v : virus) {
            q.offer(new int[] { v[0], v[1] });
            infected[v[0]][v[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                    if (!infected[ni][nj] && arr[ni][nj] == 0) {
                        infected[ni][nj] = true;
                        q.offer(new int[] { ni, nj });
                    }
                }
            }
        }

        // 안전 구역 계산
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && !infected[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
