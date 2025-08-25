import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj13023 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj13023().solution();
    }

    List<Integer>[] graph;
    boolean[] visited;
    boolean flag = false;
    int N, M;

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (flag) break;
        }

        wr.write(flag ? "1" : "0");
        wr.flush();
        br.close();
        wr.close();
    }

    void dfs(int cur, int depth) {
        if (depth == 5) {
            flag = true;
            return;
        }

        visited[cur] = true;
        for (int nxt : graph[cur]) {
            if (!visited[nxt]) {
                dfs(nxt, depth + 1);
                if (flag) return;
            }
        }
        visited[cur] = false;
    }
}
