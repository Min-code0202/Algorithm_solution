import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj10026 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj10026().solution();
    }

    int N;
    char[][] arr;
    boolean[][][] visited;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i = 0; i < N; i++){
            arr[i] = br.readLine().toCharArray();
        }

        visited = new boolean[2][N][N];
        int ans = 0;
        int ans2 = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[0][i][j]){
                    ans += 1;
                    bfs(i, j, 0, arr[i][j]);
                }
                if(!visited[1][i][j]){
                    ans2 += 1;
                    bfs(i, j, 1, arr[i][j]);
                }
            }
        }
        wr.write(ans + " " + ans2);
        wr.flush();
        br.close();
        wr.close();
    }

    int[] di = {1, 0, 0, -1};
    int[] dj = {0, 1, -1, 0};

    void bfs(int si, int sj, int flag, char color){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj, flag});
        visited[flag][si][sj] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];
            int status = cur[2];

            for(int d = 0; d < 4; d++){
                int ni = ci + di[d];
                int nj = cj + dj[d];

                if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[status][ni][nj]){
                    if(status == 0){ 
                        // 일반인
                        if(arr[ni][nj] == color){
                            visited[status][ni][nj] = true;
                            q.offer(new int[]{ni, nj, status});
                        }
                    }else{ 
                        // 적록색약
                        if(color == 'R' || color == 'G'){ // 시작점이 R/G이면
                            if(arr[ni][nj] == 'R' || arr[ni][nj] == 'G'){
                                visited[status][ni][nj] = true;
                                q.offer(new int[]{ni, nj, status});
                            }
                        }else{ // 시작점이 B
                            if(arr[ni][nj] == color){
                                visited[status][ni][nj] = true;
                                q.offer(new int[]{ni, nj, status});
                            }
                        }
                    }
                }
            }
        }
    }
}
