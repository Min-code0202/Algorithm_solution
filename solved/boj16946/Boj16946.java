import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16946 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj16946().solution();
    }

    int N, M;
    int[][] arr;
    int[][] groupIdMap; // 각 0이 속한 그룹의 ID
    Map<Integer, Integer> groupSizeMap = new HashMap<>(); // 그룹ID별 0의 개수

    int[] di = { 1, 0, -1, 0 };
    int[] dj = { 0, -1, 0, 1 };

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        groupIdMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line[j] - '0';
            }
        }

        // 1. 빈 공간(0)들을 BFS로 묶어서 그룹ID와 크기를 미리 저장
        int idCounter = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && groupIdMap[i][j] == 0) {
                    groupingBfs(i, j, idCounter++);
                }
            }
        }

        // 2. 결과 만들기 (벽인 곳만 주변 그룹 합산)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    sb.append(0);
                } else {
                    sb.append(calculate(i, j) % 10);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    // 0들을 그룹화하는 BFS
    void groupingBfs(int si, int sj, int id) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { si, sj });
        groupIdMap[si][sj] = id;
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if (ni >= 0 && ni < N && nj >= 0 && nj < M && arr[ni][nj] == 0 && groupIdMap[ni][nj] == 0) {
                    groupIdMap[ni][nj] = id;
                    q.offer(new int[] { ni, nj });
                    count++;
                }
            }
        }
        groupSizeMap.put(id, count);
    }

    // 벽(1) 위치에서 주변 그룹들의 크기 합치기
    int calculate(int i, int j) {
        int sum = 1; // 벽 부순 자기 자신 자리
        Set<Integer> nearGroups = new HashSet<>(); // 중복 그룹 방지용

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni >= 0 && ni < N && nj >= 0 && nj < M && groupIdMap[ni][nj] != 0) {
                nearGroups.add(groupIdMap[ni][nj]);
            }
        }

        for (int id : nearGroups) {
            sum += groupSizeMap.get(id);
        }
        return sum;
    }
}