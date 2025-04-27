T = int(input())

def dfs(S, G):
	stack = []
	stack.append(S)

	while stack:
		C = stack.pop()
		if C == G:
			return 1
		for n in graph[C]:
			stack.append(n)

	return 0
		

for t in range(1, T + 1):
	V, E = map(int, input().split())
	graph = [[] for _ in range(V + 1)]

	for _ in range(E):
		idx, value = map(int, input().split())
		graph[idx].append(value)

	S, G = map(int, input().split())

	ans = 0
	ans = dfs(S, G)
	print(f'#{t} {ans}')