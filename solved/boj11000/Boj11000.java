import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Boj11000 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj11000().solution();
    }

    class Pair implements Comparable<Pair>{
        int s, t;
        public Pair(int s, int t){
            this.s = s;
            this.t = t;
        }
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.s, o.s);
        }
    }

    int N;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            pq.offer(new Pair(s, t));
        }

        int ans = 0;
        int cnt = 0;
        int last = -1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();

            if(last > p.s){
                ans++;
            }else{
                
            }

            last = Math.max(last, p.t); // 강의가 끝나는 시간
            ans = Math.max(ans, cnt);
        }
        
        
        wr.flush();
        br.close();
        wr.close();
    }
}
