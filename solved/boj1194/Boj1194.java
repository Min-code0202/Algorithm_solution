import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1194 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        new Boj1194().solution();
    }

    int N, M;
    char[][] arr;
    int[] di = {1, 0, -1, 0};
    int[] dj = {0, -1, 0, 1};

    class Node {
        int ci, cj, key;
        public Node(int ci, int cj, int key) {
            this.ci = ci;
            this.cj = cj;
            this.key = key;
        }
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        int si = 0, sj = 0;
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(arr[i][j] == '0'){
                    si = i;
                    sj = j;
                }
            }
        }

        System.out.println(bfs(si, sj));
    }

    int bfs(int si, int sj){
        int[][][] visited = new int[64][N][M]; // key 상태별 방문 체크
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(si, sj, 0));
        visited[0][si][sj] = 1;

        while(!q.isEmpty()){
            Node cur = q.poll();
            int ci = cur.ci;
            int cj = cur.cj;
            int key = cur.key;

            if(arr[ci][cj] == '1') return visited[key][ci][cj] - 1;

            for(int d = 0; d < 4; d++){
                int ni = ci + di[d];
                int nj = cj + dj[d];
                int nKey = key;

                if(ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
                char cell = arr[ni][nj];

                if(cell == '#') continue;

                // 열쇠 습득
                if(cell >= 'a' && cell <= 'f'){
                    nKey |= (1 << (cell - 'a'));
                }

                // 문 체크
                if(cell >= 'A' && cell <= 'F'){
                    if((nKey & (1 << (cell - 'A'))) == 0) continue;
                }

                if(visited[nKey][ni][nj] == 0){
                    visited[nKey][ni][nj] = visited[key][ci][cj] + 1;
                    q.offer(new Node(ni, nj, nKey));
                }
            }
        }

        return -1;
    }
}
