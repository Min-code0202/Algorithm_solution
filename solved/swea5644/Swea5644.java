import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea5644 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea5644().solution();
    }

    int[][] dr = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int BC[][], C[], P[];
    int ACharge[], BCharge[];
    int A;
    

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            int[] AMove = new int[M];
            int[] BMove = new int[M];
            StringTokenizer stA = new StringTokenizer(br.readLine());
            StringTokenizer stB = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                AMove[i] = Integer.parseInt(stA.nextToken());
                BMove[i] = Integer.parseInt(stB.nextToken());
            }

            BC = new int[A + 1][2]; // BC 위치
            C = new int[A + 1]; // 충전 범위
            P = new int[A + 1]; // 성능

            for(int i = 1; i <= A; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
                P[i] = Integer.parseInt(st.nextToken());
                BC[i][0] = y;
                BC[i][1] = x;
            }

            int ai = 1;
            int aj = 1;
            int bi = 10;
            int bj = 10;

            ACharge = new int[M + 1];
            BCharge = new int[M + 1];

            for(int i = 0; i <= M; i++){
                charge(i, ai, aj, bi, bj);
                if(i == M) break;
                int[] a = move(ai, aj, AMove[i]);
                int[] b = move(bi, bj, BMove[i]);
                ai = a[0]; aj = a[1];
                bi = b[0]; bj = b[1];
            }

            int sum = 0;
            for(int i = 0; i <= M; i++){
                sum += (ACharge[i] + BCharge[i]);
            }

            wr.write("#" + tc + " " + sum + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    // 이동 방향으로 움직이고 움직인 위치 반환
    int[] move(int ci, int cj, int d){
        int ni = ci + dr[d][0];
        int nj = cj + dr[d][1];

        return new int[]{ni, nj};
    }

    void charge(int idx, int ai, int aj, int bi, int bj){
        int max = 0;
        int bestA = 0, bestB = 0;

        for(int i = 1; i <= A; i++){
            for(int j = 1; j <= A; j++){
                int aPower = 0;
                int bPower = 0;

                int distA = Math.abs(BC[i][0] - ai) + Math.abs(BC[i][1] - aj);
                int distB = Math.abs(BC[j][0] - bi) + Math.abs(BC[j][1] - bj);

                if(distA <= C[i]) aPower = P[i];
                if(distB <= C[j]) bPower = P[j];

                int sum;
                if(i == j && aPower > 0 && bPower > 0){ 
                    // 같은 충전소
                    sum = P[i];
                } else {
                    sum = aPower + bPower;
                }

                if(sum > max){
                    max = sum;
                    if(i == j && aPower > 0 && bPower > 0){
                        // 같은 충전소 -> 한쪽만 꽂혀도 합은 P[i]
                        bestA = P[i];
                        bestB = 0;
                    } else {
                        bestA = aPower;
                        bestB = bPower;
                    }
                }
            }
        }
        ACharge[idx] = bestA;
        BCharge[idx] = bestB;
    }
}
