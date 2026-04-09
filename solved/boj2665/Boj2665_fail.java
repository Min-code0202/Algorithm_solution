package solved.boj2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj2665_fail {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj2665_fail().solution();
    }

    int n;
    int[][] arr;
    int[] di = { 0, 0, -1, 0 };
    int[] dj = { -1, -1, 0, 1 };

    int solve(int si, int sj, int ei, int ej) {
        int[][] visited = new int[n][n];
        visited[si][sj] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { si, sj });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if (0 <= ni && ni < n && 0 <= nj && nj < n) {
                    if (visited[ni][nj] == 0 || visited[ni][nj] > visited[ci][cj]) {
                        visited[ni][nj] = visited[ci][cj] + arr[ni][nj];
                        q.offer(new int[] { ni, nj });
                    }
                }
            }
        }
        return visited[ei][ej];
    }

    public void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = (line[j] - '0') == 0 ? 1 : 0;
            }
        }

        int ans = solve(0, 0, n - 1, n - 1) - 1;
        System.out.println(ans);
        br.close();
    }
}
