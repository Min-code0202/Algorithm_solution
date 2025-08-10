import java.io.*;
import java.util.*;

public class Solution {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean[][] disable; 
    boolean[] isSelected;
    int N, M, cnt;

    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            disable = new boolean[N + 1][N + 1];
            isSelected = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                disable[a][b] = true;
                disable[b][a] = true;
            }

            cnt = 0;
            solve(1);

            wr.write("#" + tc + " " + cnt + "\n");
        }
        wr.flush();
    }

    void solve(int depth) {
        if (depth > N) {
            if (isValid()) cnt++;
            return;
        }

        isSelected[depth] = true;
        solve(depth + 1);

        isSelected[depth] = false;
        solve(depth + 1);
    }

    boolean isValid() {
        for (int i = 1; i <= N; i++) {
            if (!isSelected[i]) continue;
            for (int j = i + 1; j <= N; j++) {
                if (isSelected[j] && disable[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}