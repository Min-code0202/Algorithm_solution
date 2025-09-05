import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea1949 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, K;
    int[][] arr;
    boolean[][] visited;
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        new Swea1949().solution();
    }

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            int maxHeight = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, arr[i][j]);
                }
            }

            visited = new boolean[N][N];
            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == maxHeight) {
                        ans = Math.max(ans, dfs(i, j, false));
                    }
                }
            }

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
    }

    int dfs(int ci, int cj, boolean used) {
        visited[ci][cj] = true;
        int maxLen = 1; // 현재 칸 포함

        for (int d = 0; d < 4; d++) {
            int ni = ci + di[d];
            int nj = cj + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
                if (arr[ni][nj] < arr[ci][cj]) {
                    maxLen = Math.max(maxLen, 1 + dfs(ni, nj, used));
                } else if (!used && arr[ni][nj] - K < arr[ci][cj]) {
                    int original = arr[ni][nj];
                    arr[ni][nj] = arr[ci][cj] - 1; // 깎기
                    maxLen = Math.max(maxLen, 1 + dfs(ni, nj, true));
                    arr[ni][nj] = original; // 복원
                }
            }
        }

        visited[ci][cj] = false;
        return maxLen;
    }
}