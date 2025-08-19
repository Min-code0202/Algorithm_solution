import java.io.*;
import java.util.StringTokenizer;

public class Boj2805 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj2805().solution();
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] tree = new long[N];
        long max = 0, min = 0, mid;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        while (min <= max) {
            mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) sum += tree[i] - mid;
            }

            if (sum < M) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        wr.write(max + "\n");
        wr.flush();
        wr.close();
        br.close();
    }
}
