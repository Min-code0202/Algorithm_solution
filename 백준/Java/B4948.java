import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B4948 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean[] isPrime;

    void isPrime_fun(int n) {
        isPrime = new boolean[2 * n + 1]; // 소수인지 저장하는 배열
        Arrays.fill(isPrime, true); // true로 배열 초기화
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님

        for (int i = 2; i <= Math.sqrt(2 * n); i++) { // 2부터 n의 제곱근까지 모든 수 확인
            if (isPrime[i]) { // 해당 수가 소수라면, 해당 수를 제외한 배수들을 false 처리
                for (int j = i * i; j <= 2 * n; j += i) // 그 이하의 수는 모두 검사했으므로 i*i부터 시작
                    isPrime[j] = false;
            }
        }
    }

    public B4948() throws Exception {
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            isPrime_fun(123456); // 123456까지 소수인 수 판별
            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i] == true)
                    cnt++;
            }

            wr.write(cnt + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws Exception {
        new B4948();
    }
}
