import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj3190 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj3190().solution();
    }

    int N, K;
    int[][] arr;
    int L;

    Queue<int[]> turn;
    Deque<int[]> snake;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        turn = new ArrayDeque<>(); // 방향전환 시간, 방향
        snake = new ArrayDeque<>();

        // [0][], [N + 1][], [][0], [][N + 1] 은 벽
        arr = new int[N + 2][N + 2];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int aj = Integer.parseInt(st.nextToken());
            arr[ai][aj] = 1; // 사과 위치 표시
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int dir = st.nextToken().charAt(0) - 'A';
            turn.offer(new int[] { time, dir });
        }

        snake.offer(new int[] { 1, 1 });
        System.out.println(snake.peek()[0] + " " + snake.peek()[1]);
        int time = 1;
        int dr = 0; // 현재방향
        while (true) {
            dr = move(time, dr); // 뱀 움직임
            System.out.println("현재 시간: " + time);
            System.out.println("뱀 위치");
            for (int[] cur : snake) {
                System.out.println("i : " + cur[0] + " j : " + cur[1]);
            }
            if (dr == -1)
                break;
            time++;
        }

        wr.write(time + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    int[] di = { 0, 1, 0, -1 };
    int[] dj = { 1, 0, -1, 0 };

    // 뱀 이동
    int move(int time, int dr) {
        dr = direct(time, dr);
        int[] cur = snake.peek();
        System.out.println("현재 머리 위치");
        System.out.println(cur[0] + " " + cur[1]);
        // 다음 이동할 뱀의 머리 위치
        int[] nxt = new int[2];
        nxt[0] = cur[0] + di[dr];
        nxt[1] = cur[1] + dj[dr];
        System.out.println("다음 머리 위치");
        System.out.println(nxt[0] + " " + nxt[1]);

        if (canMove(nxt[0], nxt[1])) {
            snake.offerFirst(nxt);
            if (!isApple(nxt[0], nxt[1]))
                snake.pollLast(); // 마지막 꼬리 제거
            return dr;
        } else {
            return -1;
        }
    }

    // 현재 진행 방향
    int direct(int time, int dr) {
        if (turn.isEmpty())
            return dr;
        int t = turn.peek()[0];
        if (t == time) {
            int dir = turn.poll()[1];
            if (dir == 'D' - 'A') { // 오른 90도 회전
                dr = ((dr + 1) + 4) % 4;
            } else if (dir == 'L' - 'A') { // 왼 90도 회전
                dr = ((dr - 1) + 4) % 4;
            }
        }
        return dr;
    }

    boolean isApple(int ci, int cj) {
        if (arr[ci][cj] == 1) {
            arr[ci][cj] = 0;
            return true;
        }
        return false;
    }

    boolean canMove(int ci, int cj) {
        if (1 <= ci && ci <= N && 1 <= cj && cj <= N) {
            if (!snake.contains(new int[] { ci, cj })) {
                return true;
            }
        }
        return false;
    }
}
