import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B9466 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] stu;
    boolean[] visit, team; // 방문 여부, 팀 구성 여부
    int cnt; // 팀을 구성한 학생 수

    void dfs(int current) {
        // 이미 방문 했을 때
        if (visit[current]) {
            team[current] = true; // 팀 구성 완료
            cnt++;
        } else {
            visit[current] = true; // 방문 처리
        }

        // 다음 학생이 팀을 못구한 경우
        if (!team[current]) {
            dfs(stu[current]);
        }
        visit[current] = false; // 해당 방문 체크 해제
        team[current] = true; // 현재 노드의 학생은 탐색을 완료했으므로 true
    }

    public B9466() throws IOException {
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 학생 수
            stu = new int[n + 1]; // 학생 테이블
            visit = new boolean[n + 1];
            team = new boolean[n + 1];
            cnt = 0; // 팀이 완성된 인원 수

            StringTokenizer st = new StringTokenizer(br.readLine()); // 선택된 학생들의 번호
            for (int i = 1; i <= n; i++)
                stu[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++) {
                if (!team[i]) // 팀을 못구한 학생인 경우 탐색 시작
                    dfs(stu[i]);
            }
            wr.write((n - cnt) + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B9466();
    }
}