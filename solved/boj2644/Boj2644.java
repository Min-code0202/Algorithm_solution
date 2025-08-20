import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2644 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj2644().solution();
    }

    List<Integer>[] graph;
    boolean[] visited;

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1];
        visited[from] = true;
        int ans = dfs(from, to, 0);

        wr.write(ans + "\n");

        wr.flush();
        br.close();
        wr.close();
    }

    int dfs(int from, int to, int cnt){
        if(from == to){
            return cnt;
        }

        for(int nxt : graph[from]){
            if(!visited[nxt]){
                visited[nxt] = true;
                int res = dfs(nxt, to, cnt + 1);
                if(res != -1) return res;
            }
        }
        return -1;
    }
}
