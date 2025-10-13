import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11 {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj11().solution();
    }

    int N;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        int[][] times = new int[N * 2][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            times[i * 2][0] = s;
            times[i * 2][1] = 1;
            times[i * 2 + 1][0] = e;
            times[i * 2 + 1][1] = -1;
        }

        Arrays.sort(times, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        // for (int i = 0; i < N * 2; i++) {
        // System.out.println("tiems[i][0] " + times[i][0] + " tiems[i][1] " +
        // times[i][1]);
        // }
        // System.out.println();
        // System.out.println();

        int ans = 0;
        int room = 0;
        for (int i = 0; i < N * 2; i++) {
            // System.out.println("tiems[i][0] " + times[i][0] + " tiems[i][1] " +
            // times[i][1]);

            if (times[i][1] == 1) {
                room += 1;
            } else if (times[i][1] == -1) {
                room -= 1;
            }
            // System.out.println("ans = " + ans);

            ans = Math.max(ans, room);
        }

        wr.write(ans + "\n");

        wr.flush();
        br.close();
        wr.close();
    }
}
