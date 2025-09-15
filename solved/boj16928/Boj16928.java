import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16928 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj16928().solution();
    }

    int N, M;
    int[] arr;    
    int[] visited;   

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[101];

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;
        }

        bfs();
        
        wr.write((visited[100] - 1) + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    void bfs() {
        visited = new int[101];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = 1; 

        while (!q.isEmpty()) {
            int c = q.poll();
            if (c == 100) return;

            for (int i = 1; i <= 6; i++) {
                int nxt = c + i;
                if (nxt > 100) continue;

                if (arr[nxt] != 0) {
                    nxt = arr[nxt];
                }

                if (visited[nxt] == 0) {
                    visited[nxt] = visited[c] + 1;
                    q.offer(nxt);
                }
            }
        }
    }
}
