import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj2696 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj2696().solution();
    }

    void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int M = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            List<Integer> medians = new ArrayList<>();
            
            int cnt = 0;
            while(cnt < M){
                StringTokenizer st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens() && cnt < M){
                    int x = Integer.parseInt(st.nextToken());
                    cnt++;
                    
                    if(maxHeap.isEmpty() || x <= maxHeap.peek()){
                        maxHeap.offer(x);
                    }else{
                        minHeap.offer(x);
                    }

                    if(maxHeap.size() > minHeap.size() + 1){
                        minHeap.offer(maxHeap.poll());
                    }else if(minHeap.size() > maxHeap.size()){
                        maxHeap.offer(minHeap.poll());
                    }

                    if(cnt % 2 == 1){
                        medians.add(maxHeap.peek());
                    }
                }
            }
            
            wr.write(medians.size() + "\n");
            
            for(int i = 0; i < medians.size(); i++){
                wr.write(medians.get(i) + (i % 10 == 9 || i == medians.size() - 1 ? "\n" : " "));
            }
        }
        wr.flush();
        br.close();
        wr.close();
    }
}
