import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class B19598 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Meeting implements Comparable<Meeting> {
        int time;
        boolean start;

        public Meeting(int time, boolean sort) {
            this.time = time;
            this.start = sort;
        }

        @Override
        public int compareTo(Meeting o) {
            return Integer.compare(time, o.time);
        }
    }

    public B19598() throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Meeting(arr[0], true));
            pq.add(new Meeting(arr[1], false));
        }

        int room = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Meeting meeting = pq.poll();

            if (meeting.start) {
                room++;
                cnt = Math.max(cnt, room);
            } else {
                room--;
            }
        }

        wr.write(cnt + "");

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B19598();
    }
}
