import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2606 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj2606().solution();
    }

    int N, M;
    ArrayList<Integer>[] graph;
    boolean[] visited;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];
        int ans = dfs(1) - 1;
        System.out.println(ans);
    }

    int dfs(int c){
        int cnt = 1;
        visited[c] = true;
        for(int nxt : graph[c]){
            if(!visited[nxt])
                cnt += dfs(nxt);
        }

        return cnt;
    }
}
