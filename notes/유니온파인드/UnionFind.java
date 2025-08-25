package notes.유니온파인드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class UnionFind {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int n, m;
    int[] parent;
    int[] rank; // 트리의 높이 저장

    // find (경로 압축)
    int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    // union (rank 사용)
    void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;

        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }

    /*
     * rank가 중요하지 않을 때 아래처럼도 가능
     * 반환 타입 없어도 됨
     */
    // boolean union(int a, int b){
    //     a = find(a);
    //     b = find(b);
    //     if(a == b) return false; // 이미 같은 집합이므로 union 불가
    //     parent[b] = a;
    // }

    // void union(int a, int b){
    //     // 대표노드 찾아서 연결
    //     a = find(a);
    //     b = find(b);
    //     if(a != b){
    //         parent[b] = a;
    //     }
    // }

    // 같은 집합인지 확인
    boolean isSameSet(int a, int b) {
        return find(a) == find(b);
    }

    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else {
                if (isSameSet(a, b)) {
                    wr.write("YES\n");
                } else {
                    wr.write("NO\n");
                }
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new UnionFind().solution();
    }
}
