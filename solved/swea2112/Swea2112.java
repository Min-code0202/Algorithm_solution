import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea2112 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea2112().solution();
    }

    int D, W, K;
    int[][] arr;
    int[] injectRow;
    int ans;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[D][W];
            injectRow = new int[D];
            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MAX_VALUE;
            dfs(0, 0); // 현재 행, 주입 횟수
            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    void dfs(int r, int inject){
        if(inject >= ans) return;

        if(r == D){
            if(check()) ans = Math.min(ans, inject);
            return;
        }

        for(int i = -1; i < 2; i++){ // -1 : 주입 안함   0 : A 주입   1 : B 주입
            injectRow[r] = i;
            if(i == -1){
                dfs(r + 1, inject);
            }else{
                dfs(r + 1, inject + 1);
            }
        }
    }

    boolean check(){
        int c = 0;
        while(c < W){
            int prev = -1;
            int cnt = 1;
            for(int i = 0; i < D; i++){
                if(injectRow[i] == -1){ // 행 변화 없음
                    if(prev == arr[i][c]) cnt++;
                    else cnt = 1;
                    prev = arr[i][c];
                }else if(injectRow[i] == 0){ // 행 A로 주입
                    if(prev == 0) cnt++;
                    else cnt = 1;
                    prev = 0;
                }else{ // 행 B로 주입
                    if(prev == 1) cnt++;
                    else cnt = 1;
                    prev = 1;
                }
                if(cnt == K) break;
            }
            if(cnt < K) return false;
            c++;
        }
        return true;
    }
}
