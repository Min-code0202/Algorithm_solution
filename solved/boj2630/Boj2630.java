import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2630 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj2630().solution();
    }

    int arr[][], W, B;

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        W = B = 0;
        divide(0, 0, N, N);

        wr.write(W + "\n" + B);

        wr.flush();
        br.close();
        wr.close();
    }

    void divide(int si, int sj, int ei, int ej){
        if(isWhite(si, sj, ei, ej)){
            W++;
            return;
        }
        if(isBlue(si, sj, ei, ej)){
            B++;
            return;
        }

        int mi = (si + ei) / 2;
        int mj = (sj + ej) / 2;
        divide(si, sj, mi, mj);
        divide(si, mj, mi, ej);
        divide(mi, sj, ei, mj);
        divide(mi, mj, ei, ej);
    }

    boolean isWhite(int si, int sj, int ei, int ej){
        for(int i = si; i < ei; i++){
            for(int j = sj; j < ej; j++){
                if(arr[i][j] == 1){
                    return false;
                }
            }
        }

        return true;
    }

    boolean isBlue(int si, int sj, int ei, int ej){
        for(int i = si; i < ei; i++){
            for(int j = sj; j < ej; j++){
                if(arr[i][j] == 0){
                    return false;
                }
            }
        }

        return true;
    }
}
