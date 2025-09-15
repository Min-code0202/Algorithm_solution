import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Boj11286 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj11286().solution();
    }

    class Node implements Comparable<Node>{
        int x, abs;

        public Node(int x, int abs) {
            this.x = x;
            this.abs = abs;
        }

        @Override
        public int compareTo(Node o) {
            if(this.abs == o.abs) return this.x - o.x;
            return this.abs - o.abs;
        }
        
    }

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                int ans = 0;
                if(!pq.isEmpty()) ans = pq.poll().x;
                wr.write(ans + "\n");
            }else{
                pq.offer(new Node(num, Math.abs(num)));
            }
        }

        wr.flush();
        br.close();
        wr.close();
    }
}
