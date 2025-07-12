T = int(input())

def solve(ci):
	global ans
	if v[ci] == 1:
		return
	v[ci] = 1
	stack = []
	stack.append(ci)

	while stack:
		ci = stack.pop()
		for node in graph[ci]:
			if v[node] == 0:
				stack.append(node)
				v[node] = 1

	ans += 1

for t in range(1, T + 1):
	N, M = map(int, input().split())
	arr = list(map(int, input().split()))

	graph = [[] for _ in range(N + 1)]
	for i in range(0, len(arr), 2):
		graph[arr[i]].append(arr[i + 1])
		graph[arr[i + 1]].append(arr[i])

	ans = 0
	v = [0] * (N + 1)
	for i in range(1, N + 1):
		solve(i)

	print(f'#{t} {ans}')