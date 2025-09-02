import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj1932 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        new Boj1932().solution();
    }

    void solution() throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][500];
        for(int i = 1; i <= n; i++){
            String[] read = br.readLine().split(" ");
            int idx = 0;
            for(String str : read){
                arr[i][idx++] = Integer.parseInt(str);
            }
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                int pj = (j - 1 >= 0) ? j - 1 : 0;

                arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j], arr[i - 1][pj]);
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) ans = Math.max(ans, arr[n][i]);

        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
