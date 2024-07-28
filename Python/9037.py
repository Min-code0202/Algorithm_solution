if __name__ == "__main__":
    T = int(input())
    result = ""
    for _ in range(T):
        N = int(input())
        candy = list(map(int, input().split()))
        cnt = 0  # 사이클 횟수

        while True:
            # 사탕의 개수를 짝수개로 만듦
            for i in range(N):
                if candy[i] % 2 == 1:
                    candy[i] += 1
            
            # 사탕 수가 모두 같다면 종료
            if len(set(candy)) == 1:
                result += str(cnt) + "\n"
                break
            
            # 옆 사람에게 나눠줌
            temp = [0] * N  # 옆사람에게 줄 사탕 수
            for i in range(N):
                temp[i] = candy[i] // 2

            for i in range(N):
                candy[i] = candy[i] // 2 + temp[(i - 1 + N) % N]

            cnt += 1

    print(result)