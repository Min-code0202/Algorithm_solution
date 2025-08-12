import java.util.Arrays;

public class BitMasking {

    static int N = 3;
    static int[] input = {2, 3, 1};
    static int[] numbers = new int[N]; // 순열을 저장할 배열

    public static void main(String[] args) {
        System.out.println("순열");
        perm(0, 0);

        System.out.println("사전순 순열");
        Arrays.sort(input); // 오름차순 정렬
        perm(0, 0);
    }

    /**
     * @param cnt: 현재까지 뽑은 원소의 개수 (depth)
     * @param flag: 사용된 원소의 상태를 나타내는 비트마스크
     */
    public static void perm(int cnt, int flag) {
        // Base Case: 순열이 완성되면 (cnt가 N과 같아지면)
        if (cnt == N) {
            // 순열 출력
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
            return;
        }

        // Recursive Step: 순열을 생성하는 단계
        for (int i = 0; i < N; i++) {
            // i번째 원소를 이미 사용했는지 체크
            // (flag & (1 << i)) != 0 : i번째 비트가 1이면(사용했으면)
            if ((flag & (1 << i)) != 0) {
                continue; // 다음 원소로 넘어감
            }

            // i번째 원소를 사용하지 않았다면
            // 1. 현재 자리에 i번째 원소 사용
            numbers[cnt] = input[i];

            // 2. 재귀 호출: 다음 원소를 뽑으러 감
            // cnt + 1: 다음 깊이로 이동
            // flag | (1 << i): i번째 원소를 사용했다고 체크
            perm(cnt + 1, flag | (1 << i));
        }
    }
}