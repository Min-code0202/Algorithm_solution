import sys
input = sys.stdin.readline

if __name__ == "__main__":
    N, M = map(int, input().split())
    num = list(map(int, input().split()))
    sum = [0]
    temp = 0

    for n in num:
        temp = temp + n
        sum.append(temp)

    result = ""
    for _ in range(M):
        i, j = map(int, input().split())
        result += str(sum[j] - sum[i - 1]) + "\n"

    print(result)