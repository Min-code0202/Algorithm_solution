import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class B24444 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    List<Integer> graph[];
    int[] is_visited;
    int cnt = 1;
    Queue<Integer> queue = new LinkedList<>();

    void bfs(int current) {
        if (is_visited[current] == 0) // 방문을 안했으면 방문 표시
            is_visited[current] = cnt++;

        for (int i : graph[current])
            queue.add(i);

        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (is_visited[front] == 0)
                is_visited[front] = cnt++;

            for (int i : graph[front]) {
                if (is_visited[i] == 0)
                    queue.add(i);
            }
        }
    }

    public B24444() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        is_visited = new int[N + 1];
        Arrays.fill(is_visited, 0);

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[input[0]].add(input[1]);
            graph[input[1]].add(input[0]);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(R);

        for (int i = 1; i <= N; i++)
            wr.write(is_visited[i] + "\n");

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B24444();
    }
}
