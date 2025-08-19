import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Swea2805 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea2805().solution();
    }

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++){
                String read = br.readLine();
                int j = 0;
                for(char ch : read.toCharArray()){
                    arr[i][j++] = ch - '0';
                }
            }

            int sum = 0;
            int mid = N/2;
            for(int i = 0; i < mid; i++){
                for(int j = mid - i; j <= mid + i; j++){
                    sum += arr[i][j];
                }
            }
            for(int i = mid; i < N; i++){
                for(int j = i - mid; j <= (N - 1) - (i - mid); j++){
                    sum += arr[i][j];
                }
            }

            wr.write("#" + tc + " " + sum + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }
}
