import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj14891 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj14891().solution();
    }

    LinkedList<Integer>[] list;
    int K;

    void solution() throws IOException {
        list = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < 4; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                list[i].add(ch[j] - '0');
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            // -1 = 반시계 0 = 변화없음 1 = 시계
            int[] status = new int[4]; // 톱니바퀴가 변하는지 체크
            check(N, dir, status);

            for (int j = 0; j < 4; j++) {
                if (status[j] == -1) {
                    list[j].offerLast(list[j].pollFirst());
                } else if (status[j] == 1) {
                    list[j].offerFirst(list[j].pollLast());
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int score = list[i].peekFirst();
            ans += score * (1 << i);
        }
        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    void check(int N, int dir, int[] status) {
        status[N] = dir;
        // 0 to N 회전하는 톱니바퀴 유무
        for (int i = N; i > 0; i--) {
            int left = list[i - 1].get(2);
            int right = list[i].get(6);
            if (left == right)
                break;
            else {
                status[i - 1] = -status[i];
            }
        }
        // N to 3 회전하는 톱니바퀴 유무
        for (int i = N; i < 3; i++) {
            int left = list[i].get(2);
            int right = list[i + 1].get(6);

            if (left == right) {
                break;
            } else
                status[i + 1] = -status[i];
        }
    }
}