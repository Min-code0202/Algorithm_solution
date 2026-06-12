import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    int N, A;
    char[] S;

    TreeSet<Integer> set;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        set = new TreeSet<>();

        char[] input = br.readLine().toCharArray();

        S = new char[N + 2];

        S[0] = 'X';
        S[N + 1] = 'X';

        for(int i = 1; i <= N; i++){
            S[i] = input[i - 1];
            if(S[i] == '#') set.add(i);
        }

        set.add(0);
        set.add(N + 1);

        S[A] = '>';

        long time = 0;
        int d = 1;

        while(set.size() > 2){
            int nxt;

            if(d == 1){
                nxt = set.higher(A);
            }else{
                nxt = set.lower(A);
            }

            time += Math.abs(A - nxt);
            A = nxt;

            if(nxt == 0 || nxt == N + 1){
                d *= -1;
            }else{
                set.remove(nxt);
                d *= -1;
            }
        }

        System.out.println(time);
    }
}