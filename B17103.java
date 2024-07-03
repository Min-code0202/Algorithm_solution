import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B17103 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean[] isPrime;

    void isPrime_fun(int n) {
        isPrime = new boolean[n + 1]; // 소수인지 저장하는 배열
        Arrays.fill(isPrime, true); // true로 배열 초기화
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

        for (int i = 2; i <= Math.sqrt(n); i++) { // 2부터 n의 제곱근까지 모든 수 확인
            if (isPrime[i]) { // 해당 수가 소수라면, 해당 수를 제외한 배수들을 false 처리
                for (int j = i * i; j <= n; j += i) // 그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
            }
        }
    }

    public B17103() throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0; // 골드바흐 파티션의 개수

            isPrime_fun(N); // N까지의 수 중 소수를 구함

            for (int i = 1; i <= N / 2; i++) {
                if (isPrime[i] && isPrime[N - i]) // i, N - i가 모두 소수라면 골드바흐에 해당한다.
                    cnt++;
            }
            wr.write(cnt + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws Exception {
        new B17103();
    }
}
