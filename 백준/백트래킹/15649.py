N, M = map(int, input().split())

def search(c_num, depth):
	global ans
	if depth == M:
		ans[depth] = c_num
		result = ' '.join(map(str, ans))
		print(result[2:])
		return
	
	ans[depth] = c_num
	for i in range(1, N + 1):
		if visit[i] == 0:
			visit[i] = 1
			search(i, depth + 1)
			visit[i] = 0
		
	

ans = [0] * (M + 1)
visit = [0] * (N + 1)
search(0, 0)