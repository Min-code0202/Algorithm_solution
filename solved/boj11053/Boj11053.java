import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Boj11053 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj11053().solution();
    }

    int[] sub;

    int binarySearch(int left, int right, int target){
        while(left < right){
            int mid = (left + right) / 2;
            if(sub[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        sub = new int[N + 1];
        sub[0] = A[0];
        int j = 0;
        int i = 1;

        while(i < N){
            if(sub[j] < A[i]){
                sub[j + 1] = A[i];
                j += 1;
            }
            else{
                int idx = binarySearch(0, j, A[i]);
                sub[idx] = A[i];
            }
            i += 1;
        }

        wr.write(j + 1 + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
