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


public class Boj11725 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj11725().solution();
    }

    int N;
    int[] parents;
    List<Integer>[] graph;
    boolean[] visited;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        graph = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        bfs(1);
        for(int i = 2; i < N + 1; i++){
            wr.write(parents[i] + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    void bfs(int start){
        visited = new boolean[N + 1];
        visited[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : graph[cur]){
                if(visited[nxt]) continue;
                visited[nxt] = true;
                parents[nxt] = cur;
                q.offer(nxt);
            }
        }
    }
}
