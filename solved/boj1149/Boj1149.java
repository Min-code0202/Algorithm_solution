import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1149 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1149().solution();
    }

    void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // R
            arr[i][1] = Integer.parseInt(st.nextToken()); // G
            arr[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        int[][] cost = new int[N + 1][3];
        cost[1][0] = arr[1][0];
        cost[1][1] = arr[1][1];
        cost[1][2] = arr[1][2];

        for (int i = 2; i <= N; i++) {
            cost[i][0] = arr[i][0] + Math.min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] = arr[i][1] + Math.min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] = arr[i][2] + Math.min(cost[i - 1][0], cost[i - 1][1]);
        }

        int ans = Math.min(cost[N][0], Math.min(cost[N][1], cost[N][2]));
        wr.write(ans + "\n");
        wr.flush();
        wr.close();
        br.close();
    }
}