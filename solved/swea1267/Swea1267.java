
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


public class Swea1267 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea1267().solution();
    }

    int V, E;
    int[] inD;
    List<Integer>[] graph;

    void solution() throws IOException{
        for(int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            for(int i = 1; i <= V; i++){
                graph[i] = new ArrayList<>();
            }
            inD = new int[V + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E / 2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                inD[to]++;
            }

            Queue<Integer> q = new ArrayDeque<>();
            for(int i = 1; i <= V; i++){
                if(inD[i] == 0){
                    q.offer(i);
                }
            }

            List<Integer> res = new ArrayList<>();

            while(!q.isEmpty()){
                int c = q.poll();
                res.add(c);
                for(int nxt : graph[c]){
                    inD[nxt]--;
                    if(inD[nxt] == 0){
                        q.offer(nxt);
                    }
                }
            }

            wr.write("#" + tc + " ");
            for(int node : res){
                wr.write(node + " ");
            }
            wr.write("\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }
}
