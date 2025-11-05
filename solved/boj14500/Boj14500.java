import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14500{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj14500().solution();
    }

    int N, M;
    int[][] arr;
    boolean[][] visited;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 0);
                visited[i][j] = false;
                checkT(i, j);
            }
        }

        System.out.println(ans);
        br.close();
    }

    int ans = 0;
    int[] di = {1, 0, -1, 0};
    int[] dj = {0, 1, 0, -1};

    void dfs(int si, int sj, int sum, int depth){
        if(depth == 3){
            ans = Math.max(ans, sum);
            return;
        } 

        for(int d = 0; d < 4; d++){
            int ni = si + di[d];
            int nj = sj + dj[d];
            if(0 <= ni && ni < N && 0 <= nj && nj < M && !visited[ni][nj]){
                visited[ni][nj] = true;
                dfs(ni, nj, sum + arr[ni][nj], depth + 1);
                visited[ni][nj] = false;
            }
        }
    }

    void checkT(int i, int j){
        int center = arr[i][j];

        int up = (i - 1 >= 0) ? arr[i - 1][j] : -1;
        int down = (i + 1 < N) ? arr[i + 1][j] : -1;
        int left = (j - 1 >= 0) ? arr[i][j - 1] : -1;
        int right = (j + 1 < M) ? arr[i][j + 1] : -1;

        if(up != -1 && left != -1 && right != -1)
            ans = Math.max(ans, center + up + left + right);
        
        if(down != -1 && left != -1 && right != -1)
            ans = Math.max(ans, center + down + left + right);
        
        if(up != -1 && down != -1 && right != -1)
            ans = Math.max(ans, center + up + down + right);
        
        if(up != -1 && down != -1 && left != -1)
            ans = Math.max(ans, center + up + down + left);
    }
}