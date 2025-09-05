import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1707Ver2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1707Ver2().solution();
    }

    int K, V, E;
    List<Integer>[] graph;
    int[] visited;

    void solution() throws IOException {
        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            visited = new int[V + 1];
            Arrays.fill(visited, -1);

            boolean isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (visited[i] == -1) { // 아직 방문 안 한 정점이면 DFS 시작
                    if (!dfs(i, 0)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            wr.write(isBipartite ? "YES\n" : "NO\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    boolean dfs(int c, int color) {
        visited[c] = color;
        for (int n : graph[c]) {
            if (visited[n] == color) return false; // 같은 색이면 이분 그래프 아님
            if (visited[n] == -1 && !dfs(n, 1 - color)) return false;
        }
        return true;
    }
}
