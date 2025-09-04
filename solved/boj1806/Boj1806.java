import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1806 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1806().solution();
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;
        int ans = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) { 
                ans = Math.min(ans, end - start);
                sum -= arr[start++];
            } else if (end == N) break;
            else sum += arr[end++];
        }

        wr.write((ans == Integer.MAX_VALUE ? 0 : ans) + "\n");
        wr.flush();
    }
}
