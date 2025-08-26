import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj1941 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1941().solution();
    }

    char[][] arr;
    int[] select;
    int[] di = {1, 0, 0, -1};
    int[] dj = {0, 1, -1, 0};
    int ans;
    boolean[] visited;

    void solution() throws IOException {
        arr = new char[5][5];
        select = new int[7]; // 7개 자리 선택
        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        
        comb(0, 0);

        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    // idx : 0~24 좌표, cnt : 선택 개수
    void comb(int idx, int cnt) {
        if (cnt == 7) { // 7개 다 뽑음
            if (cntS() && connect()) ans++;
            return;
        }

        if (idx == 25) return; // 25칸 다 확인했으면 종료

        // 선택
        select[cnt] = idx;
        comb(idx + 1, cnt + 1);

        // 선택 안 함
        comb(idx + 1, cnt);
    }

    // 'S'가 4명 이상인지 확인
    boolean cntS() {
        int cnt = 0;
        for (int s : select) {
            int i = s / 5;
            int j = s % 5;
            if (arr[i][j] == 'S') cnt++;
        }
        return cnt >= 4;
    }

    // DFS로 연결 확인
    boolean connect() {
        visited = new boolean[7];
        dfs(0);

        int connected = 0;
        for (boolean v : visited) if (v) connected++;
        return connected == 7;
    }

    void dfs(int c) {
        visited[c] = true;
        int ci = select[c] / 5;
        int cj = select[c] % 5;

        for (int d = 0; d < 4; d++) {
            int ni = ci + di[d];
            int nj = cj + dj[d];
            if(ni < 0 || ni >= 5 || nj < 0 || nj >= 5) continue;

            int nxt = ni * 5 + nj;
            for (int i = 0; i < 7; i++) {
                if (!visited[i] && select[i] == nxt) {
                    dfs(i);
                }
            }
        }
    }
}