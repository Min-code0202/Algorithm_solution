import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14890 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj14890().solution();
    }

    int N, L;
    int[][] arr, tArr;

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        tArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
                tArr[j][i] = val; // 세로 배열 생성
            }
        }

        int ans = enableRoad(arr) + enableRoad(tArr);
        System.out.println(ans);

        br.close();
    }

    int enableRoad(int[][] arr) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int[] road = arr[i];
            boolean[] used = new boolean[N];
            boolean enable = true;

            for (int j = 0; j < N - 1; j++) {
                int diff = road[j + 1] - road[j];

                if (diff == 0)
                    continue; // 높이 같으면 통과

                // 높이 차이가 2 이상 → 실패
                if (Math.abs(diff) > 1) {
                    enable = false;
                    break;
                }

                // 오르막 (다음 칸이 높음)
                if (diff == 1) {
                    // L칸 뒤로 확인
                    for (int k = j; k > j - L; k--) {
                        if (k < 0 || road[k] != road[j] || used[k]) {
                            enable = false;
                            break;
                        }
                        used[k] = true;
                    }
                }

                // 내리막 (다음 칸이 낮음)
                else if (diff == -1) {
                    // L칸 앞으로 확인
                    for (int k = j + 1; k <= j + L; k++) {
                        if (k >= N || road[k] != road[j + 1] || used[k]) {
                            enable = false;
                            break;
                        }
                        used[k] = true;
                    }
                }

                if (!enable)
                    break;
            }

            if (enable)
                cnt++;
        }

        return cnt;
    }
}
