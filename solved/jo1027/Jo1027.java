import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jo1027 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Jo1027().solution();
    }

    int N;
    int[] arr;
    boolean finished = false;

    void dfs(int ci){
        if(finished) return;

        if(ci == N + 1){
            for(int i = 1; i <= N; i++){
                System.out.print(arr[i]);
            }
            finished = true;
            return;
        }

        for(int num = 1; num <= 3; num++){
            arr[ci] = num;
            if(isGood(ci)){
                dfs(ci + 1);
            }
        }
    }

    boolean isGood(int idx){
        for(int len = 1; len <= idx/2; len++){
            boolean same = true;

            for(int t = 0; t < len; t++){
                if(arr[idx - t] != arr[idx - len - t]){
                    same = false;
                    break;
                }
            }

            if(same) return false;
        }

        return true;
    }

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        dfs(1);

        br.close();
    }
}
