import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj2667 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N;
    int[][] arr;
    boolean[][] visited;
    int[] di = {1, 0, -1, 0};
    int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        new Boj2667().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line[j] - '0';
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    int size = dfs(i, j);
                    list.add(size);
                }
            }
        }

        Collections.sort(list);

        wr.write(list.size() + "\n");
        for (int l : list) {
            wr.write(l + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    int dfs(int ci, int cj) {
        visited[ci][cj] = true;
        int size = 1;

        for (int d = 0; d < 4; d++) {
            int ni = ci + di[d];
            int nj = cj + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && arr[ni][nj] == 1 && !visited[ni][nj]) {
                size += dfs(ni, nj);
            }
        }
        return size;
    }
}