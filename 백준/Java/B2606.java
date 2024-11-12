import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class B2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static List<Integer> list[]; // 그래프
    static int[] is_visit; // 방문한 노드 표시
    static int cnt = 1; // 감염된 컴퓨터의 수

    static void dfs(int start) {
        is_visit[start] = cnt++;
        for (int i : list[start]) {
            if (is_visit[i] == 0)
                dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int pairs = Integer.parseInt(br.readLine()); // 연결된 쌍의 수

        // 방문 노드 초기화 (0이면 방문 안함, 0이 아니면 방문함)
        is_visit = new int[N + 1];
        Arrays.fill(is_visit, 0);

        // 그래프 생성
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        while (pairs-- > 0) {
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list[arr[0]].add(arr[1]);
            list[arr[1]].add(arr[0]);
        }

        for (int i = 0; i <= pairs; i++)
            Collections.sort(list[i]);

        // 1번 노드부터 탐색 시작
        dfs(1);

        /*
         * 1번 컴퓨터를 통해 감염된 수를 출력해야 하므로
         * 1번 컴퓨터와 cnt++라인이 실행되고 더해진 수를 뺴야함
         */
        cnt -= 2;
        wr.write(Integer.toString(cnt));
        wr.flush();

        br.close();
        wr.close();
    }
}
