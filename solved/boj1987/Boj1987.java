import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1987 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int R, C, ans = 0;
    char[][] arr;
    boolean[] visited;
    int[] di = {1, -1, 0, 0};
    int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        new Boj1987().solution();
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visited = new boolean[26];
        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        wr.write(ans + "\n");
        wr.flush();
    }

    void dfs(int ci, int cj, int depth) {
        ans = Math.max(ans, depth);

        for (int d = 0; d < 4; d++) {
            int ni = ci + di[d];
            int nj = cj + dj[d];

            if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                int alpha = arr[ni][nj] - 'A';
                if (!visited[alpha]) {
                    visited[alpha] = true;
                    dfs(ni, nj, depth + 1);
                    visited[alpha] = false;
                }
            }
        }
    }
}
