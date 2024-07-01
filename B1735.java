import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class B1735 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int getGCD(int a, int b) {
        if (a % b == 0)
            return b;
        return getGCD(b, a % b);
    }

    public B1735() throws IOException {
        int[] fraction = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] fraction2 = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int numerator = fraction[0] * fraction2[1] + fraction[1] * fraction2[0];
        int denominator = fraction[1] * fraction2[1];

        int gcd = getGCD(numerator, denominator);

        StringBuilder sb = new StringBuilder();
        numerator /= gcd;
        denominator /= gcd;
        sb.append(numerator).append(" ").append(denominator);
        System.out.println(sb);

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B1735();
    }
}
