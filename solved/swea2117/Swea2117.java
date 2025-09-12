import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea2117 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea2117().solution();
    }

    int N, M;
    int[][] arr;
    ArrayList<int[]> list; // 집 좌표

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1){
                        list.add(new int[]{i, j});
                    }
                }
            }

            int ans = -1;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int cnt = count(i, j);
                    ans = Math.max(ans, cnt);
                }
            }

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int count(int ci, int cj){
        int K = 1;
        int home = 0;
        while(K <= N + 100){
            int cnt = 0; // 연결된 집
            for(int[] cur : list){
                if(dist(ci, cj, cur[0], cur[1]) < K) cnt++;
            }
            
            if(cnt * M >= (K * K + (K - 1)*(K - 1))) home = Math.max(home, cnt);

            K++;
        }
        return home;
    }

    int dist(int si, int sj, int ei, int ej){
        return Math.abs(si - ei) + Math.abs(sj - ej);
    }
}
