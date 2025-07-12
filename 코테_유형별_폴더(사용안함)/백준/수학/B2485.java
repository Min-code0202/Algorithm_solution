import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2485 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int getGCD(int a, int b) {
        if (a % b == 0)
            return b;
        return getGCD(b, a % b);
    }

    public B2485() throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] tree = new int[N];

        for (int i = 0; i < N; i++)
            tree[i] = Integer.parseInt(br.readLine());

        int gcd = tree[1] - tree[0];
        for (int i = 2; i < N - 1; i++) {
            int distance = tree[i + 1] - tree[i];
            gcd = getGCD(distance, gcd);
        }

        wr.write((tree[N - 1] - tree[0]) / gcd + 1 - (tree.length) + "");

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B2485();
    }
}
