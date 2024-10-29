if __name__ == "__main__":
    n = int(input())
    dp = [0, 1]

    for i in range(2, n + 1):
        least = 4
        j = 1
        while (j**2) <= i:
            least = min(least, dp[i - j**2])
            j += 1
        dp.append(least + 1)

    print(dp[n])