import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SegmentTree{
    static int N; // 원소 개수
    static long[] arr; // 입력 배열
    static long[] tree; // 세그먼트 트리
    static long[] lazy; // lazy propagation용(필요할 때만 사용)

    // =============================
    // 초기화
    // =============================
    static long init(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(node*2, start, mid) + init(node*2 + 1, mid + 1, end);
    }

    // =============================
    // 단일 원소 업데이트 (arr[index] = newValue)
    // diff = (newValue - oldValue)
    // =============================
    static void update(int node, int start, int end, int index, long diff){
        if(index < start || index > end) return;
        tree[node] += diff;
        if(start != end){
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }

    // =============================
    // 구간 합 조회 (left ~ right)
    // =============================
    static long query(int node, int start, int end, int left, int right){
        if(right < start || end < left) return 0; // 겹치지 않음
        if(left <= start && end <= right) return tree[node]; // 완전히 포함
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right)
                + query(node * 2 + 1, mid + 1, end, left, right);
    }

    // =============================
    // 구간 업데이트 (Lazy Propagation)
    // [l, r] 범위에 value 더하기
    // =============================
    static void updateRange(int node, int start, int end, int l, int r, long value) {
        // 이전에 밀린 lazy 값 처리
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (r < start || end < l) return; // 범위 밖

        if (l <= start && end <= r) { // 완전히 포함
            tree[node] += (end - start + 1) * value;
            if (start != end) {
                lazy[node*2] += value;
                lazy[node*2+1] += value;
            }
            return;
        }

        int mid = (start + end) / 2;
        updateRange(node*2, start, mid, l, r, value);
        updateRange(node*2+1, mid+1, end, l, r, value);
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    // =============================
    // 구간 합 조회 (Lazy Propagation 버전)
    // =============================
    static long queryRange(int node, int start, int end, int l, int r) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }

        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;
        return queryRange(node*2, start, mid, l, r)
                + queryRange(node*2+1, mid+1, end, l, r);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        tree = new long[4 * N];
        lazy = new long[4 * N];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        init(1, 1, N);

        update(1, 1, N, 2, 5);
        System.out.println(query(1, 1, N, 1, 3));
        updateRange(1, 1, N, 1, 3, 10);
        System.out.println(queryRange(1, 1, N, 1, 3));
    }
}