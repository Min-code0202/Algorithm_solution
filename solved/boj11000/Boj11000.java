import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj11000 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj11000().solution();
    }

    class Pair {
        int s, t;

        public Pair(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    int N;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.s == b.s)
                return a.t - b.t;
            return a.s - b.s;
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.offer(new Pair(s, t));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();

        int ans = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (room.isEmpty() || room.peek() > cur.s) {
                room.offer(cur.t);
            } else {
                room.poll();
            }
            ans = Math.max(ans, room.size());
        }
        wr.write(ans + "\n");

        wr.flush();
        br.close();
        wr.close();
    }
}