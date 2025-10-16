import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 완전 탐색 풀이
public class Boj14501 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj14501().solution();
    }

    int N, T[], P[];
    int ans = 0;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()) - 1;
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0, 0);
        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    void dfs(int depth, int sum, int day) {
        if (depth == N + 1) {
            ans = Math.max(ans, sum);
            return;
        }

        // 상담 일정이 없는 경우
        if (day == 0) {
            if (depth + T[depth] < N + 1)
                dfs(depth + 1, sum + P[depth], T[depth]); // 상담 선택
            dfs(depth + 1, sum, 0); // 상담 미선택
        } else { // 상담 일정이 남은 경우
            dfs(depth + 1, sum, day - 1);
        }
    }
}
