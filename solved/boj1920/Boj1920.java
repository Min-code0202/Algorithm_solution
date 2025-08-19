import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1920().solution();
    }

    int[] A;

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            int ans = binarySearch(0, N - 1, target);
            wr.write(ans + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    int binarySearch(int s, int e, int target){
        if (s > e) return 0;

        int mid = (s + e) / 2;
        if (A[mid] == target) return 1;
        else if (A[mid] > target) return binarySearch(s, mid - 1, target);
        else return binarySearch(mid + 1, e, target);
    }
}
