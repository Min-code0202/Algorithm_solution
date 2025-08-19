import java.io.*;
import java.util.StringTokenizer;

public class Boj16987 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, S[], W[];
    int ans;

    public static void main(String[] args) throws IOException {
        new Boj16987().solution();
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        W = new int[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        solve(0);
        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    void solve(int depth) {
        if (depth == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (S[i] <= 0) cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }

        // 현재 계란이 이미 깨져있으면 다음 계란으로 넘어감
        if (S[depth] <= 0) {
            solve(depth + 1);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == depth || S[i] <= 0) continue; // 자기 자신 또는 이미 깨진 계란은 skip

            hit = true;
            S[depth] -= W[i];
            S[i] -= W[depth];

            solve(depth + 1);

            S[depth] += W[i];
            S[i] += W[depth];
        }

        if (!hit) solve(depth + 1);
    }
}