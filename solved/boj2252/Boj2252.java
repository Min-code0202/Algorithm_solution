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

public class Boj2252 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj2252().solution();
    }

    int N, M;
    List<Integer>[] graph;
    int[] inD;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        inD = new int[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }

        int from, to;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            inD[to]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i < N + 1; i++){
            if(inD[i] == 0){
                q.offer(i);
            }
        }
        
        // 큐 사이즈가 0이면 위상정렬 불가
        ArrayList<Integer> res = new ArrayList<>();
        int idx;
        while(!q.isEmpty()){
            idx = q.poll();
            res.add(idx);
            for(int i : graph[idx]){
                inD[i]--;
                if(inD[i] == 0){
                    q.offer(i);
                }
            }
        }

        // res.size() == N

        for(int node : res){
            wr.write(node + " ");
        }

        wr.flush();
        br.close();
        wr.close();
    }
}
