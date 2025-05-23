T = int(input())
for t in range(1, T + 1):
    N, A, B = map(int, input().split())

    max_overlap = min(A, B)
    min_overlap = max(0, A + B - N)

    print(f"#{t} {max_overlap} {min_overlap}")
