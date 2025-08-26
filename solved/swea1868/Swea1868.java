import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Swea1868 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea1868().solution();
    }

    int N;
    char[][] arr;
    int[] di = {-1, 0, 1, 0, -1, 1, -1, 1};
    int[] dj = {0, 1, 0, -1, -1, 1, 1, -1};

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            for(int i = 0; i < N; i++){
                char[] read = br.readLine().toCharArray();
                arr[i] = read;
            }

            int ans = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == '.' && check(i, j) == 0){
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == '.'){
                        ans++;
                    }
                }
            }
            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    // 눌렀을때 8방향 지뢰 있는지 체크, 있다면 지뢰 개수 반환
    int check(int ci, int cj){
        int cnt = 0;
        for(int d = 0; d < 8; d++){
            int ni = ci + di[d];
            int nj = cj + dj[d];
            if(0 <= ni && ni < N && 0 <= nj && nj < N){
                if(arr[ni][nj] == '*')  cnt++;
            }
        }

        return cnt;
    }

    // 8방향 탐색, 주변 지뢰가 없으면 계속 탐색
    void bfs(int si, int sj){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj});
        arr[si][sj] = (char)(check(si, sj) + '0');

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];

            for(int d = 0; d < 8; d++){
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if(ni < 0 || ni >= N || nj < 0 || nj >= N || arr[ni][nj] != '.') continue;
                if(check(ni, nj) == 0){
                    arr[ni][nj] = '0';
                    q.offer(new int[]{ni, nj});
                }else{
                    arr[ni][nj] = (char)(check(ni, nj) + '0');
                }
            }
        }
    }
}
