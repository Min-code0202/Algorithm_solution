import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920Loop {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1920Loop().solution();
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
        while (s <= e) {
            int mid = (s + e) / 2;
            if (A[mid] == target) {
                return 1;
            } else if (A[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return 0;
    }
}
