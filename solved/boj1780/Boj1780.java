import java.io.*;
import java.util.StringTokenizer;

public class Boj1780 {
    static int[][] arr;
    static int N;
    static int[] count = new int[3]; // -1, 0, 1 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0, N);

        // 결과 출력
        wr.write(count[0] + "\n" + count[1] + "\n" + count[2] + "\n");
        wr.flush();
        wr.close();
        br.close();
    }

    static void check(int si, int sj, int size){
        if(isSame(si, sj, size)){
            int num = arr[si][sj] + 1;
            count[num]++;
            return;
        }

        int newSize = size / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                check(si + i * newSize, sj + j * newSize, newSize);
            }
        }
    }

    static boolean isSame(int si, int sj, int size){
        int num = arr[si][sj];
        for(int i = si; i < si + size; i++){
            for(int j = sj; j < sj + size; j++){
                if(num != arr[i][j]) return false;
            }
        }
        return true;
    }
}
