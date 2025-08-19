import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea5650 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea5650().solution();
    }

    int N, arr[][];
    List<int[]> hole[];

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine().trim());
            arr = new int[N + 2][N + 2];
            StringTokenizer st;

            hole = new ArrayList[11];
            for(int i = 0; i < 11; i++){
                hole[i] = new ArrayList<>();
            }

            // 모든 방향 반사
            for(int i = 0; i < N + 2; i++){
                arr[i][0] = 5;
                arr[i][N + 1] = 5;
                arr[0][i] = 5;
                arr[N + 1][i] = 5;
            }

            for(int i = 1; i <= N; i++){
                String read = br.readLine().trim();
                st = new StringTokenizer(read, " ");
                for(int j = 1; j <= N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(6 <= arr[i][j] && arr[i][j] <= 10){
                        hole[arr[i][j]].add(new int[]{i, j});
                    }
                }
            }

            int ans = 0;
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(arr[i][j] == 0){
                        int cnt = play(i, j);
                        ans = Math.max(ans, cnt);
                    }
                }
            }
            wr.write("#" + tc + " " + ans + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    int[][] dr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    int play(int si, int sj) {
        int res = 0;

        for (int d = 0; d < 4; d++) {
            int cnt = 0;
            int ci = si, cj = sj;
            int dir = d;

            while (true) {
                ci += dr[dir][0];
                cj += dr[dir][1];

                if (ci == si && cj == sj || arr[ci][cj] == -1) {
                    res = Math.max(res, cnt);
                    break;
                }

                if (arr[ci][cj] >= 1 && arr[ci][cj] <= 5) {
                    dir = changeDir(arr[ci][cj], dir);
                    cnt++;
                }
                else if (arr[ci][cj] >= 6 && arr[ci][cj] <= 10) {
                    for (int[] point : hole[arr[ci][cj]]) {
                        if (point[0] != ci || point[1] != cj) {
                            ci = point[0];
                            cj = point[1];
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    int changeDir(int block, int dir){
        if(dir == 0){ // 위
            if(block == 1 || block == 4 || block == 5){
                return (dir + 2) % 4;
            }else if(block == 2){
                return (dir + 1) % 4;
            }else if(block == 3){
                return (dir + 3) % 4;
            }
        }else if(dir == 1){ // 오른
            if(block == 1 || block == 2 || block == 5){
                return (dir + 2) % 4;
            }else if(block == 3){
                return (dir + 1) % 4;
            }else if(block == 4){
                return (dir + 3) % 4;
            }
        }else if(dir == 2){ // 아래
            if(block == 2 || block == 3 || block == 5 ){
                return (dir + 2) % 4;
            }else if(block == 1){
                return (dir + 3) % 4;
            }else if(block == 4){
                return (dir + 1) % 4;
            }
        }else if(dir == 3){ // 왼
            if(block == 3 || block == 4 || block == 5){
                return (dir + 2) % 4;
            }else if(block == 2){
                return (dir + 3) % 4;
            }else if(block == 1){
                return (dir + 1) % 4;
            }
        }
        return -1;
    }
}
