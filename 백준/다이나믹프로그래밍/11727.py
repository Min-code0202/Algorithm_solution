dp = [0] * 1001


def tiling(n):
    if dp[n] > 0:
        return dp[n]

    dp[n] = (2 * tiling(n - 2) + tiling(n - 1)) % 10007
    return dp[n]


if __name__ == "__main__":

    dp[1] = 1
    dp[2] = 3

    n = int(input())
    result = tiling(n)
    print(result)