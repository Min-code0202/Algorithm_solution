w, h = map(int, input().split())
N = int(input())
location = []


def count(dr, dist):
    if dr == 1:
        return dist
    elif dr == 2:
        return w + h + (w - dist)
    elif dr == 3:
        return w + h + w + (h - dist)
    else:
        return w + dist


dr = dist = 0
for i in range(N + 1):
    if i == N:
        dr, dist = map(int, input().split())
    else:
        location.append(list(map(int, input().split())))

total = 0
dong_dist = count(dr, dist)
for i in range(N):
    store_dist = count(location[i][0], location[i][1])
    clock_dist = abs(dong_dist - store_dist)
    counterclock_dist = 2 * (w + h) - clock_dist
    total += min(clock_dist, counterclock_dist)

print(total)