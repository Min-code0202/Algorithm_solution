import java.io.*;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] charge = new int[N];
        for (int i = 0; i < N; i++) {
            charge[i] = Integer.parseInt(st.nextToken());
        }

        long cost = 0;               
        int prev = charge[0];        

        for (int i = 0; i < N - 1; i++) {
            if (charge[i] < prev) {  
                prev = charge[i];
            }
            cost += (long) prev * dist[i];
        }

        wr.write(cost + "\n");
        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
