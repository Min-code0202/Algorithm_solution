import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj2665 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj2665().solution();
    }

    int n;
    int[][] arr;
    int[] di = { 1, 0, -1, 0 };
    int[] dj = { 0, -1, 0, 1 };

    // 다익스트라
    int solve1(int si, int sj, int ei, int ej) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist, Integer.MAX_VALUE);

        dist[si][sj] = 0;
        pq.offer(new int[] { si, sj, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int ci = cur[0], cj = cur[1], w = cur[2];

            if (w > dist[ci][cj])
                continue;
            if (ci == ei && cj == ej)
                return w;

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d], nj = cj + dj[d];
                if (0 <= ni && ni < n && 0 <= nj && nj < n) {
                    int nextW = w + arr[ni][nj];
                    if (nextW < dist[ni][nj]) {
                        dist[ni][nj] = nextW;
                        pq.offer(new int[] { ni, nj, nextW });
                    }
                }
            }
        }
        return -1;
    }

    // 0-1 BFS
    int solve2(int si, int sj, int ei, int ej) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        dq.offer(new int[] { si, sj, 0 });

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int ci = cur[0], cj = cur[1], w = cur[2];

            if (visited[ci][cj])
                continue;
            visited[ci][cj] = true;

            if (ci == ei && cj == ej)
                return w;

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d], nj = cj + dj[d];
                if (0 <= ni && ni < n && 0 <= nj && nj < n && !visited[ni][nj]) {
                    if (arr[ni][nj] == 0)
                        dq.addFirst(new int[] { ni, nj, w });
                    else
                        dq.addLast(new int[] { ni, nj, w + 1 });
                }
            }
        }
        return -1;
    }

    public void solution() throws IOException {
        String input = br.readLine();
        if (input == null)
            return;
        n = Integer.parseInt(input);
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = (line[j] - '0') == 0 ? 1 : 0;
            }
        }

        System.out.println(solve1(0, 0, n - 1, n - 1));
        br.close();
    }
}