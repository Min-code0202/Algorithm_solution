import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj25682 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj25682().solution();
    }

    int N, M, K;
    char[][] arr;
    int[][] prefixW;
    int[][] prefixB;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        prefixW = new int[N + 1][M + 1];
        prefixB = new int[N + 1][M + 1];
        for(int i = 0; i < N; i++) arr[i] = br.readLine().toCharArray();
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                boolean isWhite = ((i + j) % 2 == 0);
                boolean isBlack = !isWhite;
                int repaintW = (arr[i - 1][j - 1] != (isWhite ? 'W' : 'B')) ? 1 : 0;
                int repaintB = (arr[i - 1][j - 1] != (isBlack ? 'W' : 'B')) ? 1 : 0;

                prefixW[i][j] = prefixW[i - 1][j] + prefixW[i][j - 1] - prefixW[i - 1][j - 1] + repaintW;
                prefixB[i][j] = prefixB[i - 1][j] + prefixB[i][j - 1] - prefixB[i - 1][j - 1] + repaintB;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = K; i <= N; i++){
            for(int j = K; j <= M; j++){
                int W = prefixW[i][j] - prefixW[i - K][j] - prefixW[i][j - K] + prefixW[i - K][j - K];
                int B = prefixB[i][j] - prefixB[i - K][j] - prefixB[i][j - K] + prefixB[i - K][j - K];
                min = Math.min(min, Math.min(W, B));
            }
        }
        wr.write(min + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
