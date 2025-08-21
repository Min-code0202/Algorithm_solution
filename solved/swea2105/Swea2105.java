import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea2105 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea2105().solution();
    }

    int N, arr[][];
    boolean[] visited;
    int[] di = {1, 1, -1, -1};
    int[] dj = {-1, 1, 1, -1};

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            StringTokenizer st;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = -1;
            for(int i = 0; i < N - 2; i++){
                for(int j = 1; j <= N - 2; j++){
                    for(int left = 1; left <= N - 2; left++){
                        for(int right = 1; right <= N - 2; right++){
                            int res = search(i, j, left, right);
                            ans = Math.max(ans, res);
                        }
                    }
                }
            }

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int search(int si, int sj, int l, int r){
        visited = new boolean[101];
        int ci = si, cj = sj;
        int cnt = 0;

        // 4방향
        int[] steps = {l, r, l, r};
        for (int d = 0; d < 4; d++) {
            for (int k = 0; k < steps[d]; k++) {
                ci += di[d];
                cj += dj[d];

                if (isOutOfBound(ci, cj)) return -1;
                if (visited[arr[ci][cj]]) return -1;

                visited[arr[ci][cj]] = true;
                cnt++;
            }
        }

        return cnt;
    }

    boolean isOutOfBound(int ci, int cj){
        if(0 <= ci && ci < N && 0 <= cj && cj < N) return false;
        return true;
    }
}
