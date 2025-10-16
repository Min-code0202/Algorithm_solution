import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1689 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1689().solution();
    }

    public void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N * 2][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            points[i * 2][0] = s;
            points[i * 2][1] = 1;
            points[i * 2 + 1][0] = e;
            points[i * 2 + 1][1] = -1;
        }

        // System.out.println("=======================");
        // for (int i = 0; i < N; i++) {
        // System.out.println(points[i * 2][0] + " " + points[i * 2][1]);
        // System.out.println(points[i * 2 + 1][0] + " " + points[i * 2 + 1][1]);
        // }

        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        // System.out.println("=======================");
        // for (int i = 0; i < N; i++) {
        // System.out.println(points[i * 2][0] + " " + points[i * 2][1]);
        // System.out.println(points[i * 2 + 1][0] + " " + points[i * 2 + 1][1]);
        // }

        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < N * 2; i++) {
            cnt += points[i][1];
            ans = Math.max(ans, cnt);
        }

        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
