import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj3109 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        new Boj3109().solution();
    }

    char[][] arr;
    int R, C;
    int ans = 0;
    boolean found;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            int j = 0;
            for(char ch : str.toCharArray()){
                arr[i][j++] = ch;
            }
        }

        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            found = false;
            visited[i][0] = true;
            solve(i, 0);
        }

        wr.write(ans + "\n");
        // for(int i = 0; i < R; i++){
        //     System.out.println(Arrays.toString(visited[i]));
        // }

        wr.flush();
        br.close();
        wr.close();
    }

    int[][] dr = {{-1, 1}, {0, 1}, {1, 1}};
    boolean[][] visited;

    void solve(int si, int sj){
        // System.out.println(si + " " + sj);
        // for(int i = 0; i < R; i++){
        //     System.out.println(Arrays.toString(visited[i]));
        // }

        if(found) return;

        if(sj == C - 1){
            ans++;
            found = true;
            return;
        }

        for(int[] d : dr){
            int ni = si + d[0];
            int nj = sj + d[1];
            if(0 <= ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj] && arr[ni][nj] == '.' && !found){
                visited[ni][nj] = true;
                solve(ni, nj);
            }
        }
    }
}
