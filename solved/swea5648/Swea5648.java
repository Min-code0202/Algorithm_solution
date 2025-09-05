import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Swea5648{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea5648().solution();
    }

    class Atom implements Comparable<Atom>{
        int x, y, dir, e;

        public Atom(int x, int y, int dir, int e) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.e = e;
        }

        @Override
        public int compareTo(Atom o) {
            // x 좌표보다 작은 순, 같다면 y좌표가 작은순
            return (this.x < o.x) ? -1 : ((this.x != o.x) ? Integer.compare(this.x, o.x) : Integer.compare(this.y, o.y));
        }
        
    }

    class Pair implements Comparable<Pair>{ // 충돌리스트에 담을 충돌하는 두 원자와 시간정보
        int i, j, time;

        public Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.time, o.time);
        }
    }

    int N;
    ArrayList<Atom> list;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list.add(new Atom(x, y, d, e));
            }
            System.out.println("#" + tc + " " + makeBoomPair());
        }
    }

    int makeBoomPair(){
        Collections.sort(list);
        ArrayList<Pair> boomList = new ArrayList<>();
        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                Atom a = list.get(i);
                Atom b = list.get(j);

                // 수직에서 만날 때
                if(a.x == b.x){
                    if(a.dir == 0 && b.dir == 1){
                        boomList.add(new Pair(i, j, Math.abs(a.y - b.y) / 2));
                    }
                }
                // 수평에서 만날 때
                if(a.y == b.y){
                    if(a.dir == 3 && b.dir == 2){
                        boomList.add(new Pair(i, j, Math.abs(a.x - b.x) / 2));
                    }
                }
                // '/' 대각선에서 만날 때
                if(a.x - b.x == a.y - b.y){
                    if(a.dir == 3 && b.dir == 1 || a.dir == 0 && b.dir == 2){
                        boomList.add(new Pair(i, j, Math.abs(a.x - b.x)));
                    }
                }
                // '\' 대각선에서 만날 때
                if(a.x + a.y == b.x + b.y){
                    if(a.dir == 1 && b.dir == 2 || a.dir == 3 && b.dir == 0){
                        boomList.add(new Pair(i, j, Math.abs(a.x - b.x)));
                    }
                }
            }
        }
        return getTotalEnerge(boomList);
    }

    int getTotalEnerge(ArrayList<Pair> boomList){
        Collections.sort(boomList);
        int INF = 1_000_000_000;
        int boomTimes[] = new int[N];
        Arrays.fill(boomTimes, INF);
        int sum = 0;

        for(Pair p : boomList){
            if(boomTimes[p.i] < p.time || boomTimes[p.j] < p.time) continue;
            
            if(boomTimes[p.i] == INF){
                boomTimes[p.i] = p.time;
                sum += list.get(p.i).e;
            }
            if(boomTimes[p.j] == INF){
                boomTimes[p.j] = p.time;
                sum += list.get(p.j).e;
            }
        }
        return sum;
    }
}