import java.io.*;
import java.util.*;

public class Boj3190 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj3190().solution();
    }

    class Point {
        int ci, cj;
        Point(int ci, int cj) { this.ci = ci; this.cj = cj; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return ci == p.ci && cj == p.cj;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ci, cj);
        }
    }

    class Turn {
        int time;
        char dir;
        Turn(int time, char dir) { this.time = time; this.dir = dir; }
    }

    int N, K, L;
    int[][] arr;
    Queue<Turn> turn;
    Deque<Point> snake;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N + 2][N + 2];
        snake = new ArrayDeque<>();
        turn = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int aj = Integer.parseInt(st.nextToken());
            arr[ai][aj] = 1; // 사과
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            turn.offer(new Turn(time, dir));
        }

        snake.offer(new Point(1, 1));
        // System.out.println("시작 위치: 1 1");

        int time = 0;
        int dr = 0; // 0:오른, 1:아래, 2:왼, 3:위

        while (true) {
            time++;
            dr = move(time, dr);

            // 디버깅 출력
            // System.out.println("======================");
            // System.out.println("현재 시간: " + time);
            // System.out.println("현재 방향(dr): " + dr);
            // System.out.println("뱀 전체 위치:");
            // for (Point p : snake) {
            //     System.out.println("i: " + p.ci + " j: " + p.cj);
            // }

            if (dr == -1) {
                // System.out.println("충돌 발생! 게임 종료");
                break;
            }
        }

        wr.write(time + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    int[] di = {0, 1, 0, -1};
    int[] dj = {1, 0, -1, 0};

    int move(int time, int dr) {
        Point head = snake.peekFirst();
        int ni = head.ci + di[dr];
        int nj = head.cj + dj[dr];

        // System.out.println("현재 머리 위치: " + head.ci + " " + head.cj);
        // System.out.println("다음 머리 위치: " + ni + " " + nj);

        // 1. 이동
        if (canMove(ni, nj)) {
            snake.offerFirst(new Point(ni, nj));
            if (!isApple(ni, nj)) {
                // System.out.println("사과 없음 → 꼬리 제거");
                snake.pollLast();
            } else {
                // System.out.println("사과 있음 → 꼬리 유지");
            }
        } else {
            // System.out.println("벽 또는 몸에 부딪힘!");
            return -1;
        }

        // 2. 이동 후 방향 전환
        dr = direct(time, dr);
        return dr;
    }

    int direct(int time, int dr) {
        if (!turn.isEmpty() && turn.peek().time == time) {
            char dir = turn.poll().dir;
            // System.out.println("방향 전환 발생! 시간: " + time + " / 방향: " + dir);
            if (dir == 'D') dr = (dr + 1) % 4;
            else if (dir == 'L') dr = (dr + 3) % 4;
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
        if (ci < 1 || ci > N || cj < 1 || cj > N) return false;
        return !snake.contains(new Point(ci, cj));
    }
}
