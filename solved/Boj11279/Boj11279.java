import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj11279 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(maxHeap.isEmpty()){
                    wr.write("0\n");
                }else{
                    wr.write(maxHeap.poll() + "\n");
                }
            }else{
                maxHeap.offer(x);
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Boj11279().solution();
    }
}
