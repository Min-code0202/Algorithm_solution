package boj12891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj12891 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj12891().solution();
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();

        int[] arr = new int[4]; 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) { 
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int[] cur = new int[4]; 

        for (int i = 0; i < P; i++) {
            add(cur, DNA.charAt(i));
        }
        if (check(cur, arr)) ans++;

        for (int i = P; i < S; i++) {
            add(cur, DNA.charAt(i)); 
            remove(cur, DNA.charAt(i - P));  
            if (check(cur, arr)) ans++;
        }

        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    void add(int[] cur, char ch) {
        if (ch == 'A') cur[0]++;
        else if (ch == 'C') cur[1]++;
        else if (ch == 'G') cur[2]++;
        else if (ch == 'T') cur[3]++;
    }

    void remove(int[] cur, char ch) {
        if (ch == 'A') cur[0]--;
        else if (ch == 'C') cur[1]--;
        else if (ch == 'G') cur[2]--;
        else if (ch == 'T') cur[3]--;
    }

    boolean check(int[] cur, int[] arr) {
        for (int i = 0; i < 4; i++) {
            if (cur[i] < arr[i]) return false;
        }
        return true;
    }
}

