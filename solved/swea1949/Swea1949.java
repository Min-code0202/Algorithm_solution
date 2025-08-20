import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea1949 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea1949().solution();
    }

    int N, K, arr[][];
    boolean[][] visited;
    int ans;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            int max = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, arr[i][j]);
                }
            }

            ans = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(arr[i][j] == max){
                        dfs(i, j, 1, false);
                    }
                }
            }

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, 1, 0, -1};

    void dfs(int ci, int cj, int length, boolean used){
        visited[ci][cj] = true;
        ans = Math.max(ans, length);

        for(int d = 0; d < 4; d++){
            int ni = ci + di[d];
            int nj = cj + dj[d];
            if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]){
                if(arr[ni][nj] < arr[ci][cj]){
                    dfs(ni, nj, length + 1, used);
                }else if(!used && arr[ni][nj] - K < arr[ci][cj]){
                    int temp = arr[ni][nj];
                    arr[ni][nj] = arr[ci][cj] - 1;
                    dfs(ni, nj, length + 1, true);
                    arr[ni][nj] = temp;
                }
            }
        }

        visited[ci][cj] = false;
    }
}
