def min_squares_sum(n):
    global dp
    if dp[n] != float("inf"):
        return dp[n]

    for i in range(1, int(n ** 0.5) + 1):
        cnt = min_squares_sum(n - i * i) + 1
        dp[n] = min(dp[n], cnt)

    return dp[n]


if __name__ == "__main__":
    n = int(input())

    dp = [float("inf")] * (n + 1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    
    print(min_squares_sum(n))