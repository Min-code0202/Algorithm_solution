dp = [0] * 101


def P(N):
    global dp
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    if dp[N] != 0:
        return dp[N]
    dp[N] = P(N - 2) + P(N - 3)
    return dp[N]


if __name__ == "__main__":
    T = int(input())
    result = ""
    for _ in range(T):
        N = int(input())
        length = P(N)
        result += str(length) + "\n"

    print(result)
