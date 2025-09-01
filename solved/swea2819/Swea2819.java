import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Swea2819 {
    static int[][] arr = new int[4][4];
    static HashSet<String> set;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            set = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr[i][j]);
                    dfs(i, j, 1, sb);
                }
            }

            wr.write("#" + tc + " " + set.size() + "\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }

    static void dfs(int ci, int cj, int len, StringBuilder sb) {
        if (len == 7) {
            set.add(sb.toString());
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = ci + di[d];
            int nj = cj + dj[d];
            if (0 <= ni && ni < 4 && 0 <= nj && nj < 4) {
                sb.append(arr[ni][nj]);
                dfs(ni, nj, len + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
