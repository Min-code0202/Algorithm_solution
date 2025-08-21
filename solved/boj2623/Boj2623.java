import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2623 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M;
    List<Integer>[] graph;
    int[] inD;

    public static void main(String[] args) throws IOException {
        new Boj2623().solution();
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        inD = new int[N + 1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken()); 
            for(int j = 1; j < k; j++){
                int next = Integer.parseInt(st.nextToken());
                graph[prev].add(next);
                inD[next]++;
                prev = next;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            if(inD[i] == 0){
                q.offer(i);
            }
        } 

        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            for(int nxt : graph[cur]){
                inD[nxt]--;
                if(inD[nxt] == 0){
                    q.offer(nxt);
                } 
            }
        }

        if(res.size() != N){
            wr.write("0\n");
        }
        else{
            for(int node : res){
                wr.write(node + "\n");
            } 
        }

        wr.flush();
        br.close();
        wr.close();
    }
}
