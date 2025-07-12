import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Minecraft {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, B;
    final static int DIG = 2;
    final static int FILL = 1;
    int[][] ground;

    public Minecraft() {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            ground = new int[N][M];
            int low = 256;
            // #region 땅의 최소 높이를 구함
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp < low)
                        low = temp;
                    ground[i][j] = temp;
                }
            }
            // #endregion

            int maxHeight = calculHeight(low);
            int minTime = 2147483647;
            int height = 0;

            while (maxHeight >= 0) {
                int runTime = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (maxHeight < ground[i][j]) {
                            runTime += (ground[i][j] - maxHeight) * DIG;
                        } else if (maxHeight > ground[i][j]) {
                            runTime += (maxHeight - ground[i][j]) * FILL;
                        }
                    }
                }
                if (runTime < minTime) {
                    minTime = runTime;
                    height = maxHeight;
                }
                maxHeight--;
            }

            wr.write(minTime + " " + height);
            wr.flush();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public int calculHeight(int low) {
        int inventory = B;
        int[][] flatGround = new int[N][M];
        // 2차원 배열 깊은 복사
        for (int i = 0; i < ground.length; i++) {
            flatGround[i] = ground[i].clone();
        }
        // #region 현재 땅의 높이를 low로 바꿔주고 인벤토리에 담음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (low < flatGround[i][j]) {
                    inventory += (flatGround[i][j] - low);
                    flatGround[i][j] = low;
                }
            }
        }
        // #endregion
        // #region 인벤토리의 블럭으로 최대 높이 만큼 채워줌
        int fillBlock = inventory / (N * M);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                flatGround[i][j] += fillBlock;
            }
        }
        // #endregion
        return flatGround[0][0];
    }

    public static void main(String[] args) {
        new Minecraft();
    }
}