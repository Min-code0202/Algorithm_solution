for t in range(1, 11):
    N = int(input())
    building = list(map(int, input().split()))
    home = []

    for i in range(2, len(building) - 2):
        other = max(
            building[i - 2], building[i - 1], building[i + 1], building[i + 2]
        )
        if building[i] > other:
            view = building[i] - other
            home.append(view)

    ans = sum(home)
    print(f"#{t} {ans}")