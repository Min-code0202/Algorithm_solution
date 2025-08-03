import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Boj1927 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while(N-- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(minHeap.isEmpty()){
                    wr.write("0\n");
                }else{
                    wr.write(minHeap.poll() + "\n");
                }
            }else{
                minHeap.offer(x);
            }
        }


        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Boj1927().solution();
    }
}
