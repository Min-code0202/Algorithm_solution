import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2567 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj2567().solution();
    }

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[101][101];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int row = y; row < y + 10; row++) {
                for (int col = x; col < x + 10; col++) {
                    arr[row][col] = 1;
                }
            }
        }

        int total = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        // 범위 벗어나거나, 옆이 빈 칸이면 둘레 증가
                        if (ni < 0 || nj < 0 || ni >= 101 || nj >= 101 || arr[ni][nj] == 0) {
                            total++;
                        }
                    }
                }
            }
        }

        wr.write(total + "\n");

        wr.flush();
        br.close();
        wr.close();
    }
}
