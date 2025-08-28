import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea2382 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea2382().solution();
    }

    class Micro{
        int r, c, cnt, dir, total;
        boolean isDead;

        public Micro(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
            this.total = cnt;
        }
    }

    int N, M, K;
    int[] di = {0, -1, 1, 0, 0};
    int[] dj = {0, 0, 0, -1, 1};
    Micro[] list;
    Micro[][] map;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            list = new Micro[K];
            map = new Micro[N][N];

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                list[i] = new Micro(r, c, cnt, dir);
            }

            wr.write("#" + tc + " " + move() + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int move(){
        int time = M, ni, nj, remainCnt = 0;
        while(time-- > 0){
            for(Micro cur : list){
                if(cur.isDead) continue;

                ni = cur.r += di[cur.dir];
                nj = cur.c += dj[cur.dir];

                if(ni == 0 || ni == N - 1 || nj == 0 || nj == N - 1){
                    cur.total = cur.cnt /= 2;
                    if(cur.cnt == 0){
                        cur.isDead = true;
                        continue;
                    }
                    if(cur.dir % 2 == 0){
                        cur.dir -= 1;
                    }else{
                        cur.dir += 1;
                    }
                }
                if(map[ni][nj] == null){
                    map[ni][nj] = cur;
                }else{
                    if(map[ni][nj].cnt > cur.cnt){
                        map[ni][nj].total += cur.cnt;
                        cur.isDead = true;
                    }else{
                        cur.total += map[ni][nj].total;
                        map[ni][nj].isDead = true;
                        map[ni][nj] = cur;
                    }
                }
            }
            remainCnt = reset();
        }

        return remainCnt;
    }

    int reset(){
        int total = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == null) continue;
                
                map[i][j].cnt = map[i][j].total;
                total += map[i][j].cnt;
                map[i][j] = null;
            }
        }

        return total;
    }
}
