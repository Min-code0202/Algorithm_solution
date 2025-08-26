import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj15683 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M;
    int[][] arr;
    List<int[]> cctvList = new ArrayList<>();
    int ans = Integer.MAX_VALUE;

    // 상, 우, 하, 좌
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        new Boj15683().solution();
    }

    void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                    cctvList.add(new int[]{i, j, arr[i][j]});
                }
            }
        }

        int[] dir = new int[cctvList.size()];
        dfs(0, dir);

        wr.write(ans + "\n");
        wr.flush();
    }

    // CCTV 방향 조합
    void dfs(int depth, int[] dir) {
        if (depth == cctvList.size()) {
            ans = Math.min(ans, solve(dir));
            return;
        }
        for (int d = 0; d < 4; d++) {
            dir[depth] = d;
            dfs(depth + 1, dir);
        }
    }

    // CCTV 방향 조합으로 시뮬레이션
    int solve(int[] dir) {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) temp[i] = arr[i].clone();

        for (int i = 0; i < cctvList.size(); i++) {
            int[] cctv = cctvList.get(i);
            int ci = cctv[0], cj = cctv[1], camera = cctv[2];
            watch(temp, ci, cj, camera, dir[i]);
        }

        return count(temp);
    }

    // CCTV 감시 방향 처리
    void watch(int[][] field, int i, int j, int camera, int d) {
        switch (camera) {
            case 1:
                check(field, i, j, d);
                break;
            case 2:
                check(field, i, j, d);
                check(field, i, j, (d + 2) % 4);
                break;
            case 3:
                check(field, i, j, d);
                check(field, i, j, (d + 1) % 4);
                break;
            case 4:
                check(field, i, j, d);
                check(field, i, j, (d + 1) % 4);
                check(field, i, j, (d + 3) % 4);
                break;
            case 5:
                for (int k = 0; k < 4; k++) check(field, i, j, k);
                break;
        }
    }

    // 한 방향으로 직진하면서 감시 영역 표시
    void check(int[][] field, int i, int j, int d) {
        int ni = i, nj = j;
        while (true) {
            ni += di[d];
            nj += dj[d];
            if (ni < 0 || nj < 0 || ni >= N || nj >= M) break;
            if (field[ni][nj] == 6) break; // 벽
            if (field[ni][nj] == 0) field[ni][nj] = -1; // 감시 영역
        }
    }

    // 사각지대 세기
    int count(int[][] field) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
