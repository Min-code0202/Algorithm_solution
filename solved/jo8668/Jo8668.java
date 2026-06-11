import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Jo8668 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Jo8668().solution();
    }

    int N;
    long T;
    long[] s;

    boolean check(int x){
        PriorityQueue<Long> selected = new PriorityQueue<>();
        PriorityQueue<Long> rest = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        long sum = 0;
        int idx = 0;

        for(int use = 1; use <= x; use++){
            int limit = Math.min(N, x + use);

            while(idx < limit){
                rest.offer(s[idx]);
                idx++;
            }

            while(!rest.isEmpty() && selected.size() < use){
                long num = rest.poll();
                sum += num;
                selected.offer(num);
            }

            while(!selected.isEmpty() && !rest.isEmpty() && selected.peek() < rest.peek()){
                long big = rest.poll();
                long small = selected.poll();

                sum += big;
                sum -= small;

                rest.offer(small);
                selected.offer(big);
            }

            if(sum >= T){
                return true;
            }
        }
        

        return false;
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Long.parseLong(st.nextToken());

        s = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            s[i] = Long.parseLong(st.nextToken());
        }

        int left = 1;
        int right = N;
        int ans = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(check(mid)){
                right = mid - 1;
                ans = mid;
            } else{
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }
}