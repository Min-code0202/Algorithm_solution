import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea1873 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea1873().solution();
    }

    int H, W;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            char[][] arr = new char[H][W];

            // 시작 탱크 위치와 방향(0, 1, 2, 3) 순서대로 위 오른 아래 왼
            int ti = -1;
            int tj = -1;
            int dr = -1;

            for(int i = 0; i < H; i++){
                int j = 0;
                char[] read = br.readLine().toCharArray();
                for(char ch : read){
                    arr[i][j] = ch;
                    if(ch == '^'){
                        dr = 0;
                        ti = i;
                        tj = j;
                    }else if(ch == '>'){
                        dr = 1;
                        ti = i;
                        tj = j;
                    }else if(ch == 'v'){
                        dr = 2;
                        ti = i;
                        tj = j;
                    }else if(ch == '<'){
                        dr = 3;
                        ti = i;
                        tj = j;
                    }
                    j += 1;
                }
            }

            int N = Integer.parseInt(br.readLine());
            String order = br.readLine();

            int ni = -1;
            int nj = -1;
            for(char ch : order.toCharArray()){
                switch(ch){
                    case 'U':
                    ni = ti - 1;
                    nj = tj;
                    if(0 <= ni && ni < H && arr[ni][nj] == '.'){ // 위쪽이 평지라면 탱크 위치 이동
                        arr[ti][tj] = '.';
                        ti = ni;
                        tj = nj;
                    }
                    arr[ti][tj] = '^';
                    dr = 0;
                    break;
                    case 'D':
                    ni = ti + 1;
                    nj = tj;
                    if(0 <= ni && ni < H && arr[ni][nj] == '.'){ // 아래쪽이 평지라면 탱크 위치 이동
                        arr[ti][tj] = '.';
                        ti = ni;
                        tj = nj;
                    }
                    arr[ti][tj] = 'v';
                    dr = 2;
                    break;
                    case 'L':
                    ni = ti;
                    nj = tj - 1;
                    if(0 <= nj && nj < W && arr[ni][nj] == '.'){ // 왼쪽이 평지라면 탱크 위치 이동
                        arr[ti][tj] = '.';
                        ti = ni;
                        tj = nj;
                    }
                    arr[ti][tj] = '<';
                    dr = 3;
                    break;
                    case 'R':
                    ni = ti;
                    nj = tj + 1;
                    if(0 <= nj && nj < W && arr[ni][nj] == '.'){ // 오른쪽이 평지라면 탱크 위치 이동
                        arr[ti][tj] = '.';
                        ti = ni;
                        tj = nj;
                    }
                    arr[ti][tj] = '>';
                    dr = 1;
                    break;
                    case 'S':
                    shooting(dr, ti, tj, arr);
                    break;
                }
                // System.out.println("명령어 실행" + ch);
                // for(int i = 0; i < H; i++){
                //     System.out.println(Arrays.toString(arr[i]));
                // }
            }
            wr.write("#" + tc + " ");
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    wr.write(arr[i][j]);
                }
                wr.write("\n");
            }
        }
        wr.flush();
        br.close();
        wr.close();
    }

    void shooting(int dr, int ci, int cj, char[][] arr){
        if(dr == 0){ // 위
            while(true){
                int ni = ci - 1;
                int nj = cj;
                if(!(0 <= ni && ni < H)){
                    return;
                }

                if(arr[ni][nj] == '*'){
                    arr[ni][nj] = '.';
                    return;
                }else if(arr[ni][nj] == '#'){
                    return;
                }
                ci = ni;
                cj = nj;
            }
        }
        if(dr == 1){ // 오른
            while(true){
                int ni = ci;
                int nj = cj + 1;
                if(!(0 <= nj && nj < W)){
                    return;
                }

                if(arr[ni][nj] == '*'){
                    arr[ni][nj] = '.';
                    return;
                }else if(arr[ni][nj] == '#'){
                    return;
                }
                ci = ni;
                cj = nj;
            }
        }
        if(dr == 2){ // 아래
            while(true){
                int ni = ci + 1;
                int nj = cj;
                if(!(0 <= ni && ni < H)){
                    return;
                }

                if(arr[ni][nj] == '*'){
                    arr[ni][nj] = '.';
                    return;
                }else if(arr[ni][nj] == '#'){
                    return;
                }
                ci = ni;
                cj = nj;
            }
        }
        if(dr == 3){ // 왼
            while(true){
                int ni = ci;
                int nj = cj - 1;
                if(!(0 <= nj && nj < W)){
                    return;
                }

                if(arr[ni][nj] == '*'){
                    arr[ni][nj] = '.';
                    return;
                }else if(arr[ni][nj] == '#'){
                    return;
                }
                ci = ni;
                cj = nj;
            }
        }
    }
}
