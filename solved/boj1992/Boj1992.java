import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj1992 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1992().solution();
    }

    int[][] arr;

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            String read = br.readLine();
            int j = 0;
            for(char ch : read.toCharArray()){
                arr[i][j++] = ch - '0';
            }
        }

        zip(0, 0, N, N);

        wr.flush();
        br.close();
        wr.close();
    }

    void zip(int si, int sj, int ei, int ej) throws IOException{
        if(check(si, sj, ei, ej, 0)){
            wr.write("0");
            return;
        }
        if(check(si, sj, ei, ej, 1)){
            wr.write("1");
            return;
        }
        wr.write("(");
        int mi = (si + ei) / 2;
        int mj = (sj + ej) / 2;
        zip(si, sj, mi, mj);
        zip(si, mj, mi, ej);
        zip(mi, sj, ei, mj);
        zip(mi, mj, ei, ej);
        wr.write(")");
    }

    boolean check(int si, int sj, int ei, int ej, int n){
        for(int i = si; i < ei; i++){
            for(int j = sj; j < ej; j++){
                if(arr[i][j] != n){
                    return false;
                }
            }
        }
        return true;
    }
}
