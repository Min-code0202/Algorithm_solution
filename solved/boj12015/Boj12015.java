import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj12015 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj12015().solution();
    }

    int N;
    int[] A;
    int[] LIS;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        LIS = new int[N + 1];
        int len = 0;
        for(int i = 0; i < N; i++){
            System.out.println("i = " + i);
            if(LIS[len] < A[i]){
                LIS[++len] = A[i];
            }else{
                int idx = binary(0, len, A[i]);
                LIS[idx] = A[i];
                System.out.println("idx = " + idx);
            }
            System.out.println("len : " + len);
            System.out.println(Arrays.toString(LIS));
            System.out.println("=================");
        }
        wr.write(len + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    int binary(int l, int r, int target){
        while(l < r){
            int mid = (l + r) / 2;
            if(LIS[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return r;
    }
}
