import heapq

T = int(input())

def solve(si, sj, ei, ej):
    pq = []
    heapq.heappush(pq, (0, si, sj))
    dist = [[float('inf')] * N for _ in range(N)]
    dist[si][sj] = 0

    while pq:
        cost, ci, cj = heapq.heappop(pq)

        if (ci, cj) == (ei, ej):
            return dist[ei][ej]

        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and 0 <= nj < N:
                height_diff = max(0, arr[ni][nj] - arr[ci][cj])
                new_cost = cost + 1 + height_diff
                if dist[ni][nj] > new_cost:
                    dist[ni][nj] = new_cost
                    heapq.heappush(pq, (new_cost, ni, nj))

    return -1  # 도달 불가능한 경우

for t in range(1, T + 1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    ans = solve(0, 0, N-1, N-1)
    print(f'#{t} {ans}')
