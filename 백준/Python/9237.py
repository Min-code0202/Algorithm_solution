if __name__ == "__main__":
    N = int(input())
    tree = list(map(int, input().split()))

    tree.sort(reverse=True)

    days = []
    for i in range(N):
        days.append((i + 1) + tree[i])

    print(max(days) + 1)